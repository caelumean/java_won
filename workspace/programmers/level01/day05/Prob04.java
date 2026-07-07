package level01.day05;

public class Prob04 {
    public int solution(int[] num_list) {
        int mul = 1;
        int sum = 0;
        int powSum = 0;

        for(int num : num_list){
            mul *= num;
            sum += num;
        }
        powSum = sum * sum;

        return mul > powSum ? 0 :  1;
    }
    void main(){
        int[] num_list = {5,7,8,3};
        System.out.println(solution(num_list));
    }
}
