package com.uzpeng.service;

import com.uzpeng.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * @author serverliu on 2018/3/2.
 */
@Service
public class RegisterService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkEmailStatus(String email){
        return userDao.checkEmailStatus(email);
    }

    public void sendRegisterEmail(String emailAddress){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("admin@uzpeng.top");
        msg.setSubject("your code");
        msg.setTo(emailAddress);
        msg.setText("6012");
        try {
            System.out.println("send!");
            MailSender mailSender = new JavaMailSenderImpl();

            mailSender.send(msg);
        } catch (MailException ex){
            ex.printStackTrace();
        }
    }

}
