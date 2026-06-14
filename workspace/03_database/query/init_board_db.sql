-- 삭제하는 것도 순서가 있다.
DROP TABLE if EXISTS  reply;
DROP TABLE if EXISTS post;
DROP TABLE if EXISTS member;

-- 필요 없는 board_db 데이터베이스 삭제 (삭제 시 내부의 모든 테이블과 데이터가 영구히 소멸되므로 주의 필요)
-- DROP DATABASE if EXISTS board_db;

-- board_db라는 이름의 데이터베이스 생성
-- CREATE DATABASE board_db;

-- 생성한 데이터베이스로 전환하여 이후 쿼리가 해당 데이터베이스를 대상으로 실행되도록 설정
-- USE board_db;

-- member (회원 테이블) 생성
CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone CHAR(12),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- post (게시글 테이블) 생성
CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE SET NULL
);

-- reply (댓글 테이블) 생성
CREATE TABLE reply (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    member_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

INSERT INTO member
  VALUES (NULL, 'haru@gmail.com', 'pwd123', '하루', '01011112222', DEFAULT);
INSERT INTO member
  VALUES (NULL, 'haru2@gmail.com', 'pwd123', '하루2', NULL, '2026-05-10 12:13:45');
INSERT INTO member (email, password, name)
    VALUES ('namu@gmail.com', 'pwd789', '나무');
INSERT INTO member (email, password, name, phone) VALUES
    ('harong@gmail.com', 'pwd012', '하롱이', '01022223333'),
    ('yong@gmail.com', 'pwd456', '용쌤', '0103334444');

insert into member(email, password, name) values
('coffeeking@gmail.com', 'coffee','커피킹'),
('lattegirl@gmail.com','latte123','라떼걸'),
('codingcat@gmail.com','cat5','코딩냥'),
('pineapplepizza@gmail.com','pizza123','파인애플수호자'),
('midnightcoder@gmail.com','code123','야근코딩');

insert into member(email, password, name) values
('tteokbokki@food.com', 'spicy123','떡볶이광인'),
('chickenlover@food.com','chiken123','치킨수호자'),
('keyboardwarrior@net.com','key123','댓글장인'),
('sleepyhead@daily.com','sleep123','만성피로인'),
('weekendhero@life.com','week123','주말전사'),
('bughunter@dev.com', 'bug123','버그사냥꾼'),
('teaholic@cafe.com','tea123','차애호가'),
('moviebuff@media.com','movie123','영화덕후'),
('lateworker@office.com','work123','야근전문가'),
('mountaingoat@outdoor.com','hike123','등산매니아');


INSERT INTO post (member_id, title, content, created_at) VALUES (1, '첫 번째 게시글', '안녕하세요. 반갑습니다.', '2026-05-23 12:33:54');
INSERT INTO post (member_id, title, content, created_at)
VALUES (2, '질문 있습니다', '데이터베이스 기초에 대한 질문입니다.', '2026-05-24 10:33:54');
INSERT INTO post (member_id, title, content, created_at)
VALUES (1, '두 번째 게시글', '오늘 날씨가 아주 좋습니다.','2026-05-24 11:43:54');
INSERT INTO post (member_id, title, content, created_at)
VALUES (2, 'MySQL 설치 오류 해결방법', '설치 중 Configurator 단계에서 오류가 날 때 대처법 공유합니다.', '2026-05-25 08:02:54');
INSERT INTO post (member_id, title, content, created_at)
VALUES (3, '자기 소개', '안녕하세요 하롱이입니다.', '2026-05-26 20:25:54');

INSERT INTO reply (post_id, member_id, content)
VALUES (1, 2, '환영합니다!');
INSERT INTO reply (post_id, member_id, content)
VALUES (1, 3, '반가워요~');
INSERT INTO reply (post_id, member_id, content)
VALUES (2, 1, '어떤 부분이 궁금하신가요?');
INSERT INTO reply (post_id, member_id, content)
VALUES (4, 3, '정말 유용한 정보네요. 감사합니다!');
INSERT INTO reply (post_id, member_id, content)
VALUES (4, 1, '저도 이 방법으로 해결했습니다.');










