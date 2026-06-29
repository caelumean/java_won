package level01.day03;

public class Prob01 {
    public static void main(String[] args){
        String a = "aaaaa";
        String b = "bbbbb";
        String answer = "";

        for(int i = 0; i < b.length(); i++){
          answer = answer + a.charAt(i) + b.charAt(i);
        }

        System.out.println(answer);
    }
}
