package com.uzpeng.exception;

import com.uzpeng.service.HandleErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author serverliu on 2018/3/7.
 */
@Component
public class CommonExceptionHandler extends ExceptionHandlerExceptionResolver {
    @Autowired
    private HandleErrorService handleErrorService;

    public void setHandleErrorService(HandleErrorService handleErrorService) {
        this.handleErrorService = handleErrorService;
    }

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {
        handleErrorService.handleError(response, "Not Found!");
        return null;
    }
}
