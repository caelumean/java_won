package ch07;

import java.sql.*;

public class JdbcMemberTest {
    // mysql 접속
    // SSL: secure(보안)통신
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";   // 1111 안되면 3333 시도

    public static void main(String[] args){
        // 회원 목록 조회
//        selectAllMembers();
//        // 회원 등록
//        insertMember("haru"+ (int)(Math.random() * 1000) + "@gmail.com", "1234", "뉴하루","01022221111",2);
//        // 3번 회원 수정
//        updateMemeber(3, "3333","3번회원", "01033333333");
//        // 1번 회원 삭제
        deleteMember(1);
//        // 회원 목록 조회
//        selectAllMembers();

//        login("haru@gmail.com","123");
//        login("haru@gmail.com","pwd123");
        // SQL Injection
        // 이런 공격이 가능해진다.
//        login("haru@gmail.com' OR '1'='1","asdfafasas");
    }

    // 로그인
    public static void login(String email, String password){
        String sql = "SELECT * FROM member WHERE email = '"+email+"' AND password= '"+password+"'";
        System.out.println("로그인 쿼리: " + sql);
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. 데이터베이스 연결 설정(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실횅 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            rs = stmt.executeQuery(sql);

            // while문 안에서 각각의 컬럼값들을 꺼내와서 사용하면 된다.
            // 쿼리문의 결과문 다음행으로 이동한다.
            // 현재 가리키고 있는 행을 다음 행으로 이동
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("로그인에 성공했습니다.");
                System.out.println("ID: " + id + ", 이메일: " + email + ", 이름: " + name + ", 전화번호: " + phone);
            }else{
                System.out.println("아이디와 패스워드를 확인하세요.");
            }

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            // 전화를 했으면 끊는 것처럼 끊어야 한다.
            // 안끊으면 자원이 계속 새어나간다.
            try { if(rs != null) rs.close(); } catch (Exception e) {}
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }


    }

    // 회원 목록 조회
    public static void selectAllMembers(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
           // 1. 데이터베이스 연결 설정(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실횅 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            rs = stmt.executeQuery("SELECT * FROM member");

            // while문 안에서 각각의 컬럼값들을 꺼내와서 사용하면 된다.
            // 쿼리문의 결과문 다음행으로 이동한다.
            // 현재 가리키고 있는 행을 다음 행으로 이동
            while(rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("ID: " + id + ", 이메일: " + email + ", 이름: " + name + ", 전화번호: " + phone);
            }
        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            // 전화를 했으면 끊는 것처럼 끊어야 한다.
            // 안끊으면 자원이 계속 새어나간다.
            try { if(rs != null) rs.close(); } catch (Exception e) {}
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    // 회원 등록
    public static void insertMember(String email, String password, String name, String phone, int recommenderId){

        Connection conn = null;
        Statement stmt = null;

        try {
            // 플랜 A
            // 1. 데이터베이스 연결 설정(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실횅 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            int affectedRows = stmt.executeUpdate("INSERT INTO member(email, password, name, phone, recommender_id) VALUES  \n" +
                    "('"+email+"', '"+password+"', '"+name+"', '"+phone+"', "+recommenderId+")");

            System.out.println("회원 등록 완료: " + affectedRows + "건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    // 회원 수정
    public static void updateMemeber(int id, String password, String name, String phone){
        Connection conn = null;
        Statement stmt = null;

        try {
            // 플랜 A
            // 1. 데이터베이스 연결 설정(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실횅 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            int affectedRows = stmt.executeUpdate("UPDATE member SET password = '"+password+"', name = '"+name+"', phone ='"+phone+"' WHERE id = " +id);
            System.out.println("회원 수정 완료 " + affectedRows +"건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    // 회원 삭제(회원의 게시글도 같이 삭제)
    public static void deleteMember(int id){
        Connection conn = null;
        Statement stmt = null;

        try {
            // 플랜 A
            // 1. 데이터베이스 연결 설정(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실횅 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 트랜잭션 제어를 위해 자동 커밋 중지
            conn.setAutoCommit(false);

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            int affectedRows = stmt.executeUpdate("DELETE FROM post WHERE member_id=" +id);
            System.out.println("회원의 모든 게시글 삭제 완료: " + affectedRows + "건 반영됨.");

            // 10초 동안 휴식
            Thread.sleep(1000 * 10);

            affectedRows = stmt.executeUpdate("DELETE FROM member WHERE id=" + id);
            System.out.println("회원 삭제 완료 " + affectedRows +"건 반영됨.");

            // 성공
            conn.commit();

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());

            // 실패하면 catch구간에서 롤백을 실행하는 곳
            try { if(conn != null) conn.rollback(); } catch (Exception e2) {}
            e.printStackTrace();
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
