package com.utils.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author YangQing
 * @version 1.0.0
 */
public class EpmLogMessage {
    // 什么系统、什么功能模块、具体的类和方法、谁在操作、时间、做了什么操作
    private String service; // 什么系统
    private String module;  // 什么功能模块
    private String method;  // 具体的类和方法
    private String operation;    // 做了什么操作

    public EpmLogMessage() {
    }

    public EpmLogMessage(String service, String module, String method, String operation) {
        this.service = service;
        this.module = module;
        this.method = method;
        this.operation = operation;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .create();
        return gson.toJson(this);
    }
}