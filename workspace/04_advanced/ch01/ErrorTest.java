package ch01;

public class ErrorTest {
    public static void main(String[] args){

        try {   // 플랜 A
            int num = Integer.parseInt(args[0]);
            int result = 10/0;
            System.out.println("result: " + result);
        }catch (ArithmeticException e){ // 플랜 B
            System.out.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){  // 플랜 C
            System.out.println(e.getMessage());
        }

        // RuntimeException 밑에 있는 것들은 try catch를 강제하지 않는다.
        try{
            makeError();
        }catch(Throwable t){
            t.printStackTrace();
            System.out.println("에러 발생: " + t.getClass().getSimpleName());
        }
        System.out.println("프로그램 종료");
    }
    static void makeError() {
        makeError();   // 재귀 호출
    }

}
