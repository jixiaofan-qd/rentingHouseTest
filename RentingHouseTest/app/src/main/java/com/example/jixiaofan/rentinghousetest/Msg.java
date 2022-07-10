package com.example.jixiaofan.rentinghousetest;

/**
 * Created by jixiaofan on 2022/7/10.
 */

public class Msg {

    public static final int TYPE_RECEVED = 0;

    public static final int TYPR_SEND = 1;

    private String content;

    private int type;

    public Msg (String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent(){
        return content;
    }

    public int getType() {
        return type;
    }
}