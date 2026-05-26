package ch09;// 국어, 영어, 수학 점수를 이용해서 총점과 평균을 계산

public class ScoreTest
{
    public  static void main(String[] args)
    {
        int kor = 100;  // 국어 점수
        int eng = 90;   // 영어 점수
        int math = 85;  // 수학 점수

        int sum = kor + eng + math; // 총점
        double avg = sum / 3.0;  // 평균
        double avg1 = sum / 3.0;  // 평균
        double avg2 = sum / 3.0;  // 평균
        // avg = Math.round(avg);  // 소수 첫째자리 반올림, 92
        avg1 = Math.round(avg * 10); // 소수 둘째자리 반올림, 91.7
        avg2 = Math.round(avg *100);

        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);
        System.out.println("평균: " + avg1);
        System.out.println("평균: " + avg2);

    }
}
