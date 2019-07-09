package javaGUI;

public class Card implements Animal{

    protected int age = 11;
    protected String sex = "雌性";



    @Override
    public void move() {

        System.out.println("鸟儿会飞");
    }

    @Override
    public void hit() {
        System.out.println("鸟儿使用嘴来打击");
    }
}
