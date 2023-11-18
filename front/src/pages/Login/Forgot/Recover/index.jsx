import { LayoutComponents } from "../../../../components/LayoutsComponents";
import { Link } from "react-router-dom";

export const Recover = () => {
	return (
		<LayoutComponents title="Link de verificação enviado">
			<span className="login-form-title">Verifique seu e-mail.</span>

			<div className="text-center">
				<span className="txt1">ou</span>
				<Link className="txt2" to="/login">entre na conta</Link>
			</div>
		</LayoutComponents>
	);
}