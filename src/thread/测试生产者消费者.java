package thread;

public class ���������������� {
    public static int count = 0;
    public static String LOCK = "lock";
    public static final int FULL = 10;

    public static void main(String[] args) {
        ���������������� test = new ����������������();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();

    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "������������Ŀǰ�ܹ���" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "���������ѣ�Ŀǰ�ܹ���" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
