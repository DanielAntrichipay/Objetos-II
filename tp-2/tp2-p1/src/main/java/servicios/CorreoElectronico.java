package servicios;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class CorreoElectronico implements NotificarInscripcion {
	private String correoDeRemitente;
	
	public CorreoElectronico (String correoDeRemitente){
		this.correoDeRemitente = correoDeRemitente;
	}
	
	@Override
	public void enviarNotificacion(String destino, String asunto, String mensaje) {
		 Email email = EmailBuilder.startingBlank()
		            .from("Remitente", correoDeRemitente)
		            .to("Destinatario", destino)
		            .withSubject(asunto)
		            .withPlainText(mensaje)
		            .buildEmail();

		        Mailer mailer = MailerBuilder
		            .withSMTPServer("sandbox.smtp.mailtrap.io", 587, "1a2b3c4d5e6f7g", "password")
		            .withTransportStrategy(TransportStrategy.SMTP)
		            .buildMailer();

		        mailer.sendMail(email);
	}
}
