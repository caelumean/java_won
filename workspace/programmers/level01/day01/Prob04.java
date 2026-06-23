package level01.day01;

import java.util.Scanner;

public class Prob04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuffer str = new StringBuffer();

        for(int i = 0; i < a.length(); i++) {
            // isLowerCase: 소문자인지 확인하는 클래스
            if(Character.isLowerCase(a.charAt(i))){
                str.append((Character.toUpperCase(a.charAt(i))));
            }
            else {
                str.append((Character.toLowerCase(a.charAt(i))));
            }
        }
        System.out.println(str.toString());
    }
}
