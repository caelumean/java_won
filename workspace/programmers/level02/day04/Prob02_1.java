package level02.day04;

// 최소 공배수 이용한 풀이
public class Prob02_1 {
    public int solution(int n) {
        int pizza = 6;

        while(pizza % n != 0){
            pizza += 6;
        }
        return pizza / 6;
    }
    void main(){
        System.out.println(solution(10));

    }
}
