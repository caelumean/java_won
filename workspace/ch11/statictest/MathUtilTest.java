package ch11.statictest;

public class MathUtilTest {
    void add10(int n1){
        System.out.println(n1 + 10);
    }
    int n2 = 20;
    void addN2(int n1){
        System.out.println(n1 + n2);
    }
    public static void main(String[] args){
        // static은 new해서 인스턴스화해서 만들어서 쓰지만
        // 그렇게 안하고도 접근해서 쓸 수 있도록 하는것이 static이다.
        // MathUtil m = new MathUtil();
        // 반지름이 5인 원의 넓이는 xx입니다.
        double area = MathUtil.PI * 5 * 5;
        System.out.println("반지름 5인 원의 넓이는 " + area + " 입니다." );

        System.out.println(" 3 + 5 = " + MathUtil.add(3,5));

    }
}
