-- 1번 댓글 삭제
select * FROM reply WHERE id = 1;
DELETE FROM reply
    WHERE id = 1;

-- 2번 게시글 삭제 (댓글 테이블 생성 시 ON DELETE CASCADE 제약 조건을 지정했으므로, 게시글 삭제 시 관련된 하위 댓글 데이터도 함께 자동 삭제됨)
select * from post where id = 2;
DELETE FROM post
    WHERE id = 2;

-- 1번 회원 삭제 (게시글 테이블 생성 시 ON DELETE CASCADE 제약 조건을 지정했으므로, 회원 삭제 시 관련된 하위 게시글 데이터의 FK값이 NULL이 된다.)
select * from member where id = 1;
delete from member where id = 1;