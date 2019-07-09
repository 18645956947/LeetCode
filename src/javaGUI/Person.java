package javaGUI;

public class Person implements Animal{
    protected int age = 15;
    protected String sex = "男";

    @Override
    public void move() {
        System.out.println("会跑步");
    }

    @Override
    public void hit() {
        System.out.println("人类的武器是头脑");
    }
}
