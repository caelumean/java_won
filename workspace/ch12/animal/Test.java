package ch12.animal;


// 1. 자식 is a 부모
// 2. 부모는 일반화 자식은 특별화
public class Test {

    public static void main(String[] args){
         Dog haru = new Dog();

        // 상속관계에 있다면 자식 인스턴스를 부모 타입으로 선언 가능하다
//        Animal haru = new Dog();
//        haru.eat();     // 부모에게 물려받은 메서드
//        haru.bark();    // 추가한 메서드

        // 상속관계에 있으면 타입이 호환이 된다.
        // 강아지는 동물이다.
//        animalCare(haru);

        // 자식인스턴스를 부모타입으로 형변환하는게 가능하다.
//        animalCare((Animal)haru);

        // is-a 관계가 성립되지 않은 잘못된 상속
//        Notebook book = new Notebook();
//        animalCare(book);

        Cat c = new Cat();
        animalCare(c);

    }

    // 동물 관리 서비스
    // 다형성
    // 과거의 코드가 미래에도 쓸 수 있게 하는 것
    // Animal.eat()를 호출하는 동일한 코드지만
    // 실제 생성된 객체의 오버라이딩 된 메서드가 호출됨
    static void animalCare(Animal a){
        a.eat();
        a.sleep();
        a.move();
    }
}
