package com.uzpeng.domain;

/**
 * @author serverliu on 2018/2/26.
 */
public class ErrorMsgDO {
    private String msg;
    private final String documentations_url = "https://github.com/UZPENG/REST-JAVA-WEB/wiki/Documentions";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
