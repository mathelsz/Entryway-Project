import '../../../../src/styles.css'

export const ButtomDefault = (props) => {
    return (
        <div className={props.className}>
            <button
                className="login-form-btn"
                onClick={props.onClick}>{props.text}</button>
        </div>
    );
}