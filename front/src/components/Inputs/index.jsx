import '../../../src/styles.css'

export const InputText = (props) => {

    return (
        <div className="wrap-input">
            <input
                className= {props.className}
                type={props.type}
                value={props.value}
                onChange={props.onChange}
            />
            <span
                className="focus-input"
                data-placeholder={props.placeholder}></span>
            {props.children}
        </div>
    );
}