package com.example.win10.guanbao;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class GuanBaoApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
