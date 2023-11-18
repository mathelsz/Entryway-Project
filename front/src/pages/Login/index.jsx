import { Link, useNavigate } from 'react-router-dom';
import { LayoutComponents } from '../../components/LayoutsComponents';
import { InputText } from "../../components/Inputs";
import { useState } from "react";
import { ButtomDefault } from "../../components/Buttons/ButtomDefault";

export const Login = () => {
	const navigate = useNavigate();
	const [formData, setFormData] = useState({
		username: '',
		password: '',
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

		navigate('/home');
	};

	const handleSignUpIsEmpty = (event) => {
		event.preventDefault();
	};

	return (
		<LayoutComponents title="Bem Vindo">

			<InputText
				className={formData.username !== "" ? "has-val input" : "input"}
				type="text"
				placeholder="Usuário"
				value={formData.username}
				onChange={e => handleInputChange("username", e.target.value)}
			/>

			<InputText
				className={formData.password !== "" ? "has-val input" : "input"}
				type="password"
				placeholder="Senha"
				value={formData.password}
				onChange={e => handleInputChange("password", e.target.value)}
			>
				<div className={formData.password !== "" ? "text-redefine-password-active" : "text-redefine-password"}>
					<Link className="txt2" to={formData.password !== "" ? "" : "/login/forgot"}>Esqueceu?</Link>
				</div>
			</InputText>

			<ButtomDefault
				className="container-login-form-btn"
				text="Entrar"
				onClick={
					formData.username &&
					formData.password !== '' ? handleSignUp : handleSignUpIsEmpty
				}
			/>

			<div className="text-center">
				<span className="txt1">Novo no Entryway?</span>
				<Link className="txt2" to="/signup">Inscrever-se</Link>
			</div>
		</LayoutComponents>
	);
}
