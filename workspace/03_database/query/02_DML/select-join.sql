-- 모든 게시글의 모든 컬럼 조회
SELECT * FROM post;

-- 모든 게시글의 id, member_id, title, view_count 컬럼 조회
select id, member_id, title, view_count from post;

-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회
-- INNER JOIN은 정확히 매칭되는 애들만 만나서 결과물을 만들어 낸다.
SELECT post.id, member_id, title, view_count, member.name, member.email 
FROM post
INNER JOIN member ON post.member_id = member.id ;

-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
-- 테이블 뒤에 별칭을 붙일때 as를 붙여도 되고 안붙여도 된다.
SELECT p.id, p.member_id, p.title, p.view_count, m.name, m.email 
FROM post p
INNER JOIN member as m ON p.member_id = m.id;

-- 모든 댓글 조회
select * from reply;

-- 모든 댓글의 id, content, member_id, post_id 조회
select id, content, member_id, post_id from reply;

-- 모든 댓글의 id, content, member_id, post_id, 작성자이름, 게시글 제목 조회
select reply.id, reply.content, reply.member_id, reply.post_id, member.name, post.title 
from reply 
INNER JOIN member ON reply.member_id = member.id
INNER JOIN post ON reply.post_id = post.id;

-- 게시글 기준으로 정렬
-- '댓글 작성자'라고도 쓸 수 있다. (권장사항아님)
select post.title 게시글, reply.content 댓글, member.name 댓글작성자
from reply 
INNER JOIN member ON reply.member_id = member.id
INNER JOIN post ON reply.post_id = post.id
ORDER BY post.id DESC, reply.id;

-- LEFT OUTER JOIN
-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
SELECT p.id, p.member_id, p.title, p.view_count, m.name, m.email 
FROM post p
LEFT OUTER JOIN member as m ON p.member_id = m.id;

-- 전체 회원 목록과 각 회원이 작성한 게시글 수를 조회하세요(게시글을 작성하지 않은 회원도 포함되어야 함)
-- 전체 회원 목록 조회
select * from member;

-- 필요한 컬럼만 추출\
-- count 안에 별표가 있으면 널값임에도 불구하고 레코드가 하나있어도 카운트한다.
select m.id, m.name, count(p.id) post_count
from member m
left join post p on m.id = p.member_id
group by m.id, m.name;


-- RIGHT OUTER JOIN
-- 모든 게시글의 id, member_id, title, view_count, 작성자이름, 작성자이메일 컬럼 조회(alias 사용)
SELECT p.id, p.member_id, p.title, p.view_count, m.name, m.email 
FROM post p
RIGHT OUTER JOIN member as m ON p.member_id = m.id;

-- LEFT/RIGHT 양쪽다 나오게 하는 방법
-- FULL OUTER JOIN(MySQL은 지원하지 않으므로 UNION으로 대체 가능)
select m.id as member_id, m.name, p.title
from member m
left join post p on m.id = p.member_id
UNION 
select m.id as member_id, m.name, p.title
from member m
right join post p on m.id = p.member_id;


-- SELF JOIN
-- 회원명과 추천인명을 조회
select m1.name 회원명, m1.recommender_id, ifnull(m2.name, '-') 추천인명 
from member m1
left join member m2 on m1.recommender_id  = m2.id; -- 모든 회원명과 추천인명을 조회
-- inner join member m2 on m1.recommender_id = m2.id; -- 추천인이 있는 회원명과 추천인명을 조회




