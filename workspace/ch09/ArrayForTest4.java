package ch09;

import java.util.Scanner;

public class ArrayForTest4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);    // 사용자가 입력한 데이터를 받을 때 사용

        System.out.println("단을 입력하세요.");
        int dan = sc.nextInt(); // 입력한 값을 int로 꺼내옴
        System.out.println("입력한 단 : " +dan);

        // 구구단 결과를 배열로 저장 후 출력
        int[] result = new int[9];

        for(int i = 0; i < result.length; i++)
        {
            result[i] = dan * (i + 1);//  dan = 3 ,i = 0, result = 3*1;
        }
        System.out.println(dan + "단 학습 완료!");


        // 0을 입력할 때까지 무한 반복하도록 작성하세요
        // 여러가지 방법이 있다
        // while(true)
        // while(num != 0)
        // 결과 나오는 것이 중요하다 그러니 어떠한 방법이든 풀어내면 된다.
        System.out.println("곱할 숫자를 입력하세요. 0을 입력하면 종료됩니다.");
        int num = sc.nextInt();
        //while(true)
        while(num > 0 && num <10)
        {
//            System.out.println("곱할 숫자를 입력하세요. 0을 입력하면 종료됩니다.");

//            if(num == 0)
//            {
//                System.out.print("종료");
//                break;
//            }
            System.out.println(dan + " x " + num + " = " + result[num-1]);
        }
        System.out.print("종료");

    }

}
