package ch11.capsule.ex03;

public class AccountTest {
    public static void main(String[] args){
        Account myAccount = new Account();

        // 10000원이 입금되었습니다. 잔고는 10000원입니다.
        myAccount.deposit(8000);
        // 5000원이 출금 되었습니다. 잔고는 5000원입니다.
        myAccount.withdraw(5000);
        // 잔고가 부족합니다. 잔고는 5000원입니다.
        myAccount.withdraw(10000);
    }
}
