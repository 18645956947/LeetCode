package javaGUI;

public class Card implements Animal{

    protected int age = 11;
    protected String sex = "����";



    @Override
    public void move() {

        System.out.println("������");
    }

    @Override
    public void hit() {
        System.out.println("���ʹ���������");
    }
}
