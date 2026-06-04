package ch06;

public class OperatorTest
{
    static void main()
    {
        int num1 = 5;
        int num2 = 28;
        int num3;
        double num4;
        int num5;

        num3 = num2 * num1;
        // 밑에 결과물은 double인데
        // 이 결과물을 담는 곳은 int형이다
        // 그렇게 되면 값이 누락될 수 있다라고
        // error메세지가 뜨는 것이다.
        num4 = num2 / (double)num1;
        num5 = num2 % num1;

        System.out.println("28 * 5 = " + num3);
        System.out.println("28 / 5 = " + num4);
        System.out.println("28 % 5 = " + num5);

        System.out.println("++5 = " + ++num1);  // 6
        System.out.println("6++ = " + num1++);  // 6
        System.out.println("num1 = " + num1);   // 7

        int a = 3;
        boolean b = ++a + 10 >= 14 && 2 + 3 * ++a >=10;
        // b true
        // 5
        System.out.println(b);
        System.out.println(a);

        int c = 4 >> 2;

        System.out.println(" 4 >> 2 : "+ c);

    }
}
