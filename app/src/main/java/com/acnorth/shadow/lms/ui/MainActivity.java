package com.acnorth.shadow.lms.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.acnorth.shadow.lms.R;
//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //定义4个Fragment的对象
    private Fragment1 fg1;
    private Fragment2 fg2;
    private Fragment3 fg3;
    private Fragment4 fg4;
    //帧布局对象,就是用来存放Fragment的容器
    private FrameLayout flayout;
    //定义底部导航栏的四个布局
    private RelativeLayout home_page_layout;
    private RelativeLayout plant_layout;
    private RelativeLayout action_layout;
    private RelativeLayout personal_layout;
    //定义底部导航栏中的ImageView与TextView
    private ImageView home_page_image;
    private ImageView plant_image;
    private ImageView action_image;
    private ImageView personal_image;
    private TextView home_page_text;
    private TextView plant_text;
    private TextView action_text;
    private TextView personal_text;
    //定义要用的颜色值
    private int white = 0xffffff;
    private int gray = 0x9f9f9f;
    private int green =0x62f58b;
    //定义FragmentManager对象
    FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getSupportFragmentManager();
        init();
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

    }

    void init()
    {
        System.out.println("123");
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("图书馆管理系统v1.0");
        toolbar.setLogo(R.drawable.action_icon);

        home_page_image = (ImageView) findViewById(R.id.home_page_image);
        plant_image = (ImageView) findViewById(R.id.plant_image);
        action_image = (ImageView) findViewById(R.id.action_image);
        personal_image = (ImageView) findViewById(R.id.personal_image);
        home_page_text = (TextView) findViewById(R.id.home_page_text);
        plant_text = (TextView) findViewById(R.id.plant_text);
        action_text = (TextView) findViewById(R.id.action_text);
        personal_text = (TextView) findViewById(R.id.personal_text);
        home_page_layout = (RelativeLayout) findViewById(R.id.home_page_layout);
        plant_layout = (RelativeLayout) findViewById(R.id. plant_layout);
        action_layout = (RelativeLayout) findViewById(R.id.action_layout);
        personal_layout = (RelativeLayout) findViewById(R.id.personal_layout);
        home_page_layout.setOnClickListener(this);
        plant_layout.setOnClickListener(this);
        action_layout.setOnClickListener(this);
        personal_layout.setOnClickListener(this);
        setChioceItem(0);
    }

    //重写onClick事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_page_layout:
                setChioceItem(0);
                System.out.println("0");
                break;
            case R.id.plant_layout:
                setChioceItem(1);
                System.out.println("1");
                break;
            case R.id.action_layout:
                setChioceItem(2);
                System.out.println("2");
                break;
            case R.id.personal_layout:
                setChioceItem(3);
                System.out.println("3");
                break;
            default:
                break;
        }

    }

    //定义一个选中一个item后的处理
    public void setChioceItem(int index)
    {
        //重置选项+隐藏所有Fragment
        FragmentTransaction transaction = fManager.beginTransaction();
        clearChioce();
        hideFragments(transaction);
        switch (index) {
            case 0:
                home_page_image.setImageResource(R.drawable.home_page_pressed_icon);
                home_page_text.setTextColor(green);

                if (fg1 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg1 = new Fragment1();
                    transaction.add(R.id.content, fg1);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg1);
                }
                break;

            case 1:
                plant_image.setImageResource(R.drawable.plant_pressed_icon);
                plant_text.setTextColor(green);

                if (fg2 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg2 = new Fragment2();
                    transaction.add(R.id.content, fg2);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg2);
                }
                break;

            case 2:
                action_image.setImageResource(R.drawable.action_pressed_icon);
                action_text.setTextColor(green);

                if (fg3 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg3 = new Fragment3();
                    transaction.add(R.id.content, fg3);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg3);
                }
                break;

            case 3:
                personal_image.setImageResource(R.drawable.personal_pressed_icon);
                personal_text.setTextColor(green);

                if (fg4 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg4 = new Fragment4();
                    transaction.add(R.id.content, fg4);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg4);
                }
                break;
        }
        transaction.commit();
    }
    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction transaction) {
        if (fg1 != null) {
            transaction.hide(fg1);
        }
        if (fg2 != null) {
            transaction.hide(fg2);
        }
        if (fg3 != null) {
            transaction.hide(fg3);
        }
        if (fg4 != null) {
            transaction.hide(fg4);
        }
    }

    public void clearChioce() {
        home_page_image.setImageResource(R.drawable.home_page_icon);
        home_page_layout.setBackgroundColor(white);
        home_page_text.setTextColor(gray);
        plant_image.setImageResource(R.drawable.plant_icon2);
        plant_layout.setBackgroundColor(white);
        plant_text.setTextColor(gray);
        action_image.setImageResource(R.drawable.action_icon);
        action_layout.setBackgroundColor(white);
        action_text.setTextColor(gray);
        personal_image.setImageResource(R.drawable.personal_icon2);
        personal_layout.setBackgroundColor(white);
        personal_text.setTextColor(gray);
    }
}
