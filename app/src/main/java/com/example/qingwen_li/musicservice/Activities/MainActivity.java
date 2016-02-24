package com.example.qingwen_li.musicservice.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.qingwen_li.musicservice.R;
import com.example.qingwen_li.musicservice.Service.MusicService;

public class MainActivity extends AppCompatActivity {
    //背景音乐的开关
   private Button btn_service;
    //用于开关背景音乐的flag
    private  boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_service= (Button) findViewById(R.id.btn_service);
        /*
        * 启动背景音乐
        * */
        Log.e("start","intent");
        Intent intent = new Intent(MainActivity.this,MusicService.class);
        startService(intent);

        //给btn添加监听事件，用于背景音乐的开关
        btn_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("onclick","intent转移");
                Intent intent = new Intent(MainActivity.this,MusicService.class);
            if(!flag){
                startService(intent);
                flag=true;
            }else{
                stopService(intent);
                flag=false;
            }
            }
        });
    }

}
