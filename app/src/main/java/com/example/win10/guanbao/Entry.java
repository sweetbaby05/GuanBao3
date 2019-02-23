package com.example.win10.guanbao;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Entry extends AppCompatActivity {
    @BindView(R.id.edit_username)
    EditText edit_username;
    @BindView(R.id.edit_userpassword)
    EditText edit_userpassword;
    @BindView(R.id.button_register)
    Button button_register;
    @BindView(R.id.button_entry)
    Button button_entry;
    @BindView(R.id.activity_entry)
    LinearLayout activity_entry;

    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";//验证密码是否有特殊符号或长度不满6位
    private SQLiteDatabase w;
    private SQLiteDatabase r;
    private Mysqlist mys;
    private List<St> mdata;
    private String name;
    private String pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_entry);
        ButterKnife.bind(this);
        mys = new Mysqlist(this,"zhu_c",null,1);
        r = mys.getReadableDatabase();
        w=mys.getWritableDatabase();
        mdata=new ArrayList<St>();
        Cursor query = r.rawQuery("select * from user_mo", null);
        while(query.moveToNext()){
            int index1 = query.getColumnIndex("name");
            int index2 = query.getColumnIndex("pass");
            name = query.getString(index1);
            pass = query.getString(index2);
            mdata.add(new St(0, name, pass));
        }
    }
    @OnClick({R.id.button_entry,R.id.button_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_entry:
                String name1 = edit_username.getText().toString().trim();
                String pass1 = edit_userpassword.getText().toString().trim();
                if (name1.equals(name)&&pass1.equals(pass)){

                    Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MyFragment1.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"账号与密码输入不正确",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_register:
                Intent intent1 = new Intent(this,Register.class);
                startActivity(intent1);
                break;
        }
    }


}
