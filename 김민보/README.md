# OT

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

# 1주차

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

<br>

# 2주차

1. 자바스크립트 모던 문법 nodemon 실행기로 예제 연습 (map, filter, fetch, asyn&await)
```javascript
// 제곱
const arr = [1, 2, 3, 4];
const result = arr.map((n) => n * n);
console.log(result);

// 짝수 배열
const arr2 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
arr2
  .filter((i) => i % 2 == 0)
  .forEach((a) => {
    console.log(a);
  });

// 홀수 배열
const arr3 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
arr3
  .filter((i) => i % 2 == 1)
  .forEach((a) => {
    console.log(a);
  });
```
![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/96685aa3-d477-4185-aef9-b9915c984967)

<br>

```javascript
// 동기적으로 작동하는 자바스크립트
function foo() {
  console.log("자바스크립트는 동기적입니다.");
  console.log("테스트중");
}

console.log("시작");
foo();
console.log("끝");
```
![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/47d451f6-b02a-468d-8d47-09a18cdf7d6b)

<br>

```javascript
// 비동기 변천과정 :  콜백 -> Promise(then, catch) -> await, async(비동기) -> fetch(Promise 반) -> axios

// 비동기적으로 실행하는 콜백함수 setTimeOut() 함수  -->  콜백지옥
console.log("시작");

setTimeout(function () {
  console.log("비동기 콜백함수 setTimeOut()");
}, 2000);

console.log("끝");
```
![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/4893d3c1-1c32-4b3f-8e91-47937c451c9a)

<br>

```javascript
// Promise  -->  비동기 작업을 생성/시작하는 new Promise() 와 동작부분(then, catch)를 분리
const promise = new Promise((resolve, reject) => {
  const rand = Math.floor(Math.random() * 2);
  console.log(rand);
  if (rand === 0) {
    resolve();
  } else {
    reject();
  }
});

promise.then(() => console.log("success")).catch(() => console.log("fail!"));
```
![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/11882954-edbd-43dd-835f-1c5ef32b6053)

<br>

```javascript
// async & await  -->  Promise가 처리될 때까지 함수 실행을 기다리게 만든다. Promise 처리 이후 결과와 함께 함수 실행이 재개

// Promise가 처리될 때까지 기다리는 동안 다른 스크립트나 이벤트 처리를 할 수 있기 때문에 CPU 리소스가 낭비되지 않는다.
function greet() {
  return new Promise(function (resolve) {
    setTimeout(function () {
      resolve("hello");
    }, 1000);
  });
}

// function 앞에 async를 선언하면 항상 Promise 객체를 반환.
async function load() {
  var result = await greet(); //resolved 될 때까지 대기
  console.log(result);
}
load();
```
![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/2263abd5-e5d3-47ba-8540-d888f0a2c0bd)
2초뒤에 hello 출력
