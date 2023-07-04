package dev.lucasmachado.services.email;

import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public class MockEmailService extends AbstractEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockEmailService.class);
    @Override
    public void sendEmail(SimpleMailMessage message) {
        LOGGER.info("Simulando envio de e-mail");
        LOGGER.info(message.toString());
        LOGGER.info("email enviado");
    }

    @Override
    public void sendNewPasswordEmail(Cliente cliente, String newPass) {

    }

    @Override
    public void sendOrderHtmlConfirmationEmail(Pedido pedido) {

    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOGGER.info("Simulando envio de e-mail");
        LOGGER.info(msg.toString());
        LOGGER.info("email enviado");
    }
}
