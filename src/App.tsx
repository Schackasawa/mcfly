import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import List from './List';
import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);

  // Countries API
  const url = 'https://restcountries.com/v3.1/independent?status=true&fields=cca2,name,languages,capital';
 
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(url);
        const result = await response.json();
        setData(result);
      } catch (error) {
        console.error('Error fetching data:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);
  
  if (loading) {
    return <p>Loading...</p>;
  }

  if (!data) {
    return <p>Error fetching data</p>;
  }

  // Now you can use the 'data' state in your component
  console.log(data);
    
  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React (dschack)</h1>
      <div>
        <h2>Your List:</h2>
        <List data={data} />
      </div>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
