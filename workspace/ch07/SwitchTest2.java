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
        int price = 10000;  //정상가
        int lastPrice = price;  // 할인가
        char grade = 'D';   // 회원 등급
        int discountRate = 0;   // 할인율(%)

        System.out.println("회원님은 B등급이므로 정상가 10000원에서 30% 할인된 가격 7000원 입니다.");




    }
}
