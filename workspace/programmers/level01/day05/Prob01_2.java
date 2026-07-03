package level01.day05;

public class Prob01_2 {
    public String solution(String code) {
        int mode = 0;
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            if(c == '1'){
                mode = mode == 0 ? 1 : 0;
                continue;
            }
            if(i % 2 == mode){
                ret.append(c);
            }
        }
        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
    void main(){
        String answer = "ac1bac";

        System.out.println(solution(answer));

    }
}

