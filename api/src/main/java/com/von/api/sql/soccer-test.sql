-- 001. 전체 축구팀 목록을 팀 이름 오름차순으로 출력하시오.
select team_name from team
order by team_name asc; -- ASC(오름차순) 생략 가능

-- 002. 플레이어의 포지션 종류를 나열하시오. 단, 중복은 제거하고 포지션이 없으면 빈공간으로 두시오.
select distinct position
from player;

-- 003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
select distinct
case
when position = '' then '신입' else position
end
from player;

select distinct ifnull(nullif(position,''),'신입') from player;

-- 004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다
select player_name
from player
where team_id = 'K02' and position = 'GK';

-- 004-1. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 모름.
select player_name
from player p
    left join team t
    on p.team_id = t.team_id
where t.region_name = '수원' and p.position = 'GK';

select player_name
from player
where position = 'GK' and team_id = (select team_id
                                        from team
                                        where region_name='수원');

-- 005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다
select player_name
from player
where team_id = 'K02' and player_name like '고%' and height >=170;

-- 005-1. 수원팀에서 성이 고씨, 키가 170이상 선수를 출력. 단 수원팀의 ID는 모름.
select player_name
from player p
    left join team t
    on p.team_id = t.team_id
where t.region_name = '수원' and p.player_name like '고%' and p.height>=170;

select player_name
from player
where player_name like '고%' and height >=170 and team_id = (select team_id
                                                             from team
                                                             where region_name = '수원');

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오 -> player.player_name
-- 소속팀이 삼성블루윙즈이거나 -> team.team_name k02
-- 드래곤즈에 소속된 선수들이어야 하고, -> team.team_name k07
-- 포지션이 미드필더(MF:Midfielder)이어야 한다. player.position
-- 키는 170 센티미터 이상이고 180 이하여야 한다. player.height
select player_name
from player p
where position = 'MF'
and (height between 170 and 180)
and team_id in (select team_id
                from team
                where team_name = '삼성블루윙즈' or team_name = '드래곤즈');
-- ---------------- 다시 ----------------

-- 문제 7
-- 수원을 연고지로 하는 골키퍼는 누구인가?
select player_name
from player
where position = 'GK' and team_id = (select team_id
                 from team
                 where region_name = '수원');

-- 문제 8
-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오
-- 키와 몸무게가 없으면 "0" 으로 표시하시오
-- 키와 몸무게는 내림차순으로 정렬하시오
select player_name,
ifnull(nullif(height,''),'0') as height,
ifnull(nullif(weight,''),'0') as weight
from player
where team_id = (select team_id
                 from team
                 where region_name = '서울')
order by weight desc, height desc;


-- 문제 9
-- 서울팀 선수들 이름과 포지션과
-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오
-- BMI는 "NONE" 으로 표시하시오(as bmi)
-- 최종 결과는 이름 내림차순으로 정렬하시오
select player_name, position,
concat(ifnull(nullif(height,''),'0'),'cm') as height,
concat(ifnull(nullif(weight,''),'0'),'kg') as weight,
(case when (height/((weight/100)*(weight/100)))>=25 then '비만'
     when (height/((weight/100)*(weight/100)))>=23 then '과체중'
     when (height/((weight/100)*(weight/100)))>=18.5 then '정상'
     else '저체중'
end) as bmi
from player
where team_id = (select team_id
                 from team
                 where region_name='서울')
order by player_name desc;

-- -------------- 0313 --------------
-- 4개 테이블 full scan
select count(*)
from stadium s
      join team t on s.stadium_id = t.stadium_id
	  join player p on t.team_id = p.team_id
	  join schedule sch on s.stadium_id = sch.stadium_id;

-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
-- 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오
select t.team_name, p.player_name
from team t
    join player p on t.team_id = p.team_id
where (t.team_id = 'K02' or t.team_id = 'K10') and p.POSITION = 'GK'
order by team_name, player_name;

select t.team_name, p.player_name
from team t
    join player p on t.team_id = p.team_id
where t.team_id in ('K02','K10') and p.POSITION = 'GK'
order by team_name, player_name;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
select concat(t.region_name,' ',t.team_name) "[팀명]", s.stadium_name "[홈구장]"
from stadium s
    join team t on s.stadium_id = t.stadium_id;

-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
select p.height as "키", t.team_name as "팀명", p.player_name as "선수명"
from team t
    join player p on t.team_id = p.team_id
where p.height between 180 and 183
order by p.height, t.team_name, p.player_name;

-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순
select team_name, player_name
from team t
    join player p on t.team_id = p.team_id
where p.position = ''
order by t.team_name, p.player_name;

-- join에서 동어반복 using으로 처리
select team_name, player_name
from team t
    join player p using (team_id)
where p.position = ''
order by t.team_name, p.player_name;

-- 무조건 스칼라와 조인 사용하여 풀이
-- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.
select
sch.sche_date as "날짜",
(select t.team_name from team t where s.hometeam_id = t.team_id) as "홈팀",
s.stadium_name as "스타디움",
(select t.team_name from team t where sch.awayteam_id = t.team_id) as "어웨이팀"
from stadium s
    join schedule sch on sch.stadium_id = s.stadium_id
where sch.sche_date = '20120317';

-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
select
(select p.player_name from player p where p.team_id = t.team_id and s.stadium_id = sch.stadium_id)player_name,
position,
concat(team_name,' ',region_name),
stadium_name,
sche_date
from stadium s
    join schedule sch on sch.stadium_id = s.stadium_id
    join team t on s.stadium_id = t.stadium_id

where sch.sche_date = '20120317';

-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
select s.stadium_name, sch.sche_date,
    (select t.team_name
     from team t
     where t.team_id = sch.hometeam_id) as "홈",
    (select t.team_name
     from team t
     where t.team_id = sch.awayteam_id) as "어웨이"
from stadium s
    join schedule sch on s.stadium_id = sch.stadium_id
where sch.home_score-sch.away_score>=3;

-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
-- 경기장 이름, 홈팀
select stadium_name,
    (select t.team_name from team t where t.stadium_id = st.stadium_id) as "홈팀"
from stadium st;
-- 학습용 코드
select s.stadium_name, t.team_name
from stadium s left join team t using(stadium_id);

-- 문제 18 페이지네이션 로직을 위한
-- 플레이어 테이블에서 최상단 5개 로우를 출력
select * from player limit 5;

-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
select p.team_id "팀아이디", team_name "팀이름",
round(AVG(height),2) "평균"
from team t
    join player p on t.team_id = p.team_id
where if(p.height = '',0,p.heigt)
group by p.team_id
having avg(p.height) < (select avg(p.height)
                        from team join player p using (team_id)
                        where region_name = '인천');

select

-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
select
    (select t.team_name
     from team t
     where t.team_id = p.team_id) as "소속팀명",
player_name as "선수명",
back_no as "백넘버"
from player p
where p.position = 'MF';

select count(position)
from player
group by position
having position = 'MF';

-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외
select
(select t.team_name
 from team t
 where t.team_id = p.team_id) as "소속팀명",
p.player_name '선수명',
p.back_no '백넘버'
from player p
order by height desc
limit 5;

-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)
select t.team_name, p.height, p.player_name
from player p
    join team t on (p.team_id = t.team_id)
where
group by team_id

select p.*
from player p
join (select p2.team_id, round(avg(p2.height),2) avg
      from player p2
      where p2.height != ''
      group by p2.team_id) t_avg using (team_id)
where p.height != ''and p.height < avg;

-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회



show tables;
desc menus;
select * from menus;
select * from menus where category = 'navigate';