-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(*) from ANIMAL_OUTS

group by hour having hour between 9 and 19 order by hour;