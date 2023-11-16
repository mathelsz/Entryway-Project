import { useState } from 'react';
import '../../../../src/styles.css'

export const InputName = ({ onChange }) => {
  const [nameInput, setNameInput] = useState("");

  const handleInputChange = (e) => {
    const value = e.target.value;
    setNameInput(value);
    onChange(value);
  };

  return (
    <div className="wrap-input">
          <input
            className={nameInput !== "" ? 'has-val input' : 'input'}
            type="name"
            value={nameInput}
            onChange={handleInputChange}
          />
          <span className="focus-input" data-placeholder="Name"></span>
        </div>
  );
}