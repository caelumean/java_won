package ch13.supercar;

public class Driver {
//    void drive(GasolineCar car){
//        car.move();
//    }

    void drive(SuperCar car) {
        car.move();

        if (car instanceof ElectricCar)
        {
            // 부모를 자식으로 다운캐스팅
            ((ElectricCar)car).charge();
        }
    }
}
