package level01.day06;

public class Prob03_1 {
    public String solution(int[] numLog) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numLog.length-1; i++){
            if(numLog[i+1] - numLog[i] == 1){
                result.append("w");
            } else if (numLog[i+1] - numLog[i] == -1) {
                result.append("s");
            } else if (numLog[i+1] - numLog[i] == 10) {
                result.append("d");
            } else if (numLog[i+1] - numLog[i] == -10) {
                result.append("a");
            }
        }
        return result.toString();
    }
    void main(){
        // numLog[i]와 numLog[i+1] 비교하기
        //
        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        System.out.println(solution(numLog));

    }
}
