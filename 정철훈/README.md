 1주차 정리<br>

 2주차 정리<br>
 <code>
 --------------------------component : App.jsx -----------------------------<br>
 import { useState } from 'react'<br>
import reactLogo from './../assets/react.svg'<br>
import viteLogo from '/vite.svg'<br>
import React, { useEffect } from 'react';<br>
import { getProducts } from '../utils/getProducts';<br>
import './App.css'<br>
<br>
function App() {<br>
  const [count, setCount] = useState(0)<br>
  const [products, setProducts] = useState([]);<br>
  const baseUrl = "http://localhost:8080";<br>
  useEffect(()=>{<br>
      const products = async() =>{<br>
            const data = await getProducts(baseUrl);<br>
            setProducts(data);<br>
            console.log(data);      <br>
      };<br>
      products();<br>
    },[]);<br>
  return (<br>
    <><br>
      <div className="product-list"><br>
        {products.map(product => (<br>
          <div key={product.id} className="product"><br>
          <code>
            <h2>{product.productName}</h2><br>
            <p>Price: {product.salePrice}</p><br>
            </code>
          </div><br>
        ))}<br>
      </div><br>
    </><br>
  )<br>
}<br>
<br>
export default App<br>
<br>
---------------------------utils : getProducts.js-------------------------------<br>
import axios from 'axios';<br>
<br>
export async function getProducts(baseUrl) {<br>
    try {<br>
      const response = await axios.get(`${baseUrl}/api/public/products`);<br>
      return response.data;<br>
    } catch (error) {<br>
      console.error('Error getProducts data:' + error);<br>
    }<br>
  }<br>
</code>
