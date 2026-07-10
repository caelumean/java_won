package level01.day07;

import java.util.Arrays;

public class Prob03_1 {
    public int[] solution(int start_num, int end_num) {
        int[] result = new int[end_num - start_num + 1];
        for(int i = 0; i < result.length; i++){
            result[i] = start_num + i;
        }
        return result;
    }
    void main(){
        int start_num = 3;
        int end_num = 10;
        System.out.println(Arrays.toString(solution(start_num, end_num)));
    }
}
