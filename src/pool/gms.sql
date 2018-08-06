SELECT * FROM MEMBER
;


select count(*) 
from member
;

--페이지 수를 구하는 쿼리
--ROWNUM 구한 뒤 
--페이지당 회원의 ID 만 보여주는 쿼리
--서브쿼리 이용



SELECT T.SEQ,
T.MEM_ID,
T.NAME,
T.AGE,
T.GENDER,
T.ROLL,
T.TEAM_ID
FROM (SELECT ROWNUM SEQ,
M.*
FROM MEMBER M
ORDER BY SEQ DESC) T
WHERE T.SEQ BETWEEN 1 AND 5
;