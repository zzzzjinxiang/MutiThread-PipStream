package printInOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintThreadExample {

    public static void main(String[] args) {
        PrintThreadExample example = new PrintThreadExample();

        LetterPrinter letterPrinter = example.new LetterPrinter();

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(example.new PrintRunnable(letterPrinter, 'A'));
        service.execute(example.new PrintRunnable(letterPrinter, 'B'));
        service.execute(example.new PrintRunnable(letterPrinter, 'C'));

        service.shutdown();
    }

    private class LetterPrinter {
        private char letter = 'A';
        public int cnt = 0;

        public void print() {
            System.out.println(Thread.currentThread().getName()+": "+cnt);
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

    private class PrintRunnable implements Runnable {

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
            for (; letterPrinter.cnt < 100;letterPrinter.cnt ++) {
                synchronized (letterPrinter) {
                    while (letter != letterPrinter.getLetter()) {
                        try {
                            letterPrinter.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    if (letterPrinter.cnt>=100)
                        break;

                    letterPrinter.print();
                    letterPrinter.nextLetter();
                    letterPrinter.notifyAll();

                }
            }

        }

    }

}
