package level01.day07;

import java.util.Arrays;

public class Prob03 {
    public int[] solution(int start_num, int end_num) {
        int[] result = new int[end_num - start_num + 1];
        for(int i = start_num; i <= end_num; i++){
            // 3-3 4-3 5-3
            // i - startnum
            result[i-start_num] = i;
        }
        return result;
    }
    void main(){
        int start_num = 3;
        int end_num = 10;
        System.out.println(Arrays.toString(solution(start_num, end_num)));
    }
}
