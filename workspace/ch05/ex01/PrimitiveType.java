package ch05.ex01;

public class PrimitiveType
{
    void main()
    {
        // 변수 : 데이터를 담는 곳.
        //       값을 할당해야한다.
        int age;    // 1. 변수 선언
        age = 25;   // 2. 변수에 값 할당

        System.out.println(age);

        age = 30;   // 변수에 값을 재할당
        System.out.println(age);

        int score = 100;    // 3. 변수 선언과 동시에 값 할당

        System.out.println("점수 : " +score);

        byte b = 127;   // byte 범위 밖을 벗어나면 안된다.
        System.out.println(b);

    }
}
