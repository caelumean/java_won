package ch09;

import java.util.Arrays;

// C++로도 해보기 중요
public class ArrayCopy
{
    public static void main(String[] args)
    {
        // 1. 얕은 복사 (Shallow Copy
        // 주소를 공유한다
        int[] original ={10,20,30};
        // shallow는 original이 가리키고 있는 주소를 담게되므로
        // original과 shallow가 가리키고 있는 주소가 같아진다.
        int[] shallow = original;   // original을 복사함

        // original, shallow의 모든 요소를 출력
        System.out.println("----------1. 얕은 복사----------");
        for(int i=0; i < original.length; i++)
        {
            System.out.println("original: " + original[i] +", shallow: " + shallow[i]);
        }

        // shallow[0] 값을 수정
        shallow[0] = 99;
        original[0] = 88;

        for(int i=0; i < original.length; i++)
        {
            System.out.println("original: " + original[i] +", shallow: " + shallow[i]);
        }

        // 2. 깊은 복사 - 수동 복사(for문 사용)
        // 주소를 공유하지않지만 값은 같다
        System.out.println("----------2. 깊은 복사 - 수동 복사(for문 사용)----------");
        // 초기화 작업은 배열을 선언할 때만 사용할 수 있다.
        // 이미 선언된 변수에 새로운 배열을 할당 하려면 new int[]{10,20,30} 형태로 작성해야 함
        original = new int[]{10,20,30,40,50};
        shallow = new int[original.length];

//        shallow[0] = original[0];
//        shallow[1] = original[1];
//        shallow[2] = original[2];
//        shallow[3] = original[3];
//        shallow[4] = original[4];

        // 원본 배열의 각 요소를 복사해서 복사본에 저장
        for(int i=0;i<original.length;i++)
        {
            shallow[i] = original[i];
        }

        for(int i=0; i< original.length; i++)
        {
            System.out.println("original: " + original[i] +", shallow: " + shallow[i]);
        }

        original[0] = 88;
        shallow[0] = 99;

        for(int i=0; i < original.length; i++)
        {
            System.out.println("original: " + original[i] +", shallow: " + shallow[i]);
        }

        // 3. 깊은 복사(System.arraycopy() 이용)
        System.out.println("----------3. 깊은 복사(System.arraycopy() 이용----------");
        // original과 shallow 초기화
        original = new int[]{10,20,30};
        shallow = new int[original.length];

        // 첫번째 인자값은 원본배열
        // 원본배열의 인덱스
        // 복사할 배열
        // 어디부터 복사할 위치
        // 개수
        // original 배열의 index 0부터 끝까지 shallow에 복사
        System.arraycopy(original, 0,shallow,0,original.length);

        // originalm shallow의 모든 요소 출력
        for(int i=0; i < original.length; i++)
        {
            System.out.println("original: " + original[i] +", shallow: " + shallow[i]);
        }

        shallow[0] = 99;
        original[0] = 88;

        for(int i=0; i < original.length; i++)
        {
            System.out.println("original: " + original[i] +", shallow: " + shallow[i]);
        }

        // 4. 깊은 복사(Array.copyOf() 이용
        System.out.println("----------깊은 복사(Array.copyOf() 이용----------");
        original = new int[]{11,21,31};
        // original의 복제를 만들고 길이는 original.length
        shallow = Arrays.copyOf(original, original.length);

        for(int i=0; i < original.length; i++)
        {
            System.out.println("original: " + original[i] +", shallow: " + shallow[i]);
        }

        // shallow[0] / original[0] 값을 수정
        shallow[0] = 78;
        original[0] = 67;

        // original, shallow의 모든 요소를 출력
        for(int i=0; i < original.length; i++)
        {
            System.out.println("original: " + original[i] +", shallow: " + shallow[i]);
        }

    }
}
