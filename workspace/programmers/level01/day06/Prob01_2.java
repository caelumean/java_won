package level01.day06;

import java.util.Arrays;

public class Prob01_2 {
    public int[] solution(int[] num_list) {
        int[] newArray = Arrays.copyOf(num_list, num_list.length + 1);
        int last = num_list[num_list.length - 1];
        int prev = num_list[num_list.length - 2];

        newArray[newArray.length-1] = (last > prev) ? last - prev : last * 2;

        return newArray;

    }
    void main(){
        // 정수 리스트 num_list
        // 마지막 원소가 그전 원소보다 크면 마지막 원소 - 그전 원소
        // 아니라면 마지막 원소를 두배 한값
        // 마지막 원소에 추가하여 return

        // 1. ArrayList
        // 2. Arrays.copyOf 사용하기

        int[] num_list = {2, 1, 6};

        System.out.println(Arrays.toString(solution(num_list)));

    }
}
