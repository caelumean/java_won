package ch09;

public class ScoreArrayTest
{
    public  static void main(String[] args)
    {
        int kor = 100;  // 국어 점수
        int eng = 90;   // 영어 점수
        int math = 85;  // 수학 점수

        int[] haruScore;  // 1-1. 배열 선언
        haruScore = new int[3]; // 1-2. 배열 생성(개수 지정), 12byte의 메모리(힙) 할당하고 그 주소를 반환
        haruScore[0] = 100; // 1-3. 배열 요소에 값 할당(index를 이용해서 배열에 접근)
        haruScore[1] = 90;
        haruScore[2] = 85;

        // 2. 배열 선언과 생성을 동시에
        int[] haruScore1 = new int[3];  // 2-1 선언과 생성
        haruScore1[0] = 100; // 2-2. 배열 요소에 값 할당(index를 이용해서 배열에 접근)
        haruScore1[1] = 90;
        haruScore1[2] = 85;

        // 3. 배열 선언, 생성,초기화를 동시에
        // int[] haruScore2 = new int[]{100, 90, 85};
        int[] haruScore2 = {100, 90, 85};

        // String형 배열 : referece(참조값)을 저장하는 배열
        // 문자열 객체의 주소(참조값) 저장
        // 4 ~ 8byte
        String[] ha;
        ha = new String[5];
    }
}
