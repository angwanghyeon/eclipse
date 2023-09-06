insert INTO board
VALUES(board_seq.nextval, '1234', '라이센스', 'pinksung@nate.com',  '첫방문','반갑습니다.');
INSERT INTO board
VALUES(board_seq.nextval, '전수빈', 'raccon@nate.com', '3333', '고등애','일식입니다.');
INSERT INTO board
VALUES(board_seq.nextval, '전원지', 'one@nate.com', '1111', '갯골마을','돼지삼겹살이 맛있습니다.');
commit;
select * from BOARD;
