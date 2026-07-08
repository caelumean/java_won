package level02.day04;

// 1. 반복문을 이용한 풀이
public class Prob02 {
    public int solution(int n) {
        int pizza = 6;
        int pizzaCount = 0;

        // 피자의 총 조각수와 피자판
        // 6 * x
        // 그리고 그걸 n명으로 나누어서 0으로 떨어져야 한다.
        // 총 조각수가 n의 배수여야 한다.
        while(true){
            pizzaCount++;
            if((pizzaCount * pizza) % n == 0){
                return pizzaCount;
            }
        }
    }

    // 피자 가게에서 여섯조각으로 잘라준다
    // 나눠 먹을 사람 n명
    // n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자를 먹어야한다.
    void main(){
        System.out.println(solution(10));

    }
}
