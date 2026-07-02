package level02.day03;
import java.util.*;

public class Prob03_1 {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        // Map(값, 값의 빈도수)
        for (int x : array)
            map.put(x, map.getOrDefault(x, 0) + 1);

        // Map에서의 최빈값 찾기
        int mode = 0;
        int modeNum = 0;
        for (int x : map.keySet())
            if (map.get(x) > modeNum) {
                mode = x;
                modeNum = map.get(x);
            }

        // 동일한 최빈값이 여러개일 경우, 그 갯수를 count
        int modeCnt = 0;
        for (int x : map.values()) {
            if (x == modeNum) modeCnt++;
            if (modeCnt > 1) return -1;
        }

        return mode;
    }

    void main() {
        int[] array = {1, 2, 2, 3, 3, 3};

    }
}
