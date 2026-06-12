package ch07;

import java.util.Scanner;

// 회원 등급에 따른 할인 혜택을 적용하는 예제
// A, 골드 등급: 50% 할인
// B, 실버 등급: 30% 할인
// C, 브론즈 등급: 10% 할인
// D, 일반 등급: 0% 할인
public class SwitchTest2
{
    public static void main(String[] args)
    {
        int age = 15;
        int price = 20000;  //정상가
        int lastPrice = price;  // 할인가
        double discountRate = 0.0;   // 할인율(%)

        if( age <= 7)
        {
            discountRate = 1.0;
        }
        else if (age <= 13)
        {
            discountRate = 0.5;
        }
        else if(age <= 19)
        {
            discountRate = 0.3;
        }
        else if (age <= 65)
        {
            discountRate = 0.7;
        }
        else
        {
            discountRate = 0.0;
        }
        lastPrice = price * (1-(int)discountRate);

        System.out.println("나이가 " + age + "세 이므로 할인율 " + discountRate * 100 + "%가 적용되어 요금은 " +lastPrice + "원 입니다.");

    }
}
