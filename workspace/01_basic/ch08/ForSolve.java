package ch08;

public class ForSolve
{
    public static void main(String[] args)
    {
        int totalSum = 0;
        int evenSum = 0;
        int oddSum = 0;

        // 1 ~ 100 합계
        // 1 ~ 100 홀수 합계
        // 1 ~ 100 짝수 합계
       for(int i = 0; i <= 100; i++)
       {
           totalSum += i;
           oddSum += ( i % 2) * i;
           evenSum += ( 1 - i % 2) * i;

       }
        System.out.println("1 ~ 100 합계: " + totalSum);
        System.out.println("1 ~ 100 홀수 합계: " + oddSum);
        System.out.println("1 ~ 100 짝수 합계: " + evenSum);
    }
}
