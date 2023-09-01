 1주차 정리<br>

 2주차 정리<br>
 --------------------------component : App.jsx -----------------------------<br>
React: React는 사용자 인터페이스(UI)를 구축하기 위한 JavaScript 라이브러리입니다. 웹 애플리케이션의 프론트엔드 부분을 개발하는 데 사용됩니다. React는 컴포넌트 기반 아키텍처를 가지고 있어, UI를 독립적인 작은 조각으로 나누어 개발하고 관리할 수 있습니다. 이러한 컴포넌트들은 재사용 가능하며, 상태(state)와 속성(props)을 이용하여 데이터를 효율적으로 관리합니다.

Spring Boot: Spring Boot는 Java 기반의 웹 애플리케이션을 빠르게 개발하기 위한 프레임워크입니다. Spring Boot는 스프링 프레임워크의 기능을 간단하고 효율적으로 사용할 수 있도록 지원하며, 내장형 웹 서버를 포함하고 있어 별도의 외부 웹 서버 설정 없이도 실행할 수 있습니다. 주로 백엔드 비즈니스 로직과 데이터 처리를 다루는 데 사용됩니다.

데이터베이스(DB) 서버: 데이터베이스 서버는 데이터를 저장, 검색 및 관리하는 역할을 수행합니다. 애플리케이션의 데이터를 구조적으로 저장하고 필요한 정보를 검색할 수 있게 해줍니다. 주로 SQL (Structured Query Language) 또는 NoSQL 데이터베이스를 사용하여 데이터를 관리합니다.

<p>개략적인 작동 방식</p>;

사용자 인터페이스(UI): React를 사용하여 웹 애플리케이션의 사용자 인터페이스를 개발합니다. 이 UI는 컴포넌트들로 구성되며, 사용자와의 상호작용을 처리하고 UI 상태를 관리합니다.

프론트엔드와 백엔드 연결: React는 웹 브라우저에서 실행되므로, Spring Boot를 사용하여 백엔드 로직을 처리하는 API 엔드포인트를 개발합니다. 이 엔드포인트는 클라이언트의 요청을 받아 처리하고, 필요한 데이터를 데이터베이스에서 가져오거나 업데이트합니다.

데이터 처리: Spring Boot는 요청된 데이터를 처리하고 데이터베이스와 상호작용하여 데이터를 검색하거나 업데이트합니다. 데이터베이스는 실제 데이터의 저장소로 사용되며, 필요한 정보를 효율적으로 관리합니다.

데이터 흐름: 클라이언트(브라우저)에서 React를 통해 UI를 표시하고 사용자 동작을 받아 Spring Boot API 엔드포인트로 전송합니다. Spring Boot는 이 요청을 받아 데이터 처리 및 로직 실행을 수행하며, 데이터베이스에 접근하여 데이터를 조작합니다. 이후 결과는 다시 클라이언트로 전송되어 UI에 반영됩니다.


index.html: 이 파일은 웹 페이지의 기본 뼈대를 구성하는 역할을 합니다. 주로 HTML 문서의 구조와 외부 리소스(스타일시트, 자바스크립트 파일 등)를 로드하는 역할을 합니다.

index.js: React 애플리케이션의 시작점입니다. 이 파일은 React DOM을 사용하여 렌더링할 컴포넌트를 정의하고 실제 HTML 문서 내에 해당 컴포넌트를 렌더링합니다.

App.js: 이 파일은 React 애플리케이션의 주요 컴포넌트인 App 컴포넌트를 정의합니다. App 컴포넌트는 웹 페이지 내의 주요 내용과 UI를 구성하는 역할을 합니다.

JSX 문법: JSX(JavaScript XML)는 React에서 UI를 작성하기 위한 확장된 문법입니다. JSX는 JavaScript 코드 안에 HTML과 유사한 구문을 포함할 수 있도록 도와줍니다. App.js 파일 내에서 JSX를 사용하여 컴포넌트의 렌더링 구조와 내용을 작성할 수 있습니다.

 
 ```
// 하위 컴포넌트로 나누어 처리하여 크게 page단위로 활용되는 컴포넌트의 Notification.jsx 코드만 올림

import { useState, useEffect } from 'react';
import Category from './Category/Map/Map'; 
import BoardMap from './Board/Map/Map';
import Paging from './Paging/Paging';
import { getNotifications, getCategories } from './Api/Api';

function Notification() {
    const [notifications, setNotifications] = useState([]);
    const [categories, setCategories] = useState([]);
    const [categoryCode,setCategoryCode] = useState();
    const [totalPages, setTotalPages] = useState();
    const [currentPage, setCurrentPage] = useState(1);
    
    useEffect(()=>{
      const fetchCategories = async() =>{
        const response = await getCategories();
        setCategories(response.data);
      }
      fetchCategories();
    },[]);
    useEffect(()=>{
        const fetchNotifications = async() =>{
            const response = await getNotifications(currentPage,categoryCode);
            setNotifications(response.data.content);
            setTotalPages(response.data.totalPages);
        };
        fetchNotifications();
    },[currentPage,categoryCode]);

    const handleCategoryChange = async (categoryCode) => {
        setCategoryCode(categoryCode);
        setCurrentPage(1);
    };
    
return (
    <>
      <div className="header">
        <h1>공지사항</h1>
        <div className="category-buttons">
          <div className="category-buttons-container">
            <Category 
              categories={categories}
              selectedCategoryCode = {categoryCode}
              onCategoryChange={handleCategoryChange}
            />
          </div>
        </div>
      </div>
      <div className="board">
        <table>
          <thead>
            <tr>
              <th className="header-cell">No</th>
              <th className="header-cell">공지분류</th>
              <th className="header-cell">공지일자</th>
              <th className="header-cell">공지내용</th>
            </tr>
          </thead>
          <BoardMap 
            notifications={notifications} 
            currentPage={currentPage}
          />
        </table>
      </div>
      <Paging 
          totalPages = {totalPages} 
          currentPage = {currentPage} 
          setCurrentPage={setCurrentPage}
      />
    </>
  )
}

export default Notification;
```
