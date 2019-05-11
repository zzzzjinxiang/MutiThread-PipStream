package printInOrder;

public class sleepExample extends Thread {
    private static int currentCount = 0;

    public sleepExample(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            switch (currentCount % 3) {
                case 0:
                    if ("A".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 1:
                    if ("B".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 2:
                    if ("C".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
            }
        }

    }

    private void printAndIncrease() {
        print();
        increase();
    }

    private void print() {
        System.out.print(Thread.currentThread().getName() + currentCount +" ");
        /*if ("C".equals(getName())) {
            System.out.println();
        }*/
    }

    private void increase() {
        currentCount++;
    }

    public static void main(String[] args) {
        new sleepExample("A").start();
        new sleepExample("B").start();
        new sleepExample("C").start();
    }

}

