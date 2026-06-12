package ch10;

public class ArrayCopyMethod
{
    void printArray(int[] arr)
    {
        for(int arrs : arr)
        {
            System.out.print(arrs + " ");
        }

    }

    void main()
    {
        int[] arr = {3, 6, 77, 8, 4, 454};
        printArray(arr);
    }
}
