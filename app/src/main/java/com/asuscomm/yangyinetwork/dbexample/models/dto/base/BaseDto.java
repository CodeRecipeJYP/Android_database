package com.asuscomm.yangyinetwork.dbexample.models.dto;

/**
 * Created by jaeyoung on 2017. 6. 20..
 */

public class BaseDto<T> {
    private String responseCode;
    private Paging paging;
    class Paging {
        private int total;
        private int offset;
        private int limit;
    }
    private T data;

    @Override
    public String toString() {
        return "BaseDto{" +
                "responseCode='" + responseCode + '\'' +
                ", paging=" + paging +
                ", data=" + data +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
