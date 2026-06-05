package ch12.family.ex01;

public class Test {
    public static void main(String[] args){

//        Parent p = new Parent("부모");
//        Son p = new Son("아들");
        Daughter p = new Daughter("딸");
        dailySchedule(p);
    }
    // Parent p = new Parent()는 main 메서드 안에서만 있기 때문에
    // 찾지못하는 것이다. => 방법1. 매개변수로 Parent 타입을 받으면 된다.
    // 방법2. 인스턴스화를 필드에 선언한다.
    // 하루일과
    private static void dailySchedule(Parent p){
        p.eat();
        p.play();
        p.sleep();
    }

    private static void dailySchedule(Son p){
        p.eat();
        p.play();
        p.sleep();
    }

    private static void dailySchedule(Daughter p){
        p.eat();
        p.play();
        p.sleep();
    }
}
