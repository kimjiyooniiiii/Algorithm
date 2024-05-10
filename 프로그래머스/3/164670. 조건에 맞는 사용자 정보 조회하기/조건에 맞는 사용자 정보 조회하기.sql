-- 코드를 입력하세요
WITH COUNTING AS
(SELECT WRITER_ID, COUNT(*) COUNTS
FROM USED_GOODS_BOARD
GROUP BY WRITER_ID)


SELECT U.USER_ID, U.NICKNAME, 
    CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS '전체주소',
    CONCAT(SUBSTRING(TLNO,1,3),'-',SUBSTRING(TLNO,4,4),'-',SUBSTRING(TLNO,8,4)) AS '전화번호'
FROM USED_GOODS_USER U JOIN COUNTING C ON U.USER_ID = C.WRITER_ID
WHERE C.COUNTS >= 3
ORDER BY U.USER_ID DESC


