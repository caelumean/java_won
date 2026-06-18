package ch07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPostTest_1 {
    // mysql 접속
    // SSL: secure(보안)통신
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args){
        findAll();
//        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
//        findById(10);
//        update(10, "수정된 10번 게시글", "수정했어요");
//        findAll();
//        delete(10);
//        findAll();
        deleteAll(1);
        findAll();
    }

    // 등록(C)
    static void insert(int memberId, String title, String content){
        String sql = "INSERT INTO post (member_id, title, content) VALUES ("+memberId+", '"+title+"', '"+content+"')";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            int affectedRows = stmt.executeUpdate(sql);

            System.out.println("게시글 등록 완료: " + affectedRows + "건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {

            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    // 목록 조회(R)
    static void findAll(){
        String sql = "SELECT id, member_id,title, content, view_count viewCount, created_at AS createdAt FROM post";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // while문 안에서 각각의 컬럼값들을 꺼내와서 사용하면 된다.
            // 4. 결과 처리 (ResultSet사용)
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int viewCount = rs.getInt("viewCount");
                String createdAt =  rs.getString("createdAt");
                String memberId = rs.getString("member_id");

                System.out.println("ID: " + id + ", 아이디: "+ memberId +", 제목: " + title + ", 조회수: " + viewCount + ", 작성일: " + createdAt) ;
            }
        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(rs != null) rs.close(); } catch (Exception e) {}
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    // 한건 조회(R)
    static void findById(int id){
        String sql = "SELECT * FROM post WHERE id="+id;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            // 쿼리문의 결과문 다음행으로 이동한다.
            // 현재 가리키고 있는 행을 다음 행으로 이동
            rs.next();

            // 이름으로 꺼내는 것을 추천한다.
            // 그래야 쿼리문이 수정되어도 코드의 순서 변동이 없다.
            while(rs.next()){
                String title = rs.getString("title");
                String content = rs.getString("content");
                int viewCount = rs.getInt("viewCount");
                String createdAt = rs.getString("createdAt");

                System.out.println("제목: " + title + ", 내용: " + content + ", 조회수: " + viewCount + ", 작성일: " + createdAt);
            }


        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(rs != null) rs.close(); } catch (Exception e) {}
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    // 수정(U)
    static void update(int id, String title, String content){
        String  sql = "UPDATE post SET title = '"+title+"', content = '"+content+"' WHERE id = " +id;
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            int affectedRows = stmt.executeUpdate(sql);
            System.out.println("게시글 수정 완료 " + affectedRows +"건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    // 지정한 id의 게시글 삭제(D)
    static void delete(int id){
        String sql = "DELETE FROM post WHERE id = " + id;
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
            int affectedRows = stmt.executeUpdate(sql);
            System.out.println(id + "번 게시글 삭제 완료 " + affectedRows +"건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    // 지정한 회원의 모든 게시글 삭제(D)
    static void deleteAll(int memberId){
        String sql = "DELETE FROM post WHERE member_id = " + memberId;
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
            int affectedRows = stmt.executeUpdate(sql);
            System.out.println(memberId + "번 회원의 게시글 삭제 완료 " + affectedRows +"건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(stmt != null) stmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}