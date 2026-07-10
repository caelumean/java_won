package level01.day07;

import java.util.ArrayList;
import java.util.List;

public class Prob02 {
    public List<Integer> solution(int l, int r) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            boolean flag = true;
            String num = i + "";
            for (char c : num.toCharArray()) {
                if (c != '0' && c != '5') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;

    }
    void main(){
        // 정수 l과 r
        // l <= i <= r 이하의 정수 중 숫자 0과 5로만 이루어진 모든 정수를 오름차순
        // 없다면 -1

        System.out.println(solution(5, 555));
    }
}
