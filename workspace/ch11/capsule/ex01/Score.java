package ch11.capsule.ex01;

// 시험 결과를 관리하는 클래스
public class Score {

    int kor;
    int eng;
    int math;

    // 총점을 계산해서 반환하는 메서드
    private int sum(){
        int sum = kor + eng + math;

        return sum;
    }

    public double avg(){
        double avg = sum() / 3.0;
        avg = Math.round(avg * 100) / 100.0;

        return avg;
    }
}
