package ch08;

import java.util.Scanner;

// 계산기
// 5 + 4 -> 5 + 4 = 9
// 4 * 2 -> 4 * 2 = 8
public class CalculatorTest {
    public static void main(String[] args){
        System.out.println("*** 계산기 프로그램 ***");
        System.out.println("계산식을 입력하세요.(예시: 5 + 4)");
        Scanner s = new Scanner(System.in);
        int num1 = s.nextInt(); // 5
        String operator = s.next(); // "+"
        int num2 = s.nextInt(); // 4

        String result = switch(operator){
            case "+" -> num1 + " " + operator + " " + num2 + " = " + (num1 + num2);
            case "-" -> num1 + " " + operator + " " + num2 + " = " + (num1 - num2);
            case "*" -> num1 + " " + operator + " " + num2 + " = " + (num1 * num2);
            case "/" -> num1 + " " + operator + " " + num2 + " = " + ((double)num1 / num2);
            default -> "수식에 오류가 있습니다.";
        };

        System.out.println(result);
    }
}