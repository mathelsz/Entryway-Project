import logo from '../../assests/logo.webp'
import '../../../src/styles.css'

export const LayoutComponents = (props) => {
  return (
    <div className="container">
      <div className="container-login">
        <div className="wrap-login">

          <form className="login-form">
            <span className="login-form-title">{props.title}</span>

            <span className="login-form-title">
              <img src={logo} alt='Logo de login' />
            </span>

            {props.children}
          </form>
        </div>
      </div>
    </div>
  );
}