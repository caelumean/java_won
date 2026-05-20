package ch07;

import java.util.Scanner;
public class SwitchTest
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

        // v01
        switch (month)
        {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.print(month + "월의 마지막 날은 31일 입니다.");
                break;
            case 4, 6, 9, 11:
                System.out.print(month + "월의 마지막 날은 30일 입니다.");
                break;
            case 2:
                System.out.print(month + "월의 마지막 날은 28일 입니다.");
                break;
            /*case 4:
                System.out.print(month + "월의 마지막 날은 30일 입니다.");
                break;
            case 5:
                System.out.print(month + "월의 마지막 날은 31일 입니다.");
                break;
            case 6:
                System.out.print(month + "월의 마지막 날은 30일 입니다.");
                break;
            case 7:
                System.out.print(month + "월의 마지막 날은 31일 입니다.");
                break;
            case 8:
                System.out.print(month + "월의 마지막 날은 31일 입니다.");
                break;
            case 9:
                System.out.print(month + "월의 마지막 날은 30일 입니다.");
                break;
            case 10:
                System.out.print(month + "월의 마지막 날은 31일 입니다.");
                break;
            case 11:
                System.out.print(month + "월의 마지막 날은 30일 입니다.");
                break;
            case 12:
                System.out.print(month + "월의 마지막 날은 31일 입니다.");
                break;*/
        }
        System.out.println("프로그램 종료");

        // v02
        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print(month + "월의 마지막 날은 31일 입니다.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print(month + "월의 마지막 날은 30일 입니다.");
                break;
            case 2:
                System.out.print(month + "월의 마지막 날은 28일 입니다.");
                break;
        }

        System.out.println("프로그램 종료");

        // v03
        switch (month)
        {
            case 2:
                System.out.print(month + "월의 마지막 날은 28일 입니다.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print(month + "월의 마지막 날은 30일 입니다.");
                break;
            default:
                System.out.print(month + "월의 마지막 날은 31일 입니다.");
                break;
        }
        System.out.println("프로그램 종료");
        // v04
        int lastDay = 0;

        switch (month)
        {
            case 2:
                lastDay = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                lastDay = 30;
                break;
            default:
                lastDay = 31;
                break;
        }
        System.out.print(month + "월의 마지막 날은 "+ lastDay +"일 입니다.");
        System.out.println("프로그램 종료");

        // v04
        switch(month)
        {
            case 1,3,5,7,8,10,12 ->
                {
                    System.out.print(month + "월의 마지막 날은 31일 입니다.");
                }
            case 4,6,11 ->
                {
                    System.out.print(month + "월의 마지막 날은 30일 입니다.");
                }
            case 2 ->
                {
                    System.out.print(month + "월의 마지막 날은 28일 입니다.");
                }

        }
        System.out.println("프로그램 종료");
    }

}
