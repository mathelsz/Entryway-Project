import { Link } from 'react-router-dom';

import logo from '../../assests/logo.webp'
import { LayoutComponents } from '../../components/LayoutsComponents';
import { InputUsername } from '../../components/Inputs/Username';
import { InputPassword } from '../../components/Inputs/Password';

export const Login = () => {
  return (
    <LayoutComponents>
      <form className="login-form">

        <span className="login-form-title">Bem Vindo</span>

        <span className="login-form-title">
          <img src={logo} alt='Logo de login' />
        </span>

        <InputUsername/>
        <InputPassword/>

        <div className="container-login-form-btn">
          <button className="login-form-btn">Login</button>
        </div>

        <div className="text-center">
          <span className="txt1">Não possui conta?</span>

          <Link className="txt2" to="/register">Criar conta.</Link>
        </div>

      </form>
    </LayoutComponents>
  );
}