package ch12.car02;


import java.util.Arrays;
import java.util.Objects;

public class Bus extends Car {
    private int passengerCount; // 승객 수
    private String no;      // 버스 번호
    private String type;    // 광역버스,마을버스, 시내버스 ...
    private String[] stations;  // 노선
    private int station; // 현재 위치
    private int price;// 승차비
    private int totalPrice = 0;
    private int maxPassenger; // 최대 승차 인원수
    private int totalPassenger;   // 누적 승차 인원
    private int money;  // 현재까지의 수익
    // 인스턴스 레벨이 아니라 클래스 레벨에서 관리하는 공용변수 선언
    private static int totalMoney; // 운영하는 모든 버스의 수익

    // 컴파일러에 의해서 자동으로 생성되는 기본 생성자 모습
    // 부모의 클래스에서 기본생성자가 아니라 String을 매개변수로 받는 생성자를 쓰겠다.
    public Bus(String model, String no, String type, String[] stations, int price, int maxPassenger) {
        // 명시적으로
        super(model);
        this.no = no;
        this.type = type;
        this.stations = stations;
        this.price = price;
        this.maxPassenger = maxPassenger;
    }


    // 승차합니다
    void ride(){
        // 수익 증가
        // 어린이 / 청소년 / 성인 / 노인별 할인율 적용해서 할인
        // 교통카드 / 현금 / 기타 할인 (지역 주민 할인, 특정 카드 이용시 할인)
        if(passengerCount < maxPassenger){
            passengerCount++;   // 현재 승차인원
            money += price;     // 버스 1대의 수익
            totalPassenger++;   // 누적 승차인원
            totalMoney += price;    // 모든 버스의 전체 수익
            System.out.println("1명이 승차합니다.");

        }else{
            System.out.println("승차 인원이 초과되었습니다. 다음 버스를 타세요.");
        }
    }

    // count 만큼 승차 처리
    // 메서드 오버로딩
    void ride(int count){
        for(int i = 0; i < count; i++){
            ride();
        }
    }

    // 하차합니다
    void leave(){
        passengerCount--;
        System.out.println("1명이 하차합니다.");
    }

    // count 만큼 하차 처리
    // 메서드 오버로딩
    void leave(int count){
        for(int i = 0; i < count; i++){
            leave();
        }
    }

    // 오버라이딩: 부모 메서드를 자식이 재정의
    void stop(){

        // 이렇게 호출하면 자기 자신의 stop 메서드만 무한으로 호출하게 된다.
        // stop();
        // 부모의 stop() 메서드 호출
        super.stop();
        station++;

        // station이 끝에 도달하면 다시 0으로 초기화
        if(station == stations.length){
            station = 0;
        }
        System.out.println("이번역은 " + stations[station] + "역 입니다. This station is " + stations[station]);
    }

    // 기다리는 버스가 몇 정거장 전에 있는가?
    public int getStationsLeft(){
        int result = 0;

        return result;
    }
    public void printBusLocation(){


    }
    // 버스의 현재 상태를 출력합니다.
//    public String toString(){
//        return "버스 번호: " + no
//                + ", 종류: " + type
//                + ", 현재 위치: " + stations[station]
//                + ", 남은 좌석: "+ (maxPassenger - passengerCount)
//                + ", 요금: " + price
//                + ", 수익: " + money
//                + ", 누적 승차 인원: " + totalPassenger
//                +", 모든 버스 수익 총합: " + totalMoney;
//    }


    // 마우스 우클릭 -> Generate -> toString
    // @ (어노테이션) : 이 메서드는 오버라이드한 메서드라는 것을 알려주는 것
    @Override
    public String toString() {
        return "Bus{" +
                "passengerCount=" + passengerCount +
                ", no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", stations=" + Arrays.toString(stations) +
                ", station=" + station +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", maxPassenger=" + maxPassenger +
                ", totalPassenger=" + totalPassenger +
                ", money=" + money +
                ", totalMoney=" + totalMoney +
                '}';
    }

    @Override
    public boolean equals(Object o) {   // Bus -> Object로 자동형변환
        // getClass(): Object클래스에 기본적으로 포함되어 있는 메서드
        // 현재 내 클래스 타입
        if (o == null || getClass() != o.getClass()) return false;
        // (Bus) Bus 클래스로 명시적 형변환
        // 원래 객체로 복원할려면 명시적 형변환이 필요하다
        Bus bus = (Bus) o;
        return Objects.equals(no, bus.no);
    }

    @Override
    public int hashCode() {
        // 버스 번호가 같으면 이 객체의 해시 코드 값도 무조건 같게 만들겠다.
        // equals가 같으면 hashCode도 같에 만드는 것은 관례이다
        return Objects.hashCode(no);
    }
}
