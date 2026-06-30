package level02.day02;

public class Prob04 {
    public static void main(String[] args){
        int[] numbers = {1,2,3,4,5};

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = numbers[i] * 2;
        }

        for(int arr : numbers){
            System.out.print(arr);
        }
    }
}
