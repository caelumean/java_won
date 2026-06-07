package ch12.car;

public class BusTest {
    void main(){

        Bus mycar = new Bus("람보르기니","10-2","마을버스"
                , new String[]{"우리집","김포 고등학교","김포 시청"}, 1300, 15);

        Passenger p1 = new Passenger("홍길동",20,true,"카드", "김포 고등학교");
        Passenger p2 = new Passenger("아무개",15,true,"현금", "김포 시청");
        mycar.start();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.speedUp();
        mycar.printBusLocation(p1);
        mycar.stop();
        mycar.ride(p1);
        mycar.start();
        mycar.speedUp();
        mycar.printBusLocation(p2);
        mycar.speedUp();
        mycar.speedUp();
        mycar.stop();
        mycar.ride(p2);

        System.out.println(mycar.getBusInfo());
    }
}
