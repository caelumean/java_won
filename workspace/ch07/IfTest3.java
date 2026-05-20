package ch07;

import java.util.Scanner;
public class IfTest3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("권한을 입력하세요(ADMIN/USER : ");
        String role = sc.next();

        if(role.equals("ADMIN"))
        {
            System.out.println("관리자 권한");
        }
        else if (role.equals("USER"))
        {
            System.out.println("일반사용자");
        }
        else
        {
            System.out.println("권한 없음");
        }
    }
}
