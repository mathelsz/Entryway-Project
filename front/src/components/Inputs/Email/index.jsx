import { useState } from 'react';
import '../../../../src/styles.css'

export const InputEmail = ({ onChange }) => {
  const [emailInput, setEmailInput] = useState("");

  const handleInputChange = (e) => {
    const value = e.target.value;
    setEmailInput(value);
    onChange(value);
  };

  return (
    <div className="wrap-input">
          <input
            className={emailInput !== "" ? 'has-val input' : 'input'}
            type="email"
            value={emailInput}
            onChange={handleInputChange}
          />
          <span className="focus-input" data-placeholder="Email"></span>
        </div>
  );
}