package ch13.supercar;

public class ElectricCar extends SuperCar implements Chargeable{

    ElectricCar(int zero100){
        super(zero100);
    }

    @Override
    void move() {
        // 3
        super.move();
        // 5
        System.out.println("전기를 사용합니다.");
    }

    // interface에 charge라는 추상메서드 추가
    public void charge(){
        System.out.println("전기를 충전합니다.");
    }
}
