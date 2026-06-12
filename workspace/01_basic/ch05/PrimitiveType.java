package ch05;

// 클래스 이름은 대문자로 하자
// 파일명과 클래스명이 항상 일치해야한다.
// 바꿀때는 탐색기에서 바꾸지말고
// Rename해서 바꾸면 연관되어있는 것들을 같이 바꿔준다.
public class PrimitiveType
{
    void main() // main 메서드 : 자바 프로그램의 시작점
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

        int num = 1000000000;
        System.out.println(num);

        long bigNum = 10000000000L;
        System.out.println(bigNum);

        float shortPi = 3.14F;
        System.out.println(shortPi);

        boolean isGood = true;
        System.out.println(isGood);

        boolean isMan = false;
        System.out.println(isMan);

        char grade = 'A';
        System.out.println(grade);

        grade = 'B';
        System.out.println(grade);

        // 문자열 : 2글자 이상의 문자들을 저장
        // 큰따옴표로 문자를 묶어서 표현
        String firstName = "멋쟁이";
        String lastName = "사자처럼";
        System.out.println(firstName);
        System.out.println(lastName);

        double pi = 3.141592;
        System.out.println(pi);

        // float타입에는 F를 붙인다
        float smallPi = 3.14F;
        System.out.println(smallPi);

        // final : 상수 선언
        // 이 값을 변경 못한다.
        // 상수인지 아닌지 구분하기 위해서 이름에 관료적으로 대문자로 쓴다.
        // 상수는 재할당을 할 수 없다.
        final double PI = 3.14;
        System.out.println( PI * 5 * 5);
    }
}
