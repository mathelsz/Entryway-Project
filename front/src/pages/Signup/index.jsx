import { Link, useNavigate } from 'react-router-dom';
import { LayoutComponents } from '../../components/LayoutsComponents';
import { useState } from 'react';
import { InputText } from "../../components/Inputs";
import { ButtomDefault } from "../../components/Buttons/ButtomDefault";

export const Signup = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    username: '',
    name: '',
    email: '',
    password: '',
  });

  const handleInputChange = (field, value) => {
    setFormData({
      ...formData,
      [field]: value,
    });
  };

  const handleSignUp = (event) => {
    event.preventDefault();

    //TODO: implementar o backend

    console.log('data:', formData);

    navigate('/login');
  };

  const handleSignUpIsEmpty = (event) => {
    event.preventDefault();
  };

  return (
    <LayoutComponents title="Vamos lá!">

      <InputText
        className={formData.username !== "" ? "has-val input" : "input"}
        type="text"
        placeholder="Usuário"
        value={formData.username}
        onChange={e => handleInputChange("username", e.target.value)}
      />

      <InputText
        className={formData.name !== "" ? "has-val input" : "input"}
        type="text"
        placeholder="Nome"
        value={formData.name}
        onChange={e => handleInputChange("name", e.target.value)}
      />

      <InputText
        className={formData.email !== "" ? "has-val input" : "input"}
        type="email"
        placeholder="Email"
        value={formData.email}
        onChange={e => handleInputChange("email", e.target.value)}
      />

      <InputText
        className={formData.password !== ""  ? "has-val input" : "input"}
        type="password"
        placeholder="Senha"
        value={formData.password}
        onChange={e => handleInputChange("password", e.target.value)}
      />

      <ButtomDefault
        className="login-form-btn"
        text="Cadastrar"
        onClick={
          formData.username &&
          formData.name &&
          formData.email &&
          formData.password !== '' ? handleSignUp : handleSignUpIsEmpty}>
          Sign up
      </ButtomDefault>

      <div className="text-center">
        <span className="txt1">Já possui conta?</span>

        <Link className="txt2" to="/login">
          Entrar
        </Link>
      </div>

    </LayoutComponents>
  );
};