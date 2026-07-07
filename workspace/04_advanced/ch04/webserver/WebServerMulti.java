package ch04.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 50000 port를 열고 서버를 기다리는 코드
// 클라이언트로부터 수신된 메세지를 그대로 반송
// 네트워크 프로그램 개발 시 가장 먼저 만들어서
// 클라이언트와 서버간의 통신 상태를 확인하는 데 사용
public class WebServerMulti {
    void startServer(){
        try(
                // try 구간이 끝나면 자동으로 자원을 회수할 수 있도록
                // try 구간 안에 넣는다.
                // 서버 소켓을 생성
                ServerSocket ss = new ServerSocket(8080);
        ){
            System.out.println("웹서버 구동 완료 8080");
            while(true){
                // 소켓 객체를 accept로 꺼내오면 된다.
                // 클라이언트의 접속 대기
                Socket s = ss.accept(); // 블로킹 작업
                // 주소
                System.out.println("클라이언트 접속: " + s.getInetAddress().getHostAddress());
                WebServerTask worker = new WebServerTask(s);
                new Thread(worker).start();
            }
        }catch (IOException e){
            System.err.println("네트워크 오류: " + e.getMessage());
        }
    }
    void main(){
        startServer();
    }
}
