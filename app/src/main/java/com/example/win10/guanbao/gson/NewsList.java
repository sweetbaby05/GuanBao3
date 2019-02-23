package com.example.win10.guanbao.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsList {

    public int code;

    public String msg;

    @SerializedName("newslist")
    public List<New> newsList;

}
