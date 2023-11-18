import { LayoutComponents } from "../../../components/LayoutsComponents";
import { InputText } from "../../../components/Inputs";
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import { ButtomDefault } from "../../../components/Buttons/ButtomDefault";

export const Forgot = () => {
	const navigate = useNavigate();
	const [formData, setFormData] = useState({
		email: ''
	});

	const handleInputChange = (field, value) => {
		setFormData({
			...formData,
			[field]: value,
		});
	};

	const handleSignUp = (event) => {
		event.preventDefault();

		//TODO: implementar o backend

		console.log('data:', formData);

		navigate('/login/forgot/recover');
	};

	const handleSignUpIsEmpty = (event) => {
		event.preventDefault();
	};

	return (
		<LayoutComponents title="Esqueceu sua senha?">

			<InputText
				className={formData.email !== "" ? "has-val input" : "input"}
				type="email"
				placeholder="Email"
				value={formData.email}
				onChange={e => handleInputChange("email", e.target.value)}
			/>

			<ButtomDefault
				className="login-form-btn"
				text="Continue"
				onClick={formData.email !== '' ? handleSignUp : handleSignUpIsEmpty}>
			</ButtomDefault>

			<div className="text-center">
				<span className="txt1">ou</span>
				<Link className="txt2" to="/login">entre na conta</Link>
			</div>

		</LayoutComponents>
	);
}