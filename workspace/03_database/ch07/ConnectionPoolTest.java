package ch07;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPoolTest {

    // DataSource에 커넥션을 반환해주는 getConnection이 있다.
    private static DataSource dataSource;

    // 커넥션 풀은 딱 한 번만 생성해야한다.
    static {
        HikariConfig config = new HikariConfig("/hikari.properties");
        dataSource = new HikariDataSource(config);
    }
    // mysql 접속
    // SSL: secure(보안)통신
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args){
        findAll();
        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
        findById(10);
        update(10, "수정된 10번 게시글", "수정했어요");
        findAll();
        delete(10);
        findAll();
        deleteAll(1);
        findAll("자바");

        login("haru@gmail.com","123");
        login("haru@gmail.com","pwd123");
        // SQL Injection
        // PreparedStatement는 SQL Injection에 안전해진다.
        login("haru@gmail.com' OR '1'='1","asdfafasas");

        // 메인 메서드 마지막에 풀을 명시적으로 종료
        if(dataSource != null){
            // 커넥션을 해제할려면 부모 클래스인 DataSource에는 close가 없기 때문에
            // 자식클래스로 다시 다운캐스팅을 해서 close를 해주면된다.
            ((HikariDataSource)dataSource).close();
        }
    }
    // 로그인
    public static void login(String email, String password){
        String sql = "SELECT * FROM member WHERE email = ? AND password = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. 데이터베이스 연결 설정(Connection 객체 생성)
            conn = dataSource.getConnection();

            // 2. SQL 실횅 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행(SELECT)
            // 4. 결과 수신(ResultSet 객체 생성)
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

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
            try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    // 등록(C)
    static void insert(int memberId, String title, String content){
        String sql = "INSERT INTO post (member_id, title, content) VALUES (?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            // 첫번째 물음표에는 int형 memberId
            pstmt.setInt(1, memberId);
            // 두번째 물은표에는 String형 title
            pstmt.setString(2, title);
            // 세번째 물음표에는 String형 content
            pstmt.setString(3, content);
            int affectedRows = pstmt.executeUpdate();

//            System.out.println("게시글 등록 완료: " + affectedRows + "건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {

            try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    // 모든 게시글 목록 조회(R)
    static void findAll(){
        findAll("");
    }
    // 게시글 검색 목록 조회(R)
    static void findAll(String keyword){

        String sql = "SELECT id, member_id,title, content, view_count viewCount, created_at AS createdAt FROM post";

        // 의미있는 검색어가 전달되었을 경우
        boolean hasKeyword = keyword != null && !keyword.equals("");

        // 객체가 아닌값은 null이 될 수 없다
        // 그래서 boolean에 넣어서 전달하는 것이다.
        if(hasKeyword){
            sql += " WHERE title LIKE ? OR content LIKE ?";
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            // prepareStatement 만들때 미리 sql을 넘긴다
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if(hasKeyword){
                pstmt.setString(1, "%"+keyword+"%");
                pstmt.setString(2, "%"+keyword+"%");
            }


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
            try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    // 한건 조회(R)
    static void findById(int id){
        String sql = "SELECT * FROM post WHERE id="+id;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
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
            try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    // 수정(U)
    static void update(int id, String title, String content){
        String  sql = "UPDATE post SET title = ?, content = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, id);

            // executeUpdate: 위에 있는 값을 보낸다
            int affectedRows = pstmt.executeUpdate();
            System.out.println("게시글 수정 완료 " + affectedRows +"건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    // 지정한 id의 게시글 삭제(D)
    static void delete(int id){
        String sql = "DELETE FROM post WHERE id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            System.out.println(id + "번 게시글 삭제 완료 " + affectedRows +"건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
    // 지정한 회원의 모든 게시글 삭제(D)
    static void deleteAll(int memberId){
        String sql = "DELETE FROM post WHERE member_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberId);
            int affectedRows = pstmt.executeUpdate();
            System.out.println(memberId + "번 회원의 게시글 삭제 완료 " + affectedRows +"건 반영됨.");

        } catch (Exception e) { // 플랜 B
            System.out.println("에러 발생: " + e.getMessage());
        } finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if(conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
