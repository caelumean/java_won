package level02.day03;

import java.util.Arrays;

public class Prob03 {

    public int solution(int[] arr){
        // 최빈값
        int mode = 0;
        // 현재 숫자가 몇번 나왔는지
        int count = 1;
        // 제일 많이 나온 거
        int maxCount = 1;
        // boolean으로 체크 같은거 나오면 -1
        boolean isModeSame = false;

        // 배열 오름차순으로 정렬
        Arrays.sort(arr);
        // 배열의 길이가 1일경우 해당 값만 mode에 넣기
        if(arr.length == 1){
            mode = arr[0];
            return mode;
        }
        for(int i = 0; i < arr.length-1; i++){

            // 현재 숫자와 다음 숫자가 같을 경우 count 증가
            if(arr[i] == arr[i+1]){
                count++;
            }
            // 그게 아니고 다른 숫자가 나왔을 경우 count를 초기화
            else {
                count = 1;
            }
            // count가 maxCount보다 크면 그걸 maxCount에 넣기
            if(count > maxCount){
                maxCount = count;
                mode = arr[i];
                isModeSame = false;
            }
            // count랑 maxCount가 같을 경우
            else if (count == maxCount) {
                isModeSame = true;
            }
        }
        if(isModeSame){
            mode = -1;
        }
        return mode;
    }
    void main(){

        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3};

        System.out.println(solution(arr));
    }
}
