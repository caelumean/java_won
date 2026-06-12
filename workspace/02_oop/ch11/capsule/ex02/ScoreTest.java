package ch11.capsule.ex02;

public class ScoreTest {
    public static void main(String[] args){
        Score haru = new Score(100, 90, 85);

        // int haruSum = haru.sum();
        double haruAvg = haru.avg();
        // System.out.println("하루의 총점: " + haruSum);
        System.out.println("하루의 평균: " + haruAvg);

        int haruBeforeMathScore = haru.getMath();
        haru.setMath(haruBeforeMathScore + 5);

        haru.setMath(haru.getMath() + 5);
    }
}
