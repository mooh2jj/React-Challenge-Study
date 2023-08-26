 1주차 정리<br>

 2주차 정리<br>
 --------------------------component : App.jsx -----------------------------<br>
 ```
 import { useState } from 'react'
import reactLogo from './../assets/react.svg'
import viteLogo from '/vite.svg'
import React, { useEffect } from 'react';
import { getProducts } from '../utils/getProducts';
import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [products, setProducts] = useState([]);
  const baseUrl = "http://localhost:8080";
  useEffect(()=>{
      const products = async() =>{
            const data = await getProducts(baseUrl);
            setProducts(data);
            console.log(data);
      };
      products(); 
    },[]); 
  return ( 
    <> 
      <div className="product-list"> 
        {products.map(product => ( 
          <div key={product.id} className="product"> 
            <h2>{product.productName}</h2> 
            <p>Price: {product.salePrice}</p> 
          </div> 
        ))} 
      </div> 
    </> 
  ) 
} 
 
export default App 
 
---------------------------utils : getProducts.js------------------------------- 
import axios from 'axios'; 
 
export async function getProducts(baseUrl) { 
    try { 
      const response = await axios.get(`${baseUrl}/api/public/products`); 
      return response.data; 
    } catch (error) { 
      console.error('Error getProducts data:' + error); 
    } 
  }
```
