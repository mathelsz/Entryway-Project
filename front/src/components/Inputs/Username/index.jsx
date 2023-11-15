import { useState } from 'react';
import '../../../../src/styles.css'

export const InputUsername = () => {
  const [username, setUsername] = useState("")

  return (
    <div className="wrap-input">
          <input
            className={username !== "" ? 'has-val input' : 'input'}
            type="username"
            value={username}
            onChange={e => setUsername(e.target.value)}
          />
          <span className="focus-input" data-placeholder="Username"></span>
        </div>
  );
}