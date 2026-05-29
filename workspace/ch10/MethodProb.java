package ch10;

public class MethodProb
{
    // 총점을 계산해서 반환하는 메서드
    int sum(int[] student)
    {
        int total = 0;

        for(int num : student)
        {
            total += num;
        }

        return total;
    }
    double avg(int[] scores)
    {
        int total = sum(scores);
        double scoreAvg = (double)total / scores.length;
        return scoreAvg;
    }
//    void printScore(int[] scores)
//    {
//        int total = sum(scores);
//        double scoreAvg = avg(scores);
//
//        System.out.println("최종 출력 결과");
//        System.out.println("총점: "+total + " 평균: "+ scoreAvg);
//    }

    // int[] 총점을 전달받아서 평균을 계산해서 반환하는 메서드
    double average(int sum, int subCount)
    {
        double avg = (double) sum/ subCount;

        return avg;
    }

    // int[] 점수를 전달받아서 총점 평균을 출력하는 메서드
    void printScore(int[] student,String name)
    {
        int sum = sum(student);
        double avg = average(sum, student.length);
        String studentName = name;

        System.out.print(studentName+" 총점: " + sum +" 평균: " + Math.round(avg * 100)/100.0 );
        System.out.println();
    }

    // 전체 총점
//    int totalSum()
//    {
//        int totalSum = 0;
//        totalSum = Sum();
//    }
    void main()
    {
        // haru는 국어, 영어, 수학 점수가 각각 80, 70, 56이다.
        // namu는 국어, 영어, 수학 점수가 각각 90, 77, 80이다.
        // brong이는 국어, 영어 수학 점수가 각각 100, 99, 88이다

        // 이 셋의 총점과 평균을 구해서 출력하세요
        int[] haruScore = {80, 70, 56};
        int[] namuScore = {90, 77, 80};
        int[] brongScore = {100, 99, 88};

        printScore(haruScore,"haru");
        printScore(namuScore,"namu");
        printScore(brongScore,"brong");

    }
}
