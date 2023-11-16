import { useState } from 'react';
import { Link } from 'react-router-dom';
import '../../../../src/styles.css'

export const InputPasswordWithReset = ({ onChange }) => {
  const [passwordInput, setPasswordInput] = useState("");

  const handleInputChange = (e) => {
    const value = e.target.value;
    setPasswordInput(value);
    onChange(value);
  };

  return (
    <div className="wrap-input">
      <input
        className={passwordInput !== "" ? 'has-val input' : 'input'}
        type="password"
        value={passwordInput}
        onChange={handleInputChange} />
      <span className="focus-input" data-placeholder="Password"></span>

      <div className="text-redefine-password">
        <Link className="txt2" to="/redefine-password">He forgot?</Link>
      </div>
    </div>
  );
}

export const InputPassword = ({ onChange }) => {
  const [passwordInput, setPasswordInput] = useState("")

  const handleInputChange = (e) => {
    const value = e.target.value;
    setPasswordInput(value);
    onChange(value);
  };

  return (
    <div className="wrap-input">
      <input
        className={passwordInput !== "" ? 'has-val input' : 'input'}
        type="password"
        value={passwordInput}
        onChange={handleInputChange} />
      <span className="focus-input" data-placeholder="Password"></span>
    </div>
  );
}

export const InputVerifyPassword = () => {
  const [password, setPassword] = useState("")

  return (
    <div className="wrap-input">
      <input
        className={password !== "" ? 'has-val input' : 'input'}
        type="password"
        value={password}
        onChange={e => setPassword(e.target.value)} />
      <span className="focus-input" data-placeholder="Verify Password"></span>
    </div>
  );
}