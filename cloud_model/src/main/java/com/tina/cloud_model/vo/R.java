package com.tina.cloud_model.vo;

import lombok.Data;

@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R() {
    }
    public static R ok(){
        return new R(0,"ok",null);
    }
    public static R fail(){
        return new R(1,"ERROR",null);
    }
    public static R ok(Object obj){
        return new R(0,"ok",obj);
    }
    public static R fail(String msg){
        return new R(1,msg,null);
    }
}
