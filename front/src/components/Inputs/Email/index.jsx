import { useState } from 'react';
import '../../../../src/styles.css'

export const InputEmail = () => {
  const [email, setEmail] = useState("")

  return (
    <div className="wrap-input">
          <input
            className={email !== "" ? 'has-val input' : 'input'}
            type="email"
            value={email}
            onChange={e => setEmail(e.target.value)}
          />
          <span className="focus-input" data-placeholder="Email"></span>
        </div>
  );
}