-- 코드를 입력하세요
select name from ANIMAL_INS where datetime =
(select min(datetime) from ANIMAL_INS);