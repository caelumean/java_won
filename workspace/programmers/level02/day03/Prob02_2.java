package level02.day03;

import java.util.Arrays;

public class Prob02_2 {
    void main(){
        int[] arr = {1, 2, 7, 10, 11};
        // 오름차순
        Arrays.sort(arr);
        int midNum = 0;

        midNum = arr.length % 2 == 0 ? arr[arr.length/2] + arr[(arr.length/2)+1] / arr.length : arr[arr.length / 2];
        System.out.println(midNum);

    }
}
