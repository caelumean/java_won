package ch10;

public class VaragesTest
{
    // int 2개의 합계를 출력하는 메서드
    void sum(int n1,int n2)
    {
        System.out.println("2. sum 메서드 시작");
        int result = n1 + n2;
        System.out.println("3"+n1 + " + " + n2 + " = " + result);
        System.out.println("4 sum 메서드 종료");

    }
    // int 3개의 합계를 출력하는 메서드
    void sum(int n1,int n2,int n3)
    {
        int result = n1 + n2 + n3;
        System.out.println(+n1 + " + " + n2 + " + "+ n3 + " = " + result);

    }
    // int 4개의 합계를 출력하는 메서드
    void sum(int n1,int n2,int n3,int n4)
    {
        int result = n1 + n2 + n3 + n4;
        System.out.println(+n1 + " + " + n2 + " + "+ n3 + " + " + n4 + " = " + result);

    }

    void sum(int... nums)
    {
        int result = 0;
        for(int num: nums)
        {
            result += num;
        }
        System.out.println("합: " +result);
    }
    void main()
    {
        System.out.println("1. main 메서드 시작");
        sum(10,20);
        sum(10,20,30);
        sum(10,20,30,40);
        System.out.println("5. main 메서드 종료");

    }
}
