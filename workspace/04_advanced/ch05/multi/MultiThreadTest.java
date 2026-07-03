package ch05.multi;

public class MultiThreadTest {
    void main() throws InterruptedException{
        System.out.println("1.main 시작.");

        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        odd.start();

        // 특정스레드가 작업이 끝날때까지 기다리고
        // 그 이후에 작업을 하겠다.
        // odd.join은 항상 홀수가 종료된 후에 나온다.
        odd.join();
        new Thread(even,"짝수 스레드").start();
        // 익명 클래스
        // Runnable 인터페이스를 구현하는 이름없는 클래스
        // 익명 클래스를 이용한 일회성 클래스이다.
//        Runnable three = new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 3; i <= 10;i+=3){
//                    System.out.println("3의 배수: " + i);
//                }
//            }
//        };
//
//        new Thread(three).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 3; i <= 10;i+=3){
                    System.out.println("3의 배수: " + i);
                }
            }
        }).start();

        // 스레드를 잠시 쉬었다가 하겠다.
//        Thread.sleep(1000*10);
        System.out.println("8.main 종료.");
    }
}
