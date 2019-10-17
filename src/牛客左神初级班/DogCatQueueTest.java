package ţ�����������;

import javaGUI.Person;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ʵ��һ��è�����еĽṹ��Ҫ�����£�
 * add()��dog����cat���ʵ�����������
 * pollDog()�ѹ����е����Ƚ���ĵ�����
 * pollCat()��è���е����Ƚ���ĵ�����
 * isEmpty() ���������Ƿ���dog����cat��ʵ��
 * isCatEmpty���������Ƿ���cat��ʵ��
 * isDogEmpty���������Ƿ���dog��ʵ��
 */
public class DogCatQueueTest {

    public static class Pet {
        String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {

        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {

        public Cat() {
            super("cat");
        }

    }

    public static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue {
        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;
        private long count;

        public DogCatQueue() {
            this.dogQ = new LinkedList<>();
            this.catQ = new LinkedList<>();
            this.count = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                this.dogQ.add(new PetEnter(pet, this.count++));
            } else if (pet.getPetType().equals("cat")) {
                this.catQ.add(new PetEnter(pet, this.count++));
            } else {
                throw new RuntimeException("input is not dog or cat");
            }
        }

        public Pet pollAll() {
            if (!dogQ.isEmpty() && !catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() > this.catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("queue is empty");
            }
        }


        public Dog pollDog() {
            if (!this.dogQ.isEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else
                throw new RuntimeException("dog queue is null");
        }

        public Cat pollCat() {
            if (!this.catQ.isEmpty()) {
                return (Cat) this.catQ.poll().getPet();
            } else
                throw new RuntimeException("cat queue is null");
        }

        public boolean isEmpty() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQ.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        /*test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);*/
        while (!test.isDogQueueEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}