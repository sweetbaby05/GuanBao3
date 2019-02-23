package com.example.win10.guanbao;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MyFragment3 extends Fragment {
//    private TextView textView;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=inflater.inflate(R.layout.fragment_myself,container,false);


        RelativeLayout edition = view1.findViewById(R.id.myself_edition);
        RelativeLayout callme = view1.findViewById(R.id.myself_callme);
        RelativeLayout entry = view1.findViewById(R.id.myself_entry);
        RelativeLayout register = view1.findViewById(R.id.myself_register);
        RelativeLayout address = view1.findViewById(R.id.myself_address);

        //跳转到我的位置
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Lbs.class);
                startActivity(intent);
            }
        });

        //跳转到注册界面
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Register.class);
                startActivity(intent);
            }
        });
        //跳转到登录界面
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Entry.class);
                startActivity(intent);
            }
        });

        //跳转到版本信息界面
        edition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Edition.class);
                startActivity(intent);
            }
        });

        //跳转到管理员联系QQ
        callme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.e("1212","enteronclick");
                if (checkApkExist(getContext(),"com.tencent.mobileqq")){
                    String urlQQ = "mqqwpa://im/chat?chat_type=wpa&uin=2433987036&version=1";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlQQ)));
                }else {
                    Toast.makeText(getContext(),"本机未安装QQ应用",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view1;

    }


    public boolean checkApkExist(Context context, String packageName) {
        if (packageName == null || "".equals(packageName))
            return false;
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}

