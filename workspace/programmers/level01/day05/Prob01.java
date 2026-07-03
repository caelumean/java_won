package level01.day05;

public class Prob01 {
    public String solution(String code) {
        boolean mode = false;
        String ret = "";

        for (int i = 0; i < code.length(); i++) {
            // mode = 1
            if (mode == true) {
                if(code.charAt(i) == '1'){
                    mode = false;
                }
                else if(i % 2 != 0 ){
                    ret += code.charAt(i);
                }
            }
            // mode = 0
            else {
                if (code.charAt(i) == '1') {
                    mode = true;

                }
                else if( i % 2 ==0){
                    ret += code.charAt(i);
                }
            }
        }
        return ret.equals("") ? "EMPTY" : ret;
    }

    void main(){
        String answer = "abc1abc1abc";

        System.out.println(solution(answer));

    }
}
