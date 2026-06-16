-- 회원 이름 조회
SELECT name, email, CONCAT(name,'(', email,')') as member_info
FROM MEMBER;

-- utf-8방식은 영어는 1byte 한글은 3byte
-- 각 회원의 이메일 바이트 크기 조회
select email,LENGTH('hello'), LENGTH('안녕하세요'),length(email) as email_length
from member;

-- 게시글 본문 중 '안녕하세요'가 있는 내용을 찾아서 Hi로 수정
select content, REPLACE(content, '안녕하세요', 'Hi') as replaced_content
from post
where content like '%안녕하세요%';

-- 게시글 본문의 첫 10글자만 미리보기로 가져오기
-- 잘린 뒷부분은 ...으로 표시하세요
select title, CONCAT(SUBSTRING(content, 1, 10),'...') as preview
from post;

-- 이메일을 소문자/대문자로 조회
select email, lower(email) as email_lower, UPPER(email) as email_upper
from member;

-- 이메일 앞뒤 공백 제거
select email, TRIM(email) as trimmed_email
from member;

-- 현재 날짜와 시간을 조회
select now() as current_datetime;

-- 게시글 작성일을 연-월-일 형식으로 조회
-- %Y: 4자리 / %y: 2자리
-- %H: 24시 / %h: 12시
-- %w: 요일 전체이름(영어) %a: 요일 축약형(영어)
select id, title, DATE_FORMAT(created_at, '%Y년 %m월 %d일 %a %H시 %i분 %s초') as write_date
from post;

-- 현재 날짜만 조회
select CURDATE() as cur_date
from post
where created_at >= CURDATE();

-- 오늘 작성된 게시글만 조회
select id, title, created_at
from post 
where created_at >= CURDATE();

-- 최근 7일 이내에 가입한 회원 조회
-- interval: 간격
-- 시간을 빼고 싶으면 curdate()
select id, name, created_at, CURDATE(), date_sub(CURDATE(), interval 7 day) as before_7days
from member
where created_at >= date_sub(now(), interval 7 day);

-- 가입한 지 1개월이 지난 회원 조회
select id, name, created_at, date_sub(now(), interval 1 month) as before_1month
from member
where created_at <= date_sub(now(), interval 1 month);

-- 가입한 지 35일 12시간이 지난 회원 조회
select id, name, created_at, date_sub(now(), interval '35 12' day_hour) as before_1month
from member
where created_at <= date_sub(now(), interval '35 12' day_hour);

-- 각 회원의 가입 경과 일수를 조회
select name, created_at, datediff(CURDATE(), created_at) as days_since_join
from member;

-- 모든 회원수 조회
select count(*)
from member;

-- 모든 게시글 수 조회
select count(*)
from post;

-- id=3인 회원의 모든 게시글의 조회수를 조회
select member_id, view_count
from post 
where member_id=3;

-- id=3인 회원의 총 게시글 수 조회
select member_id, count(*) as total_count
from post
where member_id=3;

-- id=3인 회원의 모든 게시글의 총 조회수
-- 집계함수는 집계함수끼리만 써야한다.
-- title은 여러개이기 떄문에 count와 안 맞아서 에러가 난다
-- count는 하나로 표현해야한다
select member_id, count(*) as total_counts, sum(view_count) as total_views, 
	avg(view_count) as avg_views, min(view_count) as min_views, max(view_count) as max_views
	-- ,title
from post 
where member_id=3;

-- 전화번호가 null인 회원은 '미등록'으로 표시하여 조회
select name, ifnull(phone, '미등록') as phone
from member;

-- 전화번호가 null이면 이메일을, 이메일도 null이면 '연락처 없음'으로 조회
select name, ifnull(phone, ifnull(email, '연락처 없음')) as contact
from member;

-- coalesce: 순서대로 null값을 체크한다.
select name, coalesce(phone,email, '연락처 없음') as contact
from member;

select name, if(phone is null,if(email is null, '연락처 없음', email),phone) as phone_status
from member;

-- 전화번호 등록 여부에 따라서 상태를 다르게 표시
select name, if(phone is null, '연락처 없음','연락처 있음') as phone_status
from member;





