import React, { useState } from 'react';
import { Link } from 'react-router-dom';

import { LayoutComponents } from '../../components/LayoutsComponents';
import { InputPassword, InputVerifyPassword } from '../../components/Inputs/Password';
import { InputUsername } from '../../components/Inputs/Username';
import { InputName } from '../../components/Inputs/Name';
import { InputEmail } from '../../components/Inputs/Email';

export const Register = () => {
  const [formData, setFormData] = useState({
    username: '',
    name: '',
    email: '',
    password: '',
  });

  const handleChange = (field) => (value) => {
    setFormData({ ...formData, [field]: value });
  };

  const handleSignUp = (event) => {
    event.preventDefault();
  
    console.log('data:', formData);
  };

  const handleSignUpDefault = (event) => {
    event.preventDefault();
  };

  return (
    <LayoutComponents title="Register">
      <InputUsername onChange={handleChange('username')} />
      <InputName onChange={handleChange('name')} />
      <InputEmail onChange={handleChange('email')} />
      <InputPassword onChange={handleChange('password')} />
      <InputVerifyPassword />

      <div className="container-login-form-btn">
        <button 
          className="login-form-btn" 
          onClick={
            formData.username && 
            formData.name &&
            formData.email &&
            formData.password !== '' ? handleSignUp : handleSignUpDefault}>
            Sign up
        </button>
      </div>

      <div className="text-center">
        <span className="txt1">Already have an account?</span>
        <Link className="txt2" to="/login">
          Sign in.
        </Link>
      </div>
    </LayoutComponents>
  );
};