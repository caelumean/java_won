package level02.day03;

import java.util.Arrays;

public class Prob02 {


    void main(){
        int[] arr = {9,-1,0};
        // 오름차순
        Arrays.sort(arr);
        int midNum = 0;
        int len = arr.length;

        // arr의 길이가 홀수일 때
        if(len % 2 != 0 ){
           midNum = arr[len / 2];
        }
        // arr의 길이가 짝수일 때
        else {
            // 가운데에 있는 length/2 번째 값과 length/2 + 1 값의 평균
            midNum = (arr[len/2] + arr[(len/2)+1]) / len;
        }
        System.out.println(midNum);

    }
}
