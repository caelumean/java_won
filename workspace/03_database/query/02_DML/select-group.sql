-- 각 회원별로 작성한 게시글 개수를 조회
-- 그룹핑하지 않은 것은 group by를 쓸 수 없다.
select member_id, count(*) as post_count
from post
group by member_id;

-- 각 게시글 별로 댓글 수 조회 (댓글 수로 내림차순 정렬)
select post_id, count(*) as reply_count
from reply
group by post_id
order by reply_count desc;

-- 회원별로 작성한 게시글의 수, 총 조회수 조회 (게시글 내림차순, 조회수 내림차순 정렬)
select member_id, count(*) as post_count, sum(view_count) as total_views
from post
group by member_id
order by post_count, total_views desc;

-- 가입 연도별 회원수 조회
select date_format(created_at, '%Y') as join_year, count(*) join_count
from member
group by date_format(created_at, '%Y');

-- 회원별로 작성한 게시글의 수, 총 조회수 조회(게시글이 5개 이상인 경우만)
-- having절에서는 as를 쓰면 데이터베이스 호환성이 안된다.
select member_id, count(*) as post_count, sum(view_count) as total_views
from post
group by member_id
having post_count >= 5
order by post_count, total_views desc;

-- 에러 발생: title이 GROUP BY 기준에 존재하지 않음
SELECT member_id, title, COUNT(*) AS post_count
    FROM post
    GROUP BY member_id;

-- 해결 방법 1: 집계 함수를 적용하여 단일 결과값으로 보장
SELECT member_id, MAX(title), COUNT(*) AS post_count
    FROM post
    GROUP BY member_id;

-- 해결 방법 2: group_concat을 사용해 여러 개의 title을 하나의 텍스트로 합침
-- separator 기본값은 ,(콤마)이다.
SELECT member_id, GROUP_CONCAT(title separator ','), COUNT(*) AS post_count
    FROM post
    GROUP BY member_id;

-- 해결 방법3: 해당 컬럼도 group by 기준에 추가하여 공동 그룹으로 묶음
SELECT member_id, title, COUNT(*) AS post_count
    FROM post
    GROUP BY member_id, title;

-- 그룹된 조건은 having으로 가야한다.(중요)
-- 게시글을 2개 이상 작성한 회원의 id와 게시글 수 조회 (HAVING 사용)
SELECT member_id, COUNT(*)
    FROM post
    GROUP BY member_id
    HAVING COUNT(*) >= 2;
















