package level01.day06;

import java.util.Arrays;

public class Prob05 {
    public int[] solution(int[] arr, int[][] queries) {

        int[] answer = new int[queries.length];
        Arrays.fill(answer, Integer.MAX_VALUE);

        // 각 쿼리 반복
        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];  // 0, 0, 0
            int e = queries[i][1];  // 4, 3, 2
            int k = queries[i][2];  // 2, 2, 2

            System.out.println( s + " " + e + " " + k);

            // s부터 e까지 for문 돌기
            // 1. 0 ~ 4 / 2. 0 ~ 3 / 3. 0 ~ 2
            // arr = 0, 1, 2, 4, 3
            for(int j = s; j <= e; j++){
                // arr의 배열의 값이 k보다 크면
                if(arr[j] > k)
                {
                    // 새로운 배열 answer에
                    // answer의 i 번째 값과 arr 배열의 j번째
                    answer[i] = Math.min(answer[i], arr[j]);
                }
            }
            // k보다 큰 값을 찾지 못했다면
            if(answer[i] == Integer.MAX_VALUE){
                answer[i] = -1;
            }
        }
        return answer;

    }
    void main(){
        // 정수 배열 arr
        // 2차원 정수배열 queries
        // [s,e,k]
        // arr의 i가 k보다 크면서 가장 작은 arr[i] 찾기

        int[] arr =  {0, 1, 2, 4, 3};
        int [][] queries = {{0,4,2},
                            {0,3,2},
                            {0,2,2}};

        System.out.println(Arrays.toString(solution(arr, queries)));

    }
}
