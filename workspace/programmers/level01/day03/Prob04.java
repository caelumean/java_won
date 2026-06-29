package level01.day03;

public class Prob04 {
    public static void main(String[] args){
        int answer = 0;
        int a = 9;
        int b = 91;

        String str_a = Integer.toString(a);
        String str_b = Integer.toString(b);
        int sum1 = Integer.parseInt(str_a + str_b);
        int sum2 = Integer.parseInt(str_b + str_a);

        if(sum1 > sum2){
            answer = Integer.parseInt(str_a + str_b);
        }
        else {
            answer = Integer.parseInt(str_b + str_a);
        }

        System.out.println(answer);
    }
}
