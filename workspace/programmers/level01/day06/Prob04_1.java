package level01.day06;

import java.util.Arrays;

public class Prob04_1 {
    public int[] solution(int[] arr, int[][] queries) {
       for(int[] nums :  queries){
           int temp = arr[nums[0]];
           arr[nums[0]] = arr[nums[1]];
           arr[nums[1]] = temp;
       }
       return arr;
    }

    void main(){
        // 2정수 배열 arr
        // 2차원 정수 배열 queries
        // queries의 배열 i와 j이 arr의 i와 j의 값을 바꾼다.
        int[] arr =  {0, 1, 2, 3, 4};
        int [][] queries =  {{0,3},{1,2},{1,4}};

        System.out.println(Arrays.toString(solution(arr, queries)));
    }
}
