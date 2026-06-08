package ch12.car02;

public class BusTest {
    void main(){

        Bus mycar1 = new Bus("람보르기니","10-2","마을버스"
                , new String[]{"우리집","김포 고등학교","김포 시청"}, 1300, 15);


        mycar1.start();
        mycar1.speedUp();
        mycar1.speedUp();
        mycar1.speedUp();
        mycar1.speedUp();
        mycar1.speedUp();
        mycar1.stop();

        mycar1.leave();
        mycar1.ride();
        mycar1.ride();
        mycar1.ride();
        mycar1.ride();
        mycar1.ride();
        mycar1.ride();

        Bus mycar2 = new Bus("전기버스","3005","광역버스"
                , new String[]{"김포 시청","발산역","홍대역", "서울시청"}, 3500, 45);


        mycar2.start();
        mycar2.speedUp(50);
        mycar2.speedUp();

        mycar2.stop();

        mycar2.start();
        mycar2.speedUp();
        mycar2.ride(10);
        mycar2.leave(2);
        mycar2.speedDown();

        System.out.println(mycar1.toString());
        System.out.println(mycar2.toString());

        // 버스 노선이 같으면 같은 버스로 다루고 싶음
        // 기본적으로 주소를 다룬다
        System.out.println(mycar1.equals(mycar2));

        System.out.println(mycar1.hashCode());
        System.out.println(mycar2.hashCode());
    }
}
