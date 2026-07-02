package level02.day03;

import java.util.Arrays;

public class Prob02_2 {
    void main(String[] args){
        int[] arr = {1, 2, 7, 10, 11};
        // 오름차순
        Arrays.sort(arr);
        int midNum = 0;
        int len = arr.length;

        midNum = len % 2 == 0 ? arr[len/2] + arr[(len/2)+1] / len : arr[len / 2];
        System.out.println(midNum);

    }
}
