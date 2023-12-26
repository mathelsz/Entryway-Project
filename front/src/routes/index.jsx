import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'

import { Login } from '../pages/Login'
import { Forgot } from "../pages/Login/Forgot";
import { Recover } from "../pages/Login/Forgot/Recover";
import { Home } from "../pages/Home";
import { Signup } from '../pages/Signup';

export const AppRouter = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />

        <Route path="/login" element={<Login />}/>
        <Route path="/login/forgot" element={<Forgot />}/>
        <Route path="/login/forgot/recover" element={<Recover />}/>

        <Route path="/home" element={<Home/>}/>

        <Route path="/signup" element={<Signup />}/>
      </Routes>
    </Router>
  );
}