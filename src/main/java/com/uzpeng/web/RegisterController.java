package com.uzpeng.web;

import com.uzpeng.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author serverliu on 2018/3/2.
 */
@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    private final static String KEY_EMAIL = "email";

    @RequestMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response){
        String specifyMethod = "POST";
        if(!request.getMethod().equals(specifyMethod)){
            return;
        }
        String email = request.getParameter("email");
        System.out.println("email:"+email);
        boolean emailStatus = registerService.checkEmailStatus(email);
        if (emailStatus){
            return;
        }
//        Cookie[] cookies = request.getCookies();
//        boolean isEmailValid = false;
//        for (Cookie cookie : cookies){
//            if(cookie.getName().equals("JSESSIONID")){
//                isEmailValid = true;
//                break;
//            }
//        }
        registerService.sendRegisterEmail(email);
    }
}
