import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Base from './components/Base';

import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Login from './pages/Login';
import Home from './pages/Home';
import Signup from './pages/Signup';
function App() {
  return (
    // <Base>
    //   <h1>This is app component</h1>
    // </Base>
    <BrowserRouter>
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
