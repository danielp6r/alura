package br.com.alura.adopetstore.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EnviadorEmail {

    @Autowired
    private JavaMailSender emailSender;

    public void enviarEmail(String assunto, String destinatario, String textoEmail) {
        try {
//            Código para envio de email real
            var email = new SimpleMailMessage();
            email.setFrom("danielpereira.ifc@gmail.com");
            email.setSubject(assunto);
            email.setTo(destinatario);
            email.setText(textoEmail);
            emailSender.send(email);
            System.out.println("Enviando email!");
            System.out.println(textoEmail);

        } catch (Exception e) {

            throw new RuntimeException("Erro ao enviar email!", e);
        }
    }

}
