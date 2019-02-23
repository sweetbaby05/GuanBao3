package com.example.win10.guanbao.util;

import com.example.win10.guanbao.gson.NewsList;
import com.google.gson.Gson;

public class Utility {
    public static NewsList parseJsonWithGson(final  String requestText){
        Gson gson = new Gson();
        return gson.fromJson(requestText,NewsList.class);
    }
}
