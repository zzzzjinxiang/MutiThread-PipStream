package printInOrder;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class thread {

    public static void main(String[] args) {
        thread example = new thread();

        LetterPrinter letterPrinter = example.new LetterPrinter();

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(example.new PrintRunnable(letterPrinter, 'A'));
        service.execute(example.new PrintRunnable(letterPrinter, 'B'));
        service.execute(example.new PrintRunnable(letterPrinter, 'C'));

        service.shutdown();
    }

    private class LetterPrinter {
        private char letter = 'A';

        public void print() {
            System.out.println(letter);
            if ('C' == letter) {
                System.out.println();
            }
        }

        public void nextLetter() {
            switch (letter) {
                case 'A':
                    letter = 'B';
                    break;
                case 'B':
                    letter = 'C';
                    break;
                case 'C':
                    letter = 'A';
                    break;
            }
        }

        /**
         * @return the letter
         */
        public char getLetter() {
            return letter;
        }

    }

    private class PrintRunnable extends Thread {

        private LetterPrinter letterPrinter = null;

        private char letter = ' ';

        /**
         * @param letterPrinter
         * @param letter
         */
        public PrintRunnable(LetterPrinter letterPrinter, char letter) {
            super();
            this.letterPrinter = letterPrinter;
            this.letter = letter;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (letterPrinter) {
                    while (letter != letterPrinter.getLetter()) {
                        try {
                            letterPrinter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    letterPrinter.print();
                    letterPrinter.nextLetter();
                    letterPrinter.notifyAll();

                }
            }

        }

    }

}

