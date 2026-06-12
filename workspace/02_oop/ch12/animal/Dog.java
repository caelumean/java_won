package ch12.animal;

public class Dog extends Animal{

    @Override
    void eat() {
        System.out.println("사료를 먹는다.");
    }

    void bark(){
        System.out.println("멍멍 짖는다.");
    }
}
