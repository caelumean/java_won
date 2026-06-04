package ch11.capsule.ex03;

// 은행 계좌정보를 나타내는 클래스
public class Account {
    // 잔고
    private int balance;

    public int getBalance() {
        return balance;
    }

    // 입금
    public void deposit(int amount){
        this.balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 잔고는 " + this.balance + "원 입니다.");

    }
    // 출금
    public void withdraw(int amount){
        if(amount > this.balance){
            System.out.println("잔고가 부족합니다. 잔고는 " + this.balance + "원 입니다.");
        }
        else{
            this.balance -= amount;
            System.out.println(amount+ "원이 출금되었습니다. 잔고는 "+ this.balance+"원 입니다." );
        }

    }

}
