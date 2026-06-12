package ch09;

public class ArrayMemory
{
    public static void main(String[] args)
    {
        int age = 25;   // 기본 타입
        int[] scores = new int[3];  // 참조 타입

        // socres는 데이터 값을 가지고 있는 것이 아니라 그 데이터 값을 가지고 있는 주소를 담고 있다
        // 자바에선 주소와 비슷한 것을 가지고 있다.
        scores[0] = 90;

        System.out.println(age);
        System.out.println(scores);
        System.out.println(scores[0]);
    }
}
