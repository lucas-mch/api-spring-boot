package dev.lucasmachado.services;

import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);
	void sendEmail(SimpleMailMessage message);
	void sendNewPasswordEmail(Cliente cliente, String newPass);

}
