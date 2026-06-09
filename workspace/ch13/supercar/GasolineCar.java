package ch13.supercar;

public class GasolineCar extends SuperCar{
    GasolineCar(int zero100){
        super(zero100);
    }
    @Override
    void move() {
        // 3
        super.move();
        // 5
        System.out.println("기름을 사용합니다.");
    }
}
