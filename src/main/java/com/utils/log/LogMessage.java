package com.utils.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 日志基础类
 *
 * @author Dengzw
 * @author YuanSongMing
 * @version 1.0.0
 */
public class LogMessage<T> {
    // 什么人     什么时候   什么方式  做什么事（A-B-C-D..）与其他业务的关联记录 以Json的格式去记录   什么时间  在什么功能模块
    private String operator;    // 操作人
    private T record; // 操作记录

    private String url; // 关联其他业务

    public LogMessage() {
    }

    public LogMessage(String operator, T record) {
        this.operator = operator;
        this.record = record;
    }

    public LogMessage(String operator, T record, String url) {
        this.operator = operator;
        this.record = record;
        this.url = url;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .create();
        return gson.toJson(this);
    }
}