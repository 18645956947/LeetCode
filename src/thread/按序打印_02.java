package thread;

import java.util.concurrent.CountDownLatch;

public class 按序打印_02 {

    CountDownLatch countDownLatch01;
    CountDownLatch countDownLatch02;

    public 按序打印_02() {
        countDownLatch01 = new CountDownLatch(1);
        countDownLatch02 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        countDownLatch01.countDown();
    }
    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch01.await();
        printSecond.run();
        countDownLatch02.countDown();
    }
    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch02.await();
        printThird.run();
    }

    public static void main(String[] args) {
        按序打印_02 a = new 按序打印_02();
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
