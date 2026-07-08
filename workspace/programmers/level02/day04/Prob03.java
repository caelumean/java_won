package level02.day04;

public class Prob03 {
    public int solution(int slice, int n) {

        return n % slice == 0 ? n / slice : (n / slice) + 1;
    }

    void main(){
        // 2 ~ 10 원하는 조각 수로 잘라준다.
        // 피자 조각수 slice
        // 피자를 먹는 사람의 수 n
        // n명의 사람이 최소 한조각 이상 피자를 먹으려면 최소 몇판을 시켜야하는 지를 return

        System.out.println(solution(7, 10));

    }
}
