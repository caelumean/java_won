package ch12.car;

public class Passenger {
    String name;
    int age;
    boolean localResident;
    String paymentType;
    String passengerLocation;

    public Passenger(String name, int age, boolean localResident, String paymentType, String passengerLocation){
        this.name = name;
        this.age = age;
        this.localResident = localResident;
        this.paymentType = paymentType;
        this.passengerLocation = passengerLocation;
    }

    public String getName() {
        return name;
    }

    // ageType
    // 영유아
    // 어린이 6 ~ 13
    // 청소년 13 ~ 18
    // 성인 19 ~ 64
    // 노인 65
    public String getAgeType(){
        if(age < 0){
            return "미분류";
        }
        if (age > 0 && age <= 5) {
            return "영유아";
        } else if (age <= 12) {
            return "어린이";
        } else if (age <= 18) {
            return "청소년";
        } else if (age <= 64) {
            return "성인";
        } else {
            return "노인";
        }
    }

    public String getPaymentType(){
        return this.paymentType;
    }

    public double getDiscountRate(){

        String AgeType = getAgeType();
        
        if(AgeType.equals("영유아")){
            return 0.0;
        }else if (AgeType.equals("어린이")){
            return 0.5;
            
        } else if (AgeType.equals("청소년")) {
            return 0.8;
            
        } else if (AgeType.equals("성인")) {
            return 1.0;
        } else if (AgeType.equals("노인")) {
            return 0.0;
        }else {
            return 1.0;
        }
    }
    // 승객 위치
    public String getPassengerLocation() {
        return this.passengerLocation;
    }

    // paymentType
    // 1. 교통카드
    // 2. 현금

    public int getDiscountPaymentType(){

        if (getPaymentType().equals("카드")){
            return 100;
        } else if (getPaymentType().equals("현금")) {
            return 0;
        }else return 0;
    }

     public int localResident(){
        if(localResident == true){
            return 100;
        }else {
            return 0;
        }

     }
}
