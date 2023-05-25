package org.itstep;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender sender;

    public void sendTextEmail(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.from);
        message.setTo(email.to);
        message.setSubject(email.subject);
        message.setText(email.text);

        sender.send(message);
    }
    public void sendHtmlEmail(Email email){
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = null;
        Context context = new Context();
        try {
            helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            helper.setFrom(email.from);
            helper.setTo(email.to);
            helper.setSubject(email.subject);
            String html;
            helper.setText(email.text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
