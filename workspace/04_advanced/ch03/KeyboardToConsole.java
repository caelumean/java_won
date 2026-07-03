package ch03;

import java.io.IOException;

// 1. 표준 입력장치(키보드) -> 표준출력장치(콘솔)
// 읽을때는 read / 출력할때는 write
public class KeyboardToConsole {
    void main(){
        try {
            // 표준 입력 장치로부터 1byte 읽어온다.
//            int readData = System.in.read();
            int readData = 0;

            // os는 하나입력할 때마다 보내는게 아니라
            // 엔터를 친다는 기준으로 버퍼에 저장했다가 보낸다.
            // 엔터를 칠 때까지 기다린다.
            while((readData = System.in.read()) != -1){
                // 표준 출력 장치로 1byte 출력한다.
                System.out.write(readData);
            }
        }catch (IOException e){
            System.err.println("입출력 예외 발생: " + e.getMessage());

        }
    }
}
