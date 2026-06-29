package leve02.day02;

public class Prob03 {
    public static void main(String[] args){
        int numer1 = 1;
        int denom1 = 2;
        int numer2 = 3;
        int denom2 = 4;

        int numer = numer1 * denom2 + numer2*denom1;
        int denom =  denom1 * denom2;

        int max = 1;

        for(int i = 1;i <= numer && i <= denom; i++){
            if(numer % i == 0 && denom % i == 0){
                max = i;
            }
        }
        numer = numer / max;
        denom = denom /max;
        int[] answer = {numer, denom};

        for(int an: answer){
            System.out.print(an + " ");
        }
    }
}
