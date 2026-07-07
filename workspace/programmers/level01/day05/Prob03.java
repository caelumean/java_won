package level01.day05;

public class Prob03 {
    public int solution(int a, int b, int c) {
        int result = 0;
        if(a == b && b == c){
            result = (a + b + c) * (int)(Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2)) * (int)(Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3));
        }else if(a == b || a == c || b == c){
            result = (a + b + c) * (int)(Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2));
        }else{
            result = a + b + c;
        }
        return result;
    }
    void main(){
        System.out.println(solution(4, 4, 4));
    }
}
