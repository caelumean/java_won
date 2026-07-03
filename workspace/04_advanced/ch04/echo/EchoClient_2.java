package ch04.echo;

import java.io.*;
import java.net.Socket;

public class EchoClient_2 {
    void startClient(){
        try(
                // 서버에 접속 요청(localhost: 50000)
//                Socket s = new Socket("localhost", 50000);
                Socket s = new Socket("dain2.iptime.org", 50000);

        ){
            // System.in은 try때 close되면 안되기때문에 여기로 옮긴다.
            // 키보드에서 줄단위로 읽기 위한 스트림
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            // Socket에서 데이터를 읽을 수 있는 InputStream 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // Socket으로 데이터를 전송할 수 있는 OutputStream 생성
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);

            System.out.println("서버 접속 완료.");
            String readData = "";
            while((readData = key.readLine()) != null){
//                System.out.println("키보드 : " + readData);
                out.println(readData);
                String echoData = in.readLine();
                System.out.println(echoData);
        }
        }catch (IOException e){
            System.err.println("네트워크 오류 발생: " + e.getMessage());
        }
    }
    void main(){
        startClient();
    }
}
