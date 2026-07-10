package level01.day06;

public class Prob02_1 {
    public int solution(int n, String control) {
        char[] arr = control.toCharArray();

        for(int i : arr){
            if(i == 'w'){
                n++;
            } else if (i == 's') {
                n--;
            } else if (i == 'd') {
                n += 10;
            } else {
                n -= 10;
            }

        }
        return n;
    }
    void main(){
        // 정수 n
        // w : n이 +1
        // s : n이 -1
        // d : n이 +10
        // a : n이 -10
        String control ="wsdawsdassw";

        System.out.println(solution(0,control));
    }
}
