import { useState } from 'react';
import '../../../../src/styles.css'

export const InputName = () => {
  const [name, setName] = useState("")

  return (
    <div className="wrap-input">
          <input
            className={name !== "" ? 'has-val input' : 'input'}
            type="name"
            value={name}
            onChange={e => setName(e.target.value)}
          />
          <span className="focus-input" data-placeholder="Name"></span>
        </div>
  );
}