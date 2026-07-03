package level01.day05;

public class Prob01_1 {
    public String solution(String code) {
        boolean mode = false;
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            if(c == '1'){
                mode = !mode;
                continue;
            }
            if((!mode && i % 2 == 0) || (mode && i%2 != 0)){
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
