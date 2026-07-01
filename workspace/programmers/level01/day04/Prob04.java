package level01.day04;

public class Prob04 {
    public int solution(String ineq, String eq, int n, int m) {
        int result = 0;

        if(ineq.equals(">")){
          result  = eq.equals("=") ? (n >= m ? 1 : 0) : (n > m ? 1 : 0);

        }else{ // <
            result = eq.equals("=") ? (n <= m ? 1 : 0) : ( n < m ? 1 : 0);

        }
        return result;

    }
    void main(){

        String ineq = ">";
        String eq = "!";
        int n = 41;
        int m = 78;

        System.out.println(solution(ineq,eq,n,m));
    }
}
