import { useState } from 'react';
import '../../../../src/styles.css'

export const InputCode = () => {
  const [code, setCode] = useState("");

  return (
    <div className="wrap-input">
      <input
        className={code !== "" ? 'has-val input' : 'input'}
        type="code"
        value={code}
        onChange={e => setCode(e.target.value)}
      />
      <span className="focus-input" data-placeholder="Code"></span>
    </div>
  );
}