package ch08;

// 1~9 구구단
// 2 x 1 = 2  3 x 1 = 3  4 x 1 = 4  ... 9 x 1 = 9
// 2 x 2 = 4  3 x 2 = 6  4 x 2 = 8  ... 9 x 2 = 18
// ...        ...        ...        ... ...
// 2 x 9 = 10 3 x 9 = 27 4 x 9 = 36 ... 9 x 9 = 81
public class ForTest6
{
    public static void main(String[] args)
    {
        for(int i=1; i<=9; i++)
        { // 9행
            for(int k=2; k<=9; k++)
            { // 8열
                System.out.print(k + "x" + i + "=" + (k*i) + "\t"); // k= 2, 3, 4 ... 9
            }
            System.out.println();
        }
    }
}