package ch13.supercar;

public class HybridCar extends SuperCar{

    HybridCar(int zero100){
        super(zero100);
    }
    @Override
    void move() {
        // 3
        super.move();
        // 5
        System.out.println("기름과 전기를 사용합니다.");
    }
}
