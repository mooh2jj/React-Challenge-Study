# 1주차 과제

<br>

1. 사용 툴 설치및 이해하기
 * ~~VSC(추천-플러그인 설치)~~
 * ~~IntelliJ(얼티메이트 버전 추천-플러그인 설치)~~
 * ~~MySQL8.0, DB 접속 HediSQL or workbench~~
 * ~~e2e 테스트용 postman~~
 * ~~git/github~~

<br>

2. ~~해당 레포지토리 fork & PR 해보기~~

<br>

3. Setting 환경 -> REST API springBoot + JPA + MySQL
  * ~~SpringBoot REST API CRUD 기능 postman으로 확인~~

<br>

4. REST API Enttiy는 자기가 좋아하는 도메인으로 생성하기
* ~~ex. Blog(entity) name, content, createdAt, modifiedAt 필드 구현~~  -->  https://github.com/minbo2002/react-challenge-study-backend 

<br>

5. react 관련 강의 추천목록 감상 (노션정리 참조)

<br>

# 2주차 과제

1. 자바스크립트 모던문법 nodemon 자바실행기로 예제 실습
```bash
## nodemon 설치, local(dev)에만 사용한다는 뜻!
npm install --save-dev nodemon

## index.js 파일 생성 및 테스트 예제문 생성
console.log("안녕하세요!");

## package.json 파일에서 실행명령어 추가
"scripts": {
    "dev:nodemon": "nodemon src/index.js",
}

## 실행
npm run dev:nodemon
```
![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/87f2642a-7be9-4726-8ef2-92d28163e9b3)

<br>

2. list api + SpringBoot list api + CORS 설정 + React axios 라이브러리 사용하여 console.log로 연동 확인

https://github.com/minbo2002/react-challenge-study-backend <br>
https://github.com/minbo2002/react-challenge-study-front

![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/2b7284c5-11b4-4fa5-ad4a-7188a18765fa)

<br>

3. list api + React App.js 사용하여 JSX 랜더링

https://github.com/minbo2002/react-challenge-study-backend <br>
https://github.com/minbo2002/react-challenge-study-front

```javascript
import { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const baseUrl = "http://localhost:8080";

  const [items, setItems] = useState([]);

  useEffect(() => {
    getTodos();
  }, []); // [] 리액트 열렸을 때 한번만 실행하는 게 하는 것!

  async function getTodos() {
    await axios // 다 받을 때까지 기다리는 것
      .get(baseUrl + "/api/items/list")
      .then((res) => {
        console.log(res.data);
        setItems(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }

  return (
    <>
      <h1>react-challenge-study-backend</h1>
      {items.map((item) => {
        return (
          <div key={item.id}>
            {item.itemName} &nbsp;
            {item.price} &nbsp;
            {item.stockNumber} &nbsp;
            {item.content} &nbsp;
            {item.itemStatus}
          </div>
        );
      })}
    </>
  );
}

export default App;
```

![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/51e3fb0b-674b-472b-b905-53bf2671903a)


