package com.zhongyou.welcome_library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import com.zhongyou.destination_library.DestinationActivity;

/**
 * Created by Tang on 2016/9/28.
 */
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        handler.sendEmptyMessageDelayed(0,2000);//两秒后跳转到主界面
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(WelcomeActivity.this,DestinationActivity.class);
            startActivity(intent);
        }
    };
}
