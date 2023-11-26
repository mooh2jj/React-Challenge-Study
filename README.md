# 📢 스터디 규칙
1. 매주 스터디는 2시간을 기본으로 한다. 스터디원 N명이 발표 진행 1시간, 스터디장 기술소개및 실습시간 1시간을 한다, 스터디원 발표 내용은 이 React-challenge-study를 `fork`한 후 본인 Repository에서 각 `본인이름의 디렉토리`에 `PR(Pull Request)`하여 정리해주면 된다.
* fork&PR 영상 참고 -> https://www.youtube.com/watch?v=yr6IzOGoMsQ

2. 발표시 CodReview인 점을 감안하여 `Code 내용을 중심으로 발표`를 권장한다. (자유발표도 가능, 발표는 하고싶은 분을 1순위, 없다면 당일날 랜덤으로 정해집니다)

3. 나머지 스터디원들도 매주 해당 내용 숙지를 위해 스터디한 내용 학습, 학습한 내용을 `해당 본인이름의 디렉토리`에 `PR`하여 정리한다.

4. `미션과제(퀄리티, 완성도는 무관) 4번, 출석 3번 이상`이면 스터디룸 비용(4주) 환급이 가능합니다!

<br>

# 📅 스터디 일정
11/04(OT), 11/11 ~ 12/02(4주)

<details>
<summary>OT(11/04)</summary>
<div markdown="1">

* 아이스브레이킹 시간(자기 소개 등등..)
* 스터디 취지, 방향, 구성 방식 설명
* 미션 과제 소개
```
1) 사용 툴 설치및 이해하기
 * VSC(추천-플러그인 설치) 
 * IntelliJ(얼티메이트 버전 추천-플러그인 설치)
 * MySQL8.0, DB 접속 HediSQL or workbench
 * e2e 테스트용 postman
 * git/github

2) 해당 레포지토리 fork & PR 해보기

3) Setting 환경 -> REST API springBoot + JPA + MySQL
  * SpringBoot REST API CRUD 기능 postman으로 확인

4) REST API Enttiy는 자기가 좋아하는 도메인으로 ex. Blog(entity)
name, content, createdAt, modifiedAt 필드 구현 

5) react 관련 강의 추천목록 감상 (노션정리 참조)
```
* 환경셋팅 - https://www.notion.so/Tool-bb4d80cb1a094696b8ff27f4cd52bb00?pvs=4
* 노션정리 - https://www.notion.so/c04c35eb80be489d8c2d2c6018ed1d3c?pvs=4

</div>
</details>

<details>
<summary>1week(11/11)</summary>
<div markdown="1">

* 리액트 - WS 외 필요한 웹 구동 서버 도식도 설명
* 리액트에 필요한 모던자바스트립트(ES6) 설명
* 브라우저 동작 원리 -> SPA 라이브러이의 VDOM(Virtual DOM)
* 리액트의 JSX 문법 정리
* 리액트 Vite 프로젝트
  - port 고정 설정
  - Strict Mode 삭제
  - SpringBoot GET API 연동 return 내 코드 랜더링 확인 -> map 사용
* CORS 연동 - 서버단에서 설정 

미션
```
1) GET List API 연동 인증

2) 모던 자바스크립트 -> 예시 내용 이해해보기 // 공유한 `기본 자바스크립트 정리` 노션 정리 참조

3) 리액트 나머지 CRUD 내용 본인 프로젝트에 적용해보기
=> 참고 영상 : https://www.youtube.com/watch?v=hHRLN9j1kqI

4) 간단하게 오늘 배운 내용 정리하기
```
* 기본자바스크립트 정리 - https://www.notion.so/bffd371d38894f1e91fa91ea1a4728bc?pvs=4
* 노션정리 - https://www.notion.so/1week-37f14aaa17e6460e87416f8095024789?pvs=4


</div>
</details>

</details>

<details>
<summary>2week(11/18)</summary>
<div markdown="1">

* bootstrap 디자인 설정 -> 간단한 컴포넌트 사용 ex. button, table
* springboot 내 controller단 CORS 설정 설명
* Component 설계 -> App.jsx의 return 문 내부는 component로 정리
  * List component 제작
  * props vs state
* axios 통신 Service 파일로 이관
* React Hooks - useState(), useEffect() 설명
* JSX 내 function event Handling 유의사항
* React Router 로 component path 기입

미션
```
* 3주차 본인 도메인에 맞는 CRUD 최소기능 만들어오기 
참고) https://www.youtube.com/watch?v=hHRLN9j1kqI
```
* 노션정리 - https://www.notion.so/2week-ae81a4f7157444f2a677c447fa8ec9de?pvs=4


</div>
</details>

<details>
<summary>3week(11/25)</summary>
<div markdown="1">

* axios 인스턴스 모듈화 정리 -> Service 파일로 구성
* Component 설계 -> Route 로 정리
  * 패키지 구성  
* React Hooks - useState(), useEffect() 외 router hooks 설명
  * useParams()
  * useNavigate()  
* 그외
  * 유효성 검사 input function
  * Date 타입 포멧 function 
* React Tools 프로그램 소개

미션
```
* 서버 인증인가 security ->  jwt 필터 스터디해오기

```
* 노션정리 - https://www.notion.so/3week-498ed09fc0534fa5b2d17148b1f0e910?pvs=4


</div>
</details>

<br>


# 🎃 주의사항

1. 발표 내용에 대한 리뷰, 질문이 너무 날카로워 해당 발표자에 대한 강한 `감정적인 언행은 주의`해주세요 😫!
2. 질문을 받은 발표자도 Code 또는 발표내용 등을 자신과 동일시하여 지적한 것에 대해 너무 불쾌히 여기지 말으셨으면 좋겠습니다 😂!
3. 리뷰, 피드백의 핵심은 `문제점들을 찾고 발전하는 것`이라는 걸 잊지 말아주세요!
