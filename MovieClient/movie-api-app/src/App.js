import './App.css';
import api from "./api/axiosConfig";
import { useState, useEffect } from 'react';
import Layout from './components/Layout';
import { Route, Routes } from 'react-router-dom';
import Home from './components/home/Home';
function App() {
  const [movies, setMovies] = useState();
  const [loading, setLoading] = useState(true)
  const getMovies = async () =>{
    try{
      const response = await api.get("/api/v1/movies");
      console.log(response.data);
      
      setMovies(response.data);

    }catch(err){
      console.log(err);
    }finally{
      setLoading(false);
    }
  }

  useEffect(() =>{
    getMovies();

  }, []);

  if(loading){
    return (
      <div className='App'>
        LOADING
      </div>
    )
  }
    
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route path='/' element={<Home movies={movies} />}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
