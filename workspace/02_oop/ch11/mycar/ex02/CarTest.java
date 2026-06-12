package ch11.mycar.ex02;

public class CarTest
{
    void main()
    {
        // Car 인스턴스를 생성한다
        // 인스턴스를 생성할 때 사용한 클래스가 생성한 인스턴스의 타입이 된다.
        // 인스턴스화 = new
        // Car객체 생성 = Car car
        Car mycar = new Car();
        // mycar.model = "부가티";
        //Car mycar2 = new Car("람보르기니");

        mycar.start();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.gearUp();
        mycar.speedUp();

    }
}
