package ch05;

public class TypeCastingTest
{
    static void main()
    {
        int a = 2100000000;
        // 자동형변환(a가 double로 변환)
        // 명시적 형변환이 필요없음(a를 double로 변환, int -> double)
        double b = a;

        System.out.println(a);
        System.out.println(b);

        double pi = 3.14;
        // 명시적 형변환이 필요(pi를 int로 변환,double-> int)
        int p = (int)pi;

        System.out.println(pi);
        System.out.println(p);


        // 자동형변환
        // 큰 타입을 작은 타입에 넣는 것은 안되지만
        // 작은 타입을 큰 타입에 넣는 것은 가능하다.
        // 오른쪽 리터럴은 int형이지만 오류가 안나는 이유는
        // int형이 long타입보다 작아서 자동으로 형변환되는데에
        // 문제가 없기 때문이다.
        long bigNum1 = 100000;
        System.out.println(bigNum1);

        // 명시적 형변환
        int num1= (int)10000000000L;
        System.out.println(num1);

    }
}
