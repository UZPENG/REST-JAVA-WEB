package com.uzpeng.web;


import com.uzpeng.service.CarInfoService;
import com.uzpeng.service.HandleErrorService;
import com.uzpeng.service.LogService;
import com.uzpeng.util.ConfigUtil;
import com.uzpeng.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author serverliu on 2018/2/26.
 */
@Controller
public class CarInfoController {
    @Autowired
    private CarInfoService carInfoService;
    @Autowired
    private LogService logService;
    @Autowired
    private HandleErrorService handleErrorService;

    public void setCarInfoService(CarInfoService carInfoService) {
        this.carInfoService = carInfoService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    public void setHandleErrorService(HandleErrorService handleErrorService) {
        this.handleErrorService = handleErrorService;
    }

    @RequestMapping(value = "/crawl/car")
    @ResponseBody
    public String getCarInfo(HttpServletResponse response, HttpServletRequest request){
        if(!HttpUtil.checkMethod(request, HttpUtil.GET)){
            return handleErrorService.handleError("NOT FOUND");
        }

        logService.insertLog(HttpUtil.getIpAddress(request));
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","application/json");

        String offset = request.getParameter("offset");
        String limit = request.getParameter("limit");

        String defaultLimit = "30";
        String defaultOffset = "0";
        limit = limit == null ? defaultLimit : limit;
        offset = offset == null ? defaultOffset : offset;
        System.out.println("limit:"+limit+",offset:"+offset);

        try{
            /*
             验证输入
             */
            int numOffset = Integer.parseInt(offset);
            int numLimit = Integer.parseInt(limit);

            if((numLimit != 10 && numLimit != 20 && numLimit != 30) || numOffset % 10 != 0){
                return handleErrorService.handleError("Invalid Parameter");
            }
            return carInfoService.getCarInfo(numLimit, numOffset);
        }catch (NumberFormatException e){
            return handleErrorService.handleError("Invalid Parameter");
        }
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public String getModuleList(HttpServletResponse response, HttpServletRequest request){
        if(!HttpUtil.checkMethod(request, HttpUtil.GET)){
            return  handleErrorService.handleError("NOT FOUND");
        }

        String configFileName = "module-list.json";
        try{
            JSONObject responseJson = ConfigUtil.readJsonConf(configFileName);

            return responseJson.toString();
        } catch (JSONException | IOException e){
            return  handleErrorService.handleError("Internal Error!");
        }
    }

    @RequestMapping(value = "/crawl")
    @ResponseBody
    public String getApiList(HttpServletResponse response, HttpServletRequest request){
        if(!HttpUtil.checkMethod(request, HttpUtil.GET)){
            return  handleErrorService.handleError("NOT FOUND");
        }

        String configFileName =  "api-list.json";
        try{
            JSONObject responseJson = ConfigUtil.readJsonConf(configFileName);

            return responseJson.toString();
        } catch (JSONException | IOException e){
            return  handleErrorService.handleError("Internal Error!");
        }
    }

    @RequestMapping("/errors")
    public void handleError(HttpServletResponse response) {
        handleErrorService.handleError(response, "Not Found!");
    }
}
