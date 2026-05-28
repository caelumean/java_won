package ch09;

public class EnhancedFor
{
    public static void main(String[] args)
    {
//      int[] scores = {90, 80, 75};    // 3과목
        int[] socres = {100, 88, 70, 88};   // 4과목

        int sum = 0;   // 총점
        double avg = 0; //평균

        // 과목 수와 상관 없이 총점과 평균을 계산하세요
        // 일반적인 for문
//        for(int i=0;i < socres.length;i++)
//        {
//            sum += socres[i];
//        }

        // 배열의 모든 요소를 꺼내서 하기
        // Enhanced for loop(향상된 for문)
      for(int score : socres)
      {
          sum += score;
      }
        avg = (double)sum / socres.length;

        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);
    }
}
