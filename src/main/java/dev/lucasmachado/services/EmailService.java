package dev.lucasmachado.services;

import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
