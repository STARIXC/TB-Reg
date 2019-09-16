/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.util.Setup;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author starixc
 */
public class MailUtil {

    public static void sendEmailRegistrationLink(String id, String email, String hash) throws AddressException, MessagingException {
        
        String host = Setup.MAIL_SMTP_HOST;
        final String user =Setup.MAIL_USERNAME;
        final String password=Setup.MAIL_PASSWORD;
        
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

       
        String link = Setup.MAIL_REGISTRATION_LINK + "?scope=activation&userId=" + id + "&hash=" + hash;
  
        StringBuilder bodyText = new StringBuilder();

        bodyText.append("<div>")
                .append("Dear user<br/></br>").append("Thank you for registration. Your Mail (")
                .append(email).append("Please click <a href=\"")
                .append(link)
                .append("\">here</a> or open bellow link in browser<br/> ")
                .append("<a href =\"").append(link)
                .append("\">")
                .append(link)
                .append("</a>")
                .append("<br/><br/>")
                .append("Thanks")
                .append("FHI 360- Afya Nyota")
                .append("</div>");

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(Setup.MAIL_USERNAME));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
        message.setSubject("FHI360 - AFYA NYOTA TB-REGISTER Activation Link");
        message.setContent(bodyText.toString(), "text/html; charset=utf-8");

    }

}
