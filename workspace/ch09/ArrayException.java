package ch09;

public class ArrayException
{
    public static void main(String[] args)
    {
        // 1. NullPionterException
        String[] strArr = {"haru","namu","brong"};
        System.out.println(strArr[0]);

        int[] ageArr = null;

        if(ageArr != null)
        {
            System.out.println(ageArr[0]);
        }

        // 2. ArrayIndexOutBoundsException
        //
        System.out.println(strArr[3]);
        System.out.println("main 실행 완료");

    }
}
