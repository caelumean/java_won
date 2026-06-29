package level01.day03;

public class Prob03 {
    public static void main(String[] args){
        String answer = "";
        String my_string = "string";
        int k = 3;
        if(k != 0)
        {
            for(int i = 0; i < k; i++)
            {
                answer += my_string;
            }
        }

        System.out.println(answer);

    }
}
