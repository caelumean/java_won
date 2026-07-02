package ch03;

import java.io.FileOutputStream;
import java.io.IOException;

// 2. 표준 입력장치(키보드) -> 파일(output.txt)
public class KeyboardToFile {
    void main(){
        try(
                // 프로젝트 기준으로 root에 생성된다.
                FileOutputStream fos = new FileOutputStream("output.txt");
        ) {
            // 표준 입력 장치로부터 1byte 읽어온다.
            int readData = 0;

            while((readData = System.in.read()) != -1){
                // fos: 출력 스트림
                // fos.write로 하면 된다.
                // 표준 출력 장치로 1byte로 출력한다.
                fos.write(readData);
            }
        }catch (IOException e){
            System.err.println("입출력 예외 발생: " + e.getMessage());

        }
    }
}
