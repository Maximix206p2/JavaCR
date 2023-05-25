package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @RequestMapping("/sendtext")
    public String sendText(){
        Email email = new Email();
        email.from = "maksim23orl@gmail.com";
        email.to = "maksim23orl@gmail.com";
        email.subject = "Тема";
        email.text = "Текст сообщения";
        emailService.sendTextEmail(email);
        return "success.html";
    }

    @RequestMapping("/sendhtml")
    public String sendHtml(){
        Email email = new Email();
        email.from = "maksim23orl@gmail.com";
        email.to = "maksim23orl@gmail.com";
        email.subject = "Тема";
        email.text = "Текст сообщения";
        emailService.sendTextEmail(email);
        return "success.html";
    }
}
