package ch08;

public class ForTest5
{
    public static void main(String[] args)
    {
        // star1();
        // star2();
        // star3();
         star4();

    }
    // *
    // **
    // ***
    // ****
    // *****
    static void star1()
    {
        for(int i=0; i<1; i++){
            System.out.print("*"); // *
        }
        System.out.println();

        for(int i=0; i<2; i++){
            System.out.print("*"); // **
        }
        System.out.println();

        for(int i=0; i<3; i++){
            System.out.print("*"); // ***
        }
        System.out.println();

        for(int i=0; i<4; i++){
            System.out.print("*"); // ****
        }
        System.out.println();

        for(int i=0; i<5; i++){
            System.out.print("*"); // *****
        }
        System.out.println();
    }

    static void star2()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < i+1; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // *****
    // ****
    // ***
    // **
    // *
    static void star3()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5-i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void star4()
    {
        for(int i=0;i<5;i++)
        {
            for(int j = 0;j < (5-1-i); j++)
            {
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++)
            {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
