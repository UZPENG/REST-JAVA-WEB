package com.uzpeng.service;

import com.google.gson.GsonBuilder;
import com.uzpeng.domain.ErrorMsgDO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author serverliu on 2018/3/7.
 */
@Service
public class HandleErrorService {

    public void handleError(HttpServletResponse response, String msg){
        try{
            PrintWriter writer = response.getWriter();
            writer.write(handleError(msg));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String handleError(String msg){
        ErrorMsgDO errorMsg = new ErrorMsgDO();
        errorMsg.setMsg(msg);

        return new GsonBuilder().create().toJson(errorMsg);
    }
}
