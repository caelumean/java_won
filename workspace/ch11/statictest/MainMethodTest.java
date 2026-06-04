package ch11.statictest;

public class MainMethodTest {

    public void instanceMethod(){
        System.out.println("인스턴스 메서드 호출.");
    }
    public static void staticMethod(){
        System.out.println("static 메서드 호출.");
    }

    // Java 21 이전
//    public static void main(String[] args){
//        // main 메서드에서 외부 메서드를 호출하는 첫번째 방법
//        // static 메서드를 그냥 호출
//        staticMethod();
//
//        // 두번째 방법
//        // intstance를 먼저 생성한 수 호출
//        MainMethodTest m = new MainMethodTest();
//        m.instanceMethod();
//    }

    // Java 21 이후
    // 이 main은 static메서드가 아니라 인스턴스 메서드이기 때문에
    // 그냥 static메서드 이름만 써서 호출할 수 있다.
    void main(){
        staticMethod();
        instanceMethod();
    }
}
