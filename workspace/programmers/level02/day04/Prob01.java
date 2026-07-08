package level02.day04;

public class Prob01 {
    public int solution(int n) {

        int pizzaCount = n / 7 ;

        if( n % 7 == 0){
           pizzaCount = n / 7;
        }else{
           pizzaCount  = (n / 7) + 1;
        }

        return pizzaCount;

    }
    void main(){
        // 피자 나눠먹기
        // 한판에 7조각
        // 나눠먹을 사람 수n
        // 모든 사람이 피자를 한 조각이상 먹기 위해 필요한 피자의 수
        System.out.println(solution(15));

    }
}
