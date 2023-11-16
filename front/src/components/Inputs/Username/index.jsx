import React, { useState } from 'react';
import '../../../../src/styles.css';

export const InputUsername = ({ onChange }) => {
  const [inputUsername, setInputUsername] = useState("");

  const handleInputChange = (e) => {
    const value = e.target.value;
    setInputUsername(value);
    onChange(value);
  };

  return (
    <div className="wrap-input">
      <input
        className={inputUsername !== "" ? 'has-val input' : 'input'}
        type="username"
        value={inputUsername}
        onChange={handleInputChange}
      />
      <span className="focus-input" data-placeholder="Username"></span>
    </div>
  );
};
