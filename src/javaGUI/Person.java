package javaGUI;

public class Person implements Animal{
    protected int age = 15;
    protected String sex = "��";

    @Override
    public void move() {
        System.out.println("���ܲ�");
    }

    @Override
    public void hit() {
        System.out.println("�����������ͷ��");
    }
}
