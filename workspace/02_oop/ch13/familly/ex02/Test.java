package ch13.familly.ex02;

public class Test {
    public static void main(String[] args){

//        Parent p = new Parent("부모");
        // up-casting(자동형변환, 자식 -> 부모)
        // 자식이 부모클래스로 형변환
//        Parent p1 = new Son("아들");
//        Son p2 = new Son("아들");
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

        // p가 Son 인스턴스인지 여부를 체크
        // 이렇게 체크해야지 안전하게 할 수 있다.
        if(p instanceof Son){
            // down-casting(명시적 형변환, 부모->자식)
            // 부모가 자식클래스로 명시적 형변환
            Son s = (Son) p;
            s.study();
        }


        p.sleep();
    }

//    private static void dailySchedule(Son p){
//        p.eat();
//        p.play();
//        p.sleep();
//    }

//    private static void dailySchedule(Daughter p){
//        p.eat();
//        p.play();
//        p.sleep();
//    }
}
