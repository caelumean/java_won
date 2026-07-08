package level02.day04;

public class Prob01_1 {
    public int solution(int n) {

        return n % 7 == 0 ? n / 7 : (n / 7) + 1;

    }
    void main(){
        // 피자 나눠먹기
        // 한판에 7조각
        // 나눠먹을 사람 수n
        // 모든 사람이 피자를 한 조각이상 먹기 위해 필요한 피자의 수
        System.out.println(solution(15));

    }
}
