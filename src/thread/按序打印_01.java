package thread;

/**
 * leetcode -- 1114. �����ӡ
 * ����һ��ʹ���ֶ���������
 * @author zhx
 */
public class �����ӡ_01 {

    private boolean firstFinished ;
    private boolean secondFinished;
    //��ÿһ�������������
    private Object lock = new Object();

    public �����ӡ_01() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            // printSecond.run() outputs "second". Do not change or remove this line.
            while (!firstFinished){
                lock.wait();
            }
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            // printThird.run() outputs "third". Do not change or remove this line.
            while (!secondFinished){
                lock.wait();
            }
            printThird.run();
        }
    }

    public static void main(String[] args) {
        �����ӡ_01 a = new �����ӡ_01();
        Runnable printFirst = () -> {
            System.out.println("first");
        };
        Runnable printSecond = () -> {
            System.out.println("second");
        };
        Runnable printThird = () -> {
            System.out.println("third");
        };
        try {
            a.first(printFirst);
            a.second(printSecond);
            a.third(printThird);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
