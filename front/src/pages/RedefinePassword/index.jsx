import { LayoutComponents } from "../../components/LayoutsComponents";

import { InputPassword, InputVerifyPassword } from "../../components/Inputs/Password";

export const RedefinePassword = () => {
  return (
    <LayoutComponents title="Redefine Password">

      <InputPassword />
      <InputVerifyPassword />

      <div className="container-login-form-btn">
        <button className="login-form-btn">Continue</button>
      </div>

      <div className="container-login-form-btn">
        <button className="login-form-btn">Back</button>
      </div>

    </LayoutComponents>
  );
}