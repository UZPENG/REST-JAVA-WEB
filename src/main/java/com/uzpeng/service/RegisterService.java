package com.uzpeng.service;

import com.uzpeng.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author serverliu on 2018/3/2.
 */
@Service
@Transactional
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
        msg.setFrom("liu@uzpeng.top");
        msg.setSubject("你的验证码");
        msg.setTo(emailAddress);
        msg.setText("6012");
        try {
            System.out.println("send!");
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.uzpeng.top");
            mailSender.setPort(25);

            mailSender.send(msg);
        } catch (MailException ex){
            ex.printStackTrace();
        }

    }

}
