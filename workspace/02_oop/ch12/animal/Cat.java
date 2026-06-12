package ch12.animal;

public class Cat extends Animal{
    @Override
    void eat() {
        System.out.println("츄르를 먹는다.");
    }
    // 액체화
    void liquedfy(){
        System.out.println("유리병에 들어갑니다.");
    }
}
