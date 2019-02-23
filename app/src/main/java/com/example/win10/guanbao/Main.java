package com.example.win10.guanbao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    List<Fragment>fragments;
    MenuItem menuItem;//定义菜单的列表项


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: 2019/1/18 趁现在刚开始写,可以渗透进各种设计思想,MVC,MVP,MVVM,推荐MVVM
        bottomNavigationView=findViewById(R.id.bottomnavigationview);//主页面控件id设置监听
        viewPager=findViewById(R.id.viewpager);//主页面viewpager设置监听


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())//进行判定
                {
                    case R.id.bnv_item1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.bnv_item3:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.bnv_item4:
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        break;

                }
                return true;
            }
        });



//设置底部导航栏选择状态
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {//滚动的时候

            }

            @Override
            public void onPageSelected(int i) {//page选择的时候的状态
                if(menuItem!=null)
                {
                    menuItem.setCheckable(false);
                }
                else
                {
                    menuItem=bottomNavigationView.getMenu().getItem(0);
                    menuItem.setCheckable(true);
                }
                menuItem=bottomNavigationView.getMenu().getItem(i);
                menuItem.setCheckable(true);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });





        fragments=new ArrayList<>();
        fragments.add(new MyFragment1());//实例化
        fragments.add(new MyFragment2());
        fragments.add(new MyFragment3());
        //实例化适配器
        adapter myadapter=new adapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myadapter);
        //碎片增加的数据全部到list<fragment>中
    }





    //适配器fragments,四个fragments链接四个页面
    private class adapter extends FragmentPagerAdapter//定义一个内部类____作用:向viewpage中添加数据.
    {
        List<Fragment> fragments;

        public adapter(FragmentManager fm,List<Fragment> list) {
            super(fm);//构造函数
            this.fragments=list;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);//返回
        }

        @Override
        public int getCount() {
            return fragments.size();//返回fragment数量
        }
    }
}
