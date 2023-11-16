import {BrowserRouter as Router, Routes, Route, Navigate} from 'react-router-dom'

import { Login } from '../pages/Login'
import { Register } from '../pages/Register';
import { RedefinePassword } from '../pages/RedefinePassword';
import { VerifyCode } from '../pages/VerifyCode';

export const AppRouter = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<Login />}/>
        <Route path="/register" element={<Register />}/>
        <Route path="/redefine-password" element={<RedefinePassword />}/>
        <Route path="/verify-code" element={<VerifyCode />}/>
      </Routes>
    </Router>
  );
}