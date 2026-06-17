-- 1. 게시글 목록 조회 (작성자 이름, 댓글 수 포함, 최신 등록순 정렬)
-- 작성한지 24시간 이내의 게시글 제목 앞에 (New) 추가
-- 댓글이 3개 이상 달린 게시글 제목 앞에 (Best) 추가

SELECT m.name 
FROM post p
LEFT JOIN member m ON m.id = p.member_id;

SELECT p.id, p.title, count(r.id) as 댓글수
FROM post p
LEFT JOIN reply r on p.id = r.post_id
GROUP BY p.id, p.title;

-- 댓글이 3개이상인 게시글
SELECT p.title, COUNT(r.id) AS reply_count
FROM post p
LEFT JOIN reply r on p.id = r.post_id
GROUP BY p.id, p.title
HAVING count(r.id) >= 3;

-- 24시간 이내 작성한 최신글
select title, created_at
from post 
where created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR);

-- 1번문제
SELECT p.id, m.name,
CASE 
	WHEN p.created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR) THEN CONCAT('(NEW)',title) 
	WHEN COUNT(r.id) >= 3 THEN CONCAT('(BEST)',title)
	ELSE title
END AS title,
p.created_at,
count(r.id) as 댓글수
FROM post p
LEFT JOIN member m on p.member_id = m.id
LEFT JOIN reply r on p.id = r.post_id
GROUP BY p.id, p.title, p.created_at, m.name
ORDER BY p.created_at DESC;

-- 실험1. case 2개 실험
SELECT p.id, m.name,
CASE 
	WHEN p.created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR) THEN CONCAT('(NEW)',title) 
	ELSE title
END AS title,
CASE 
	WHEN COUNT(r.id) >= 3 THEN CONCAT('(BEST)',title)
	ELSE title
END AS title,
p.created_at,
count(r.id) as 댓글수
FROM post p
LEFT JOIN member m on p.member_id = m.id
LEFT JOIN reply r on p.id = r.post_id
GROUP BY p.id, p.title, p.created_at, m.name
ORDER BY p.created_at DESC;

-- 실험2. if문 실험 
select p.id, m.name,
 if(p.created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR),CONCAT('(NEW)',title), title) AS NEW_TITLE,
 if(COUNT(r.id) >= 3, CONCAT('(BEST)',title), title) AS BEST_TITLE,
 p.created_at,
 count(r.id) as 댓글수
FROM post p
LEFT JOIN member m on p.member_id = m.id
LEFT JOIN reply r on p.id = r.post_id
GROUP BY p.id, p.title, p.created_at, m.name
ORDER BY p.created_at DESC;

-- 실험3. if문 하나로 
-- NEW조건과 BEST조건 둘 다 충족시 둘 다 뜨게
select p.id, m.name,
 CONCAT(
 if(p.created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR),'(NEW)', ''),
 if(COUNT(r.id) >= 3,'(BEST)',''),
 p.title) AS title,
 p.created_at,
 count(r.id) as 댓글수
FROM post p
LEFT JOIN member m on p.member_id = m.id
LEFT JOIN reply r on p.id = r.post_id
GROUP BY p.id, p.title, p.created_at, m.name
ORDER BY p.created_at DESC;

-- 실험4. case 두개를 하나로 
-- NEW조건과 BEST조건 둘 다 충족시 둘 다 뜨게
SELECT p.id, m.name,
CONCAT(
CASE 
	WHEN p.created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR) THEN '(NEW)'
	ELSE ''
END,
CASE 
	WHEN COUNT(r.id) >= 3 THEN '(BEST)'
	ELSE ''
END,
p.title) AS title, 
p.created_at,
count(r.id) as 댓글수
FROM post p
LEFT JOIN member m on p.member_id = m.id
LEFT JOIN reply r on p.id = r.post_id
GROUP BY p.id, p.title, p.created_at, m.name
ORDER BY p.created_at DESC;
	  

-- 2. 게시글 상세 조회 (게시글 제목, 내용, 작성자 이름, 이메일, 댓글 작성자 이름, 댓글 내용 조회)
SELECT IFNULL(p.title,'-') as '게시글 제목', IFNULL(p.content,'-') as '내용', IFNULL(m.name,'-') as '작성자 이름', IFNULL(m.email,'-') as '이메일',IFNULL(m.name,'-') as '작성자 이름', IFNULL(r.content,'-') as '댓글 내용'
FROM post p
LEFT JOIN member m ON m.id = p.member_id
LEFT JOIN reply r ON r.post_id = p.id
LEFT JOIN member m2 ON m2.id = r.member_id;

-- 3. 게시글 등록 (새로운 게시글 작성)
INSERT into post (member_id, title, content) VALUES (6, '오늘 금발로 염색했습니다~','미용실에서 금발로 염색했는데 GD같네요ㅋㅋㅋ');

-- 4. 게시글 수정 (2번 게시글의 제목과 내용 변경)
UPDATE post 
SET title = '자바 복습 완전 정복',
	content = '자바 복습을 하는 방법 1. 그날 배운 걸 TIL한다.'
WHERE id = 2;

-- 5. 게시글 삭제 (3번 게시글 삭제)
-- 가장 최신글 삭제 방법
-- 1. 24시간 이내 작성된 게시글 삭제
DELETE FROM post WHERE created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR);
-- 2. max로 가장 최신글 삭제
-- FOR UPDATE: 내가 조회하는 동안 락거는 거
-- mysql에서는 delete시 서브쿼리 안된다
DELETE FROM post WHERE created_at = (select MAX(created_at from post FOR UPDATE);

DELETE FROM post WHERE id = (SELECT MAXI(id) FROM post);

-- 6. 게시글 검색 (제목 또는 내용에 '자바'가 포함된 게시글 조회)
SELECT title, content
FROM post
WHERE title LIKE '%자바%'
	OR content LIKE '%자바%';

-- 7. 게시글 페이징 조회 (최신순으로 2페이지 분량의 게시글 10건 조회)
SELECT *
FROM post
ORDER BY created_at DESC
LIMIT 10,10;

