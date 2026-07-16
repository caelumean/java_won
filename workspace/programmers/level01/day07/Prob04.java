package level01.day07;

import java.util.ArrayList;

public class Prob04 {
    public  ArrayList<Integer> solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);

        while(n!= 1){
            if(n % 2 == 0) {
                n = n / 2;
            }
            else{
                n = 3 * n + 1;
            }
            list.add(n);
        }

        return list;
    }

    void main(){
        // 콜라츠 수열 만들기
        // 모든 자연수 x
        // x가 짝수 일때 2로 나누고
        // x가 홀수 일때 3 * x + 1
        int n = 10;

        System.out.println(solution(n));
    }
}
