package level01.day04;

public class Prob01 {
   public int solution(int num, int n){
       return (num%n == 0) ? 1 : 0;
   }
   void main(String[] args){
        int num = 34;
        int n = 3;

        System.out.println(solution(num,n));
    }
}
