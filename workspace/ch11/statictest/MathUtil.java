package ch11.statictest;

public class MathUtil {

    // 상수
    // static 필드
    final static double PI = 3.141592;

    // 인스턴스 필드
    // static메서드 안에서 인스턴스 필드를 사용할 수 없는 이유는
    // 인스턴스 필드는 heap영역에서 만들어지는데 이건 new로 만들어야하는데
    // 그러면 static은 new안해도 만들 수 있는데 인스턴스 필드는 new로 해서 만들어지기 때문에
    // 모순이 생기기 때문에 static메서드에서 사용할 수 없다.
    // 매개변수는 상관이 없다.
    int r = 5;

    // 원의 반지름을 구한다.
    static void area(){
        // static메서드 안에서는 static 필드나 static 메서드만 참조할 수 있다.
        //System.out.println(PI * r * r);
    }
    // 메서드 내부에서 인스턴스 필드나 인스턴스 메서드를 사용하지 않을 경우에 static을 붙이면 된다.
    static int add(int n1, int n2){
        return n1 + n2;
    }


}
