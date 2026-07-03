package level02.day03;

import java.util.Arrays;

public class Prob04 {
    public int[] solution(int n){
        int[] arr = new int[(n + 1) / 2];

        for(int i = 1; i <= n; i += 2){
            arr[i / 2] = i;
        }
        return arr;
    }
    void main(){
        System.out.println(Arrays.toString(solution(9)));
    }
}
