SELECT * FROM post;

SELECT * FROM member;

-- 2번 회원 탈퇴시 게시글 삭제 옵션을 선택한 경우
-- 커밋이나 롤백이 적용되기 전까지는 모든 변경사항은 메모리에만 반영이 되고 DB에 적용하지 않는다
START TRANSACTION;

-- 2번 회원의 게시글 먼저 삭제
DELETE FROM post WHERE member_id = 2;

-- 2번 회원 삭제
DELETE FROM member WHERE id = 2;

-- 정상 완료시 DB에 반영
-- commit하는 순간 영구적인 반영이다.
COMMIT;

-- 오류가 발생해서 원래 상태로 복구
ROLLBACK;

-- 현재 세션의 격리 수준을 READ COMMITTED로 변경
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;

-- 글로벌(전체 세션) 격리 수준을 REPEATABLE READ로 변경 (이후 접속하는 모든 세션에 적용)
SET GLOBAL TRANSACTION ISOLATION LEVEL REPEATABLE READ;








