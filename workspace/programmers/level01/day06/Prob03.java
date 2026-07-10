package level01.day06;

import java.util.Arrays;

public class Prob03 {
    public String solution(int[] numLog) {
        String result = "";
        for(int i = 0; i < numLog.length-1; i++){
            if(numLog[i+1] - numLog[i] == 1){
                result = result + "w";
            } else if (numLog[i+1] - numLog[i] == -1) {

                result = result + "s";
            } else if (numLog[i+1] - numLog[i] == 10) {
                result = result + "d";

            } else if (numLog[i+1] - numLog[i] == -10) {
                result = result + "a";
            }
        }
        return result;

    }
    void main(){
        // numLog[i]와 numLog[i+1] 비교하기
        //
        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        System.out.println(solution(numLog));

    }
}
