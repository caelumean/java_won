package level01.day02;

public class Prob05 {
    static public void main(String[] args){
        String answer = "";
        String my_string = "He11oWor1d";
        String overwrite_string = "lloWorl";
        int leng1 = my_string.length();
        int leng2 = overwrite_string.length();
        int s = 2;

        answer = my_string.substring(0,s) + overwrite_string + my_string.substring(s+leng2, leng1);

        System.out.println(answer);

    }
}
