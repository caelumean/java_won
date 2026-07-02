package ch03;

import java.io.*;

// 4. 파일(output.txt) -> 파일(output-copy.txt)
public class FileCopyTest {
    void main(){
        long start = System.currentTimeMillis();
//        copyFile("output.txt","output-copy.txt");
        copyFile("lib/mysql-connector-j-9.7.0.jar","mysql-connector-j-9.7.0.jar");

        long end = System.currentTimeMillis();
        System.out.println("소요시간: " + (end-start) + "ms");

        // --------------------------------------------------------
        long start1 = System.currentTimeMillis();
//        copyFileUseBuffer("output.txt","output-copy.txt");
        copyFileUseBuffer("lib/mysql-connector-j-9.7.0.jar","mysql-connector-j-9.7.0.jar");

        long end1 = System.currentTimeMillis();
        System.out.println("소요시간: " + (end1-start1) + "ms");

        // --------------------------------------------------------
        long start2 = System.currentTimeMillis();
//        copyFileCutomBuffer("output.txt","output-copy.txt");
        copyFileCutomBuffer("lib/mysql-connector-j-9.7.0.jar","mysql-connector-j-9.7.0.jar");

        long end2 = System.currentTimeMillis();
        System.out.println("소요시간: " + (end2-start2) + "ms");
    }

    /**
     * 1차 스트림(FileInputStream, FileOutputStream)을 이용해서 파일을 복사한다.
     * @param org 원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFile(String org, String  dest){
        try(
                InputStream fis = new FileInputStream(org);
                OutputStream fos = new FileOutputStream(dest);
        ){
            int readData = 0;

            while((readData = fis.read()) != -1){
                fos.write(readData);
            }
        }catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }

    /**
     * 2차 스트림(BufferedInputStream, BufferedOutputStream)을 이용해서 파일을 복사한다.
     * @param org 원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFileUseBuffer(String org, String  dest){
        try(
                InputStream bis = new BufferedInputStream(new FileInputStream(org));
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        ){
            int readData = 0;

            while((readData = bis.read()) != -1){
                bos.write(readData);
            }
        }catch(IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }

    /**
     * 3차 스트림(FileInputStream, FileOutputStream)을 이용해서 파일을 복사한다.
     * @param org 원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFileCutomBuffer(String org, String  dest){
        try(
                InputStream fis = new FileInputStream(org);
                OutputStream fos = new FileOutputStream(dest);
        ){
            // 버퍼의 처음부터 끝까지 출력함
            // 비어있는 부분은 null로 출력
            byte[] buffer = new byte[1024 * 8]; // 8KB의 버퍼 생성
            int readSize = 0;
            while((readSize = fis.read(buffer)) != -1){
                // buffer를 0부터 readSize까지 읽는다.
                fos.write(buffer, 0,readSize);
            }
        }catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}

