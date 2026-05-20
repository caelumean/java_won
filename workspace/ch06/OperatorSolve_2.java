package ch06;
import java.util.Scanner;

public class OperatorSolve_2
{
    void main()
    {
        int num1,num2;
        Scanner sc = new Scanner(System.in);
        System.out.print("변수 a를 입력 : ");
        num1 = sc.nextInt();
        System.out.print("변수 b를 입력 : ");
        num2 = sc.nextInt();

        double divResult = (double) num1 / num2;
        System.out.println(num1+ " / " +num2 + "결과 (실수) : " +divResult);

        int number;
        System.out.print("숫자 입력 : ");
        number = sc.nextInt();

        String evenOrOdd = (number % 2) == 0 ? "짝수" : "홀수";
        System.out.println(number + "은/는 " + evenOrOdd + "입니다.");

        int year;
        System.out.print("년도 입력 : ");
        year = sc.nextInt();
        // 1592 -> true && true || false
        boolean isLeapYear =((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0;

        System.out.println(year + "년은 윤년인가요? " + isLeapYear); // 2024년은 윤년인가요? true

    }
}
