package ch08;

import java.sql.SQLOutput;

// 6이 나올때까지 주사위를 던져보자
public class WhileTest3
{
    public static  void main(String[] args)
    {
        // 돌리는 횟수
        int testCount = 0;

        while(testCount < 3)
        {
            int num = 0;
            int count = 0;  // 던진 횟수

            while(num != 6)
            {
                // 주사위 던지기
                // Math.random(): 0이상 1미만의 무작위 double 타입의 숫자를 반환
                num = (int)(Math.random() * 6) + 1;  // 0이상 5.9999...미만의 수
                System.out.println(num);
                count++;
            }
            System.out.println("반복 횟수: " + count);
            testCount++;
        }
    }

}
