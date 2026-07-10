package level01.day07;

import java.util.Arrays;

public class Prob01 {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            // arr 을 s~e까지
            for(int j = s; j <= e; j++){

                // k가 j인덱스가 배수인지 확인하기
                if(j % k == 0){
                    arr[j]++;
                }
            }
        }
        return arr;
    }

    void main(){

        // query [s,e,k] = s < i < k
        // i인덱스가 k의 배수이면 arr[i]의 값에 +1
        int[]  arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0,4,1},
                           {0,3,2},
                           {0,3,3}};
        System.out.println(Arrays.toString(solution(arr, queries)));
    }
}
