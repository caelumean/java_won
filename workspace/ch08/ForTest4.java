package ch08;

import java.util.Scanner;
public class ForTest4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);    // 사용자가 입력한 데이터를 받을 때 사용

        System.out.print("구구단 단을 입력하세요 : ");
        int dan = sc.nextInt(); // 입력한 값을 int로 꺼내옴

        for(int i = 1; i < 10; i++)
        {
            System.out.println(dan + " x " + i + " = " + (dan * i));
        }
    }

}
