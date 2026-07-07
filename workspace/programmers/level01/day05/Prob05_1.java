package level01.day05;

public class Prob05_1 {
    public int solution(int[] num_list) {
        // 짝수
        String evenNum = "";
        // 홀수
        String oddNum = "";
        for(int num : num_list){
            if(num % 2 == 0){
                evenNum +=  Integer.toString(num) + "";
            }else {
                oddNum += Integer.toString(num) + "";
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
