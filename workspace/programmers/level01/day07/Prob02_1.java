package level01.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob02_1 {
    public int[] solution(int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < 64; i++) {
            int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
            if (l <= num && num <= r)
                list.add(num);
        }

        return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
    }
    void main(){
        // 정수 l과 r
        // l <= i <= r 이하의 정수 중 숫자 0과 5로만 이루어진 모든 정수를 오름차순
        // 없다면 -1

        System.out.println(Arrays.toString(solution(5, 555)));
    }
}
