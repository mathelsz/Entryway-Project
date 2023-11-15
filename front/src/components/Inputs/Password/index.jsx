import { useState } from 'react';
import '../../../../src/styles.css'

export const InputPassword = () => {
  const [password, setPassword] = useState("")

  return (
    <div className="wrap-input">
          <input
            className={password !== "" ? 'has-val input' : 'input'}
            type="password"
            value={password}
            onChange={e => setPassword(e.target.value)} />
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