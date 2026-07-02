package level02.day03;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob04_1 {
    public ArrayList solution(int n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(int i = 1; i <= n; i++){
            if(i % 2 != 0) {
                answer.add(i);
            }
        }
        return answer;
    }
    void main(){
        System.out.println(solution(9));
    }
}
