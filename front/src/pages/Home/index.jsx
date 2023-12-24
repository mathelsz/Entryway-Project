import React from 'react';
import logo from '../../assets/logo.webp';
import '../../../src/styles.css'
import { ButtomDefault } from "../../components/Buttons/ButtomDefault";
import { useNavigate } from "react-router-dom";

export const Home = () => {
	const navigate = useNavigate();
	const handleSignUp = (event) => {
		event.preventDefault();

		navigate('/login');
	};

	return (
		<div className="construction-message">
			<div>
				<h2>Em Construção</h2>
				<p>Estamos trabalhando para trazer novas funcionalidades incríveis para você. Agradecemos a sua paciência!</p>
				<img src={logo} alt="Logo do Projeto" className="logo" />

				<ButtomDefault
					className="login-form-btn"
					text="Sair"
					onClick={handleSignUp}/>
			</div>
		</div>
	);
}