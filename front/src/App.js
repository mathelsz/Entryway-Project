import { useState } from 'react';
import logo from './assests/logo.webp'

import './styles.css'

function App() {
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")

  return (
    <div className="container">
      <div className="container-login">
        <div className="wrap-login">
          <form className="login-form">

              <span className="login-form-title">Bem Vindo</span>

              <span className="login-form-title">
                <img src={logo} alt='Logo de login'/>
              </span>

              <div className="wrap-input">
                <input 
                  className={username !== "" ? 'has-val input' : 'input'} 
                  type="username"
                  value={username}
                  onChange={e => setUsername(e.target.value)}
                  />
                <span className="focus-input" data-placeholder="Username"></span>
              </div>

              <div className="wrap-input">
                <input 
                  className={password !== "" ? 'has-val input' : 'input'} 
                  type="password"
                  value={password}
                  onChange={e => setPassword(e.target.value)}/>
                <span className="focus-input" data-placeholder="Password"></span>
              </div>

              <div className="container-login-form-btn">
                <button className="login-form-btn">Login</button>
              </div>

              <div className="text-center">
                <span className="txt1">Não possui conta?</span>

                <a className="txt2" href="#">Criar conta.</a>
              </div>

          </form>
        </div>
      </div>
    </div>
  );
}

export default App;
