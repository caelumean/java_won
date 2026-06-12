package ch07;
import java.util.Scanner;

// 입력받은 월(month)의 마지막 날짜를 출력하세요. (윤달 x)
public class IfTest2
{
    public static void main(String[] args)
    {
        int month = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("월을 입력 : ");
        month = sc.nextInt();

        if( month < 1 || month > 12)
        {
            System.out.println("1 ~ 12 사이의 숫자만 가능합니다.");
            // 프로그램 강제 종료
            System.exit(0);
        }

        if(month == 4 || month == 6 || month == 9 || month == 11)
        {
            System.out.println(month + "월의 마지막날은 30일 입니다.");
        }
        else if (month == 2)
        {
            System.out.println(month + "월의 마지막날은 28일 입니다.");
        }
        else
        {
            System.out.println(month + "월의 마지막날은 31일 입니다.");
        }

    }
}
