package ch09;

public class ArrayBasic
{
    public static void main(String[] args)
    {
        // scores int 배열을 선언하고 생성하세요. (크기는 3)
        int[] scores = new int[3];

        // names String 배열을 선언하고 생성하세요.(크기는 5)
        String[] names = new String[5];

        // scores 배열의 각 요소에 값을 할당
//        scores[0] = 100;
//        scores[1] = 90;
//        scores[2] = 85;

        for(int i = 0; i < scores.length; i++)
        {
            scores[i] = (int)(Math.random() * 101);
            System.out.print(scores[i] + " ");
        }
        System.out.println();
        // names 배열의 각 요소에 값을 할당
        names[0] = "Lucy";
        names[1] = "Emma";
        names[2] = "Alex";
        names[3] = "Mia";
        names[4] = "Mike";

        // scores 배열의 두번째 요소값을 출력
        System.out.println("scores 배열의 두번째 값: " + scores[1]);

        // names 배열의 모든 요소 값을 출력
        for(int i = 0; i < names.length; i++)
        {
            System.out.print(names[i] + " ");
        }
    }
}
