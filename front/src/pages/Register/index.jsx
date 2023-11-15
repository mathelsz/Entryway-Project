import { Link } from 'react-router-dom';

import logo from '../../assests/logo.webp'
import { LayoutComponents } from '../../components/LayoutsComponents';
import { InputPassword, InputVerifyPassword } from '../../components/Inputs/Password';
import { InputUsername } from '../../components/Inputs/Username';
import { InputName } from '../../components/Inputs/Name';
import { InputEmail } from '../../components/Inputs/Email';

export const Register = () => {

  return (
    <LayoutComponents>
      <form className="login-form">

        <span className="login-form-title">Register</span>

        <span className="login-form-title">
          <img src={logo} alt='Logo de login' />
        </span>

        <InputUsername/>
        <InputName/>
        <InputEmail/>
        <InputPassword/>
        <InputVerifyPassword/>

        <div className="container-login-form-btn">
          <button className="login-form-btn">Register</button>
        </div>

        <div className="text-center">
          <span className="txt1">Ja possui conta?</span>

          <Link className="txt2" to="/login">Login.</Link>
        </div>

      </form>
    </LayoutComponents>
  );
}