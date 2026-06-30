package level01.day04;
// n이 홀수라면 n 이하의 홀수들 다 더하기
// n이 짝수라면 n 이하의 짝수를 제곱하고 더하기
// 비트연산자
public class Prob03 {
    public int solution(int n){
        int result = 0;

        // 1번
//        for(int i = n; i > 0; i -= 2){
//            if(n % 2 == 0){
//                result += i * i;
//            }
//            else{
//                result += i;
//            }
//        }
        // 2번
        for(int i = n; i > 0; i -= 2){
            result += (n % 2 == 0)? i*i : i;
        }
        return  result;
    }
    void main(){

        System.out.println(solution(10));

    }
}
