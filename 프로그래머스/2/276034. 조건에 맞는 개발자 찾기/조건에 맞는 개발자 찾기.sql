SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS D JOIN SKILLCODES S ON SKILL_CODE & CODE = CODE
WHERE NAME = 'Python' OR NAME = 'C#'
ORDER BY ID