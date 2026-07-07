package level01.day05;

public class Prob05 {
    public int solution(int[] num_list) {
        // 짝수
        String evenNum = "";
        // 홀수
        String oddNum = "";
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0){
                evenNum = evenNum + Integer.toString(num_list[i]);
            }else {
                oddNum = oddNum + Integer.toString(num_list[i]);
            }
        }
        System.out.println(evenNum);
        System.out.println(oddNum);
        return Integer.parseInt(evenNum) + Integer.parseInt(oddNum);
    }
    void main(){
        int[] num_list = {5,7,8,3};
        System.out.println(solution(num_list));
    }
}
