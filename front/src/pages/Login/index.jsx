import { Link } from 'react-router-dom';

import { LayoutComponents } from '../../components/LayoutsComponents';
import { InputUsername } from '../../components/Inputs/Username';
import { InputPasswordWithReset } from '../../components/Inputs/Password';

export const Login = () => {
  return (
    <LayoutComponents title="Welcome">

      <InputUsername />
      <InputPasswordWithReset />

      <div className="container-login-form-btn">
        <button className="login-form-btn">Sign in</button>
      </div>

      <div className="text-center">
        <span className="txt1">New to Entryway?</span>

        <Link className="txt2" to="/register">Sign Up</Link>
      </div>

    </LayoutComponents>
  );
}