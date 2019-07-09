package javaGUI;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Person();
        animal.hit();
        animal.move();
        System.out.println("------我是分割线-------");
        Animal animal1 = new Card();

        System.out.println(((Card) animal1).age);
        System.out.println(((Card) animal1).sex);
        animal1.hit();
        animal1.move();
    }
}
