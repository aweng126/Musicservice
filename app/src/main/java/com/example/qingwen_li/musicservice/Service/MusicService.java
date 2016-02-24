package com.example.qingwen_li.musicservice.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.qingwen_li.musicservice.R;

import java.io.IOException;

/**
 * Created by Qingwen_li on 2016/2/24.
 */
public class MusicService extends Service {
    /*
    * 媒体播放器
    * */
    private  MediaPlayer myMediaplayer;


    @Override
    public void onCreate() {
        super.onCreate();
        myMediaplayer = MediaPlayer.create(this, R.raw.bgm);
        myMediaplayer.start();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

          myMediaplayer.start();
        //重复播放
          myMediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
              @Override
              public void onCompletion(MediaPlayer mp) {
                  mp.start();
              }
          });
        //播放错误的处理
        myMediaplayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                //释放资源
                mp.release();
                return false;
            }
        });

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //停止并释放资源
        myMediaplayer.release();
        myMediaplayer=null;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
