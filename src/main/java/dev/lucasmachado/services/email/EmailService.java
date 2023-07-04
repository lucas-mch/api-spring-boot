package dev.lucasmachado.services.email;

import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pedido;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);
	void sendEmail(SimpleMailMessage message);
	void sendNewPasswordEmail(Cliente cliente, String newPass);
	void sendOrderHtmlConfirmationEmail(Pedido pedido);
	void sendHtmlEmail(MimeMessage msg);

}
