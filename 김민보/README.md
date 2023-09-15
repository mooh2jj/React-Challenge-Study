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

### 1. 자바스크립트 모던문법 nodemon 자바실행기로 예제 실습
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

### 2. list api + SpringBoot list api + CORS 설정 + React axios 라이브러리 사용하여 console.log로 연동 확인

https://github.com/minbo2002/react-challenge-study-backend <br>
https://github.com/minbo2002/react-challenge-study-front

![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/2b7284c5-11b4-4fa5-ad4a-7188a18765fa)

<br>

### 3. list api + React App.js 사용하여 JSX 랜더링

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

### 1. 자바스크립트 모던 문법 nodemon 실행기로 예제 연습 (map, filter, fetch, asyn&await)
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

<br>

### 2. 스프링부트 프로젝트 CRUD 기능을 React에 첨가 (등록, 조회, 수정, 삭제)
```javascript
import React, { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const baseUrl = "http://localhost:8080";

  /* 
    useState() 안에 무엇을 넣느냐에 따라서
    input값이 기본으로  1.[]객체로 생성이 됨    2. "" 빈값으로 생성이 됨  3. null 널값으로 생성이 됨
  */
  const [items, setItems] = useState([]);
  const [input, setInput1] = useState("");
  const [input2, setInput2] = useState("");
  const [input3, setInput3] = useState("");
  const [input4, setInput4] = useState("");

  /*
    useEffect[] : 리액트 열렸을 때 한번만 실행될수 있게하는 hook.
    hook이란?? --> 함수형 컴포넌트에서 여러 state나 생명주기에서 사용하는 기술들을 use로 시작하는 hook으로 대신 사용할 수 있게 한다.
  */
  useEffect(() => {
    getItem();
  }, []);

  // 비동기 호출을 할 수 있게 도와주는 함수
  async function getItem() {
    await axios // async await을 통해서 axios를 호출해서 응답 받을때까지 기다린다.
      .get(baseUrl + "/api/items/list")
      .then((response) => {            // then 성공했을때
        console.log(response.data);
        setItems(response.data);
      })
      .catch((error) => {     // catch 실패했을때
        console.log(error);
      });
  }

  function updateItem(id) {
    const updateItem = async () => {
      await axios
        .patch(baseUrl + "/api/items/" + id, {})
        .then((response) => {     // then 성공했을때
          console.log(response.data);
          
          setItems(
            items.map((item) => {
              if (item.id === id) {
                console.log("item.id = " + item.id);
                console.log("item.itemStatus = " + item.itemStatus);
                item.itemStatus == "ON_SALE" ? "SOLD_OUT" : "ON_SALE";
              }
            })  
          )  
        })
        .catch((error) => {   // catch 실패했을때
          console.log("error : " + error);
        })
    }
    updateItem();
    console.log("상품이 변경됨");
  }

  function deleteItem(id) {
    const deleteItem = async () => {
      await axios
        .delete(baseUrl + "/api/items/" + id, {})
        .then((response) => {     // then 성공했을때
          console.log(response.data);
          setItems(
            items.filter((item) => item.id !== id)
          )
        })
        .catch((error) => {   // catch 실패했을때
          console.log("error : " + error);
        })
    }
    deleteItem();
    console.log("상품이 삭제됨");
  }

  function createItem(e) {
    e.preventDefault();  // 화면 새로고침 방지

    const createItem = async () => {
      await axios
        .post(baseUrl + "/api/items", {
          itemName: input,
          price: input2,
          stockNumber: input3,
          content: input4
        })
        .then((response) => {
          console.log(response.data)
          setInput1("");
          setInput2("");
          setInput3("");
          setInput4("");
          getItem();
        })
        .catch((error) => {
          console.log(error);
        })
    }
    createItem();
    console.log("상품이 추가됨");
  }

  // 데이터를 입력할 공간
  function changeText1(e) {
    e.preventDefault();       // 화면 새로고침 깜빡이 방지
    setInput1(e.target.value);
    console.log("input에 어떤값이 들어가지? " + input);
  }
  // 데이터를 입력할 공간
  function changeText2(e) {
    e.preventDefault();       // 화면 새로고침 깜빡이 방지
    setInput2(e.target.value);
    console.log("input2에 어떤값이 들어가지? " + input2);
  }
  // 데이터를 입력할 공간
  function changeText3(e) {
    e.preventDefault();       // 화면 새로고침 깜빡이 방지
    setInput3(e.target.value);
    console.log("input3에 어떤값이 들어가지? " + input3);
  }
  // 데이터를 입력할 공간
  function changeText4(e) {
    e.preventDefault();       // 화면 새로고침 깜빡이 방지
    setInput4(e.target.value);
    console.log("input4에 어떤값이 들어가지? " + input4);
  }

  return (
    <>
      <h1>react-challenge-study-backend</h1>
      <form onSubmit={createItem}>
          <p><label>상품 이름 : <input type="text" required={true} value={input} onChange={changeText1} /></label></p>
          <p><label>상품 가격 : <input type="text" required={true} value={input2} onChange={changeText2} /></label></p>
          <p><label>상품 재고개수 : <input type="text" required={true} value={input3} onChange={changeText3} /></label></p>
          <p><label>상품 설명 : <input type="text" required={true} value={input4} onChange={changeText4} /></label></p>
          
          <input type="submit" value="Create"/>
      </form>

      {
        items
          ? items.map((item) => {   // item 데이터가 있을경우
            return (
              <div key={item.id}>
                <label>  
                  {item.itemName} &nbsp;
                </label>
                <label>
                  {item.price}&nbsp;
                </label>
                <label>
                  {item.stockNumber} &nbsp;
                </label>
                <label>
                  {item.content} &nbsp;
                </label>
                <label onClick={() => updateItem(item.id)}>
                  {item.itemStatus}
                </label>
                <label onClick={() => deleteItem(item.id)}>&nbsp;❌</label>
              </div>
            );
          })
          : null  // item 데이터가 없을경우 null 반환  
      }
    </>
  );
}

export default App;
```
![image](https://github.com/minbo2002/React-Challenge-Study/assets/68101836/7c841854-40b1-400a-8900-c250f4bd357a)

<br>

# 3주차

### 1. 인증처리를 위한 spring security(+jwt필터) 프로젝트에 적용

--> https://github.com/minbo2002/react-challenge-study-backend
