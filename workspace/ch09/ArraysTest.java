package ch09;

import java.util.Arrays;

public class ArraysTest
{
    public static void main(String[] args)
    {
        int[] arr = {3, 6, 7, 8, 5, 3, 5, 6, 8, 2, 3};
        int[] arr2 = {1,2,3};
        int[] arr3 = {2,1,3};
        int[] arr4 = {1,2,3};

        // 1. arr의 모든 요소를 출력하세요.
        System.out.println(" 1. arr의 모든 요소를 출력하세요.");
        for (int arrs : arr) {
            System.out.print(arrs + " ");
        }
        // 배열을 문자열로 변환하는 메서드
        System.out.println(Arrays.toString(arr));
        System.out.println();
        // 2. arr2와 arr3의 모든 요소가 같은 값을 가지고 있는지 출력하세요.
        // arr2, arr3 다름
        // arr2, arr4 같음
        System.out.println("2. arr2와 arr3의 모든 요소가 같은 값을 가지고 있는지 출력하세요.");

        boolean isSame = true;
        for(int i = 0; i < arr2.length; i++)
        {
            if(arr2[i] != arr3[i])
            {
                isSame= false;
                break;
            }
        }
        if(isSame == true)
        {
            System.out.println("arr2와 arr3가 같습니다.");
        }
        else
        {
            System.out.println("arr2와 arr3가 다릅니다.");
        }

        // 다시 초기화해주기
        isSame = true;

        for(int i = 0; i < arr2.length; i++)
        {
            if(arr2[i] != arr4[i])
            {
                isSame= false;
                break;
            }
        }
        if(isSame == true)
        {
            System.out.println("arr2와 arr4가 같습니다.");
        }
        else
        {
            System.out.println("arr2와 arr4가 다릅니다.");
        }

        // arrays의 equals 메소드를 쓰면 두 배열을 비교해준다
        System.out.println("arr2, arr3 " + Arrays.equals(arr2, arr3));
        System.out.println("arr2, arr4 " + Arrays.equals(arr2, arr4));
        System.out.println();

        // 3. arr의 요소를 최소값과 최대값을 구하세요.
        System.out.println("3. arr의 요소를 최소값과 최대값을 구하세요.");

        int max = arr[0];
        int min = arr[0];

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
            else if (arr[i] < min)
            {
                min = arr[i];
            }
//            if(arr[i] < min)
//            {
//                min = arr[i];
//            }
        }
        System.out.println("arr의 최소값: " +min+" 최대값: "+max);
        System.out.println();

        Arrays.sort(arr);
        System.out.println("최소값: " + arr[0]);
        // 배열은 0부터 시작하기 때문에 마지막 인덱스 length-1
        System.out.println("최대값: " + arr[arr.length-1]);
        // 4. arr의 요소를 오름차순으로 정렬하세요.
        System.out.println("4. arr의 요소를 오름차순으로 정렬하세요.");
        for (int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j< arr.length-1-i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int num :  arr)
        {
            System.out.print(num + " ");
        }

        for(int i = 0; i < arr.length; i++)
        {
            for(int k = 0; k < arr.length - 1 ; k++)
            {
                if(arr[i] >  arr[k+1])
                {
                    // arr[i] <-> arr[k+1]
                    // 두 변수의 값을 바꾸기 위해선
                    // 한 쪽의 값을 임시로 담아두는 공간이 필요하다.
                    int temp = arr[i];
                    arr[i] = arr[k+1];
                    arr[k+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        // 정렬의 또다른 방법
        Arrays.sort(arr);
        System.out.println(arr);
    }
}
