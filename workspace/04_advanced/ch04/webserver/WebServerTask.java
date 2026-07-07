package ch04.webserver;

import java.io.*;
import java.net.Socket;

public class WebServerTask implements Runnable{
    private final Socket s;
    WebServerTask(Socket s){
        this.s = s;
    }
    @Override
    public void run() {
        try(Socket clientSocket = this.s) {
            // 클라이언트의 메세지를 수신하는 InputStream 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // 클라이언트의 메세지를 송신하는 OutputStream 생성
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()),true);

            // 클라이언트가 전달하는 1줄
            String line = "";

            System.out.println("======== 요청헤더 시작 ========");

            String requestLine = in.readLine();
            String[] requestLineArr = requestLine.split(" ");
            String url = requestLineArr[1];
            System.out.println("URL: " + url);

            System.out.println(requestLine);
            // 여기서 블로킹 상태가 된다.
            while((line = in.readLine()) != null) {
                // 빈 줄일 경우 요청 헤더의 끝을 나타냄
                if(line.isEmpty()){
                    break;
                }
                System.out.println(line);
            }
            System.out.println("======== 요청헤더 종료 ========");


            // HTTP 응답 헤더 작성
            String header = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html; charset=UTF-8\r\n";
            String body = loadFile(url.substring(1));
//            out.println("<h1>Hello Web</h1>");

            out.println(header);
            out.println(body);
            out.close();
        }catch (IOException e){
            System.err.println("네트워크 예외 발생: " + e.getMessage());
//            e.printStackTrace();
        }
    }

    /**
     * 지정한 파일을 읽어서 문자열로 반환한다.
     * @param path 파일 경오
     * @return 읽은 파일 문자열
     */
    String loadFile(String path) {
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader("resources/" + path))) {
            String line = "";
            while((line = br.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 실패 " + e.getMessage());
        }
        return result;
    }
}
