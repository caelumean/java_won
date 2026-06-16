-- 가장 오래전에 가입한 회원의 정보 조회

-- 가장 오래된 회원의 가입일
select MIN(created_at) from member;

-- 회원 정보 조회
select * from member;

-- 가장 오래전에 가입한 회원의 정보 조회(하드코딩)
select *
from member
where created_at = '2025-05-10 12:13:45';

-- 가장 오래전에 가입한 회원의 정보 조회(서브코딩)
-- select안에 select가 있는 걸 서브쿼리라고 한다.
select *
from member
where created_at = (select MIN(created_at) from member);

-- 게시글을 하나라도 작성한 회원 id 추출
SELECT DISTINCT member_id  FROM post WHERE member_id IS NOT NULL;

-- id가 1이나 2인 회원 조회
SELECT * 
FROM member
WHERE id IN (1,2);

-- 게시글을 하나라도 작성한 회원의 정보 조회
SELECT * 
FROM member
WHERE id IN (SELECT DISTINCT member_id  FROM post WHERE member_id IS NOT NULL);

-- 게시글 조회(id, title)
select id, title from post;

-- 1번 게시글의 댓글 수 조회
select count(*) from reply where post_id = 1;

-- 각 게시글과 함께 해당 게시글의 댓글 수 조회
select id, title, (select count(*) from reply where post_id = post.id) as reply_count
from post;

-- 각 게시글과 함께 해당 게시글의 댓글 수 조회(조인)
select p.id, p.title, count(r.id) 
from post p
LEFT JOIN reply r ON p.id = r.post_id
group by p.id, p.title;

-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수보다 많은 글을 작성한 회원 조회

-- 게시글을 하나라도 작성한 회원 id 추출
SELECT DISTINCT member_id  FROM post WHERE member_id IS NOT NULL;

-- 게시글을 한 건이라도 작성한 회원의 게시글 수 조회
select member_id, COUNT(*)
from post
where member_id is not NULL
group by member_id;

-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수 조회
SELECT  avg(cnt)
from (
	select member_id, COUNT(*) as cnt
	from post
	where member_id is not NULL
	group by member_id
) as sub;

-- 게시글을 한 건이라도 작성한 회원의 평균 게시글 수보다 많은 그을 작성한 회원 조회
select member_id, COUNT(*) as post_count
from post 
where member_id is not NULL 
group by member_id 
having count(*) > (
SELECT  avg(cnt)
	from (
		select member_id, COUNT(*) as cnt
		from post
		where member_id is not NULL
		group by member_id
	) as sub
);















