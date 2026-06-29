package level01.day03;

public class Prob02 {
    public static void main(String[] args){
        String[] a = {"a","b","c"};
        String answer = "";

        for(int i = 0; i < a.length; i++){
          answer = answer + a[i];
        }
        System.out.println(answer);
    }
}
