package ch01;

import ch09.ArrayForTest4;

public class MultiCatchTest {
    void main(){
        divide4(100, new String[]{"hello"});
        divide4(100, new String[]{"  "});
        divide4(100, new String[]{});
        divide4(100, new String[]{null});
        divide4(100, null);

        System.out.println("프로그램 종료");

    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide(int num1, String[] arr){
        try{
            int num2 = arr[0].length(); // str이 null일 경우 NullPointerException 발생
            int result = num1 / num2; // str이 ""일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
        }catch(ArithmeticException | NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide2(int num1, String[] arr){
        try{
            int num2 = arr[0].length(); // str이 null일 경우 NullPointerException 발생
            int result = num1 / num2; // str이 ""일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
            // Exception도 다형성이 적용이 된다.
            // 그래서 다 잡아먹기 때문에 맨 아래에 놓아야한다
        }catch(ArrayIndexOutOfBoundsException e){   // 플랜C
            System.out.println(e.getMessage());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    void divide3(int num1, String[] arr){
        try{
            int num2 = arr[0].length(); // str이 null일 경우 NullPointerException 발생
            int result = num1 / num2; // str이 ""일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
        }catch(Exception e) {   // 플랜 B
            System.out.println(e.getMessage());
        }
    }
    // 예외상황이 발생하는 것들을 코드로도 충분히 처리할 수 있으니까
    // try catch 문을 쓰지 않아도 되는 부분은 안해도 된다.
    void divide4(int num1, String[] arr){

        if(arr != null && arr.length > 0 && arr[0] != null && arr[0].trim().length() > 0) {
            int num2 = arr[0].length(); // str이 null일 경우 NullPointerException 발생
            int result = num1 / num2; // str이 ""일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
        }
    }
}
