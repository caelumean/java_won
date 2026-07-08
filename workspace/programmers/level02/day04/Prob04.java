package level02.day04;

public class Prob04 {
    public double solution(int[] numbers){

        int sum = 0;

        for(int number :  numbers){
            sum += number;
        }

        return (double) sum / numbers.length;
    }

    void main(){
        // numbers의 원소의 평균값을 return
        int[] numbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};

        System.out.println(solution(numbers));
    }
}
