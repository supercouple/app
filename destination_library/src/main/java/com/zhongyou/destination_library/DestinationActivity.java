package com.zhongyou.destination_library;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.zhongyou.destination_library.Views.ObservableScrollView;

/**
 * Created by Tang on 2016/10/10.
 */
public class DestinationActivity extends Activity implements ObservableScrollView.ScrollViewListener {
    private View layoutHead;
    private ObservableScrollView scrollView;
    private ImageView imageView;
    int height;
    private TextView fristMore;
    private TextView twoMore;
    private TextView thirdMore;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_activity);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        scrollView = (ObservableScrollView) findViewById(R.id.scrollview);
        layoutHead = findViewById(R.id.view_head);
        imageView = (ImageView) findViewById(R.id.imageView1);
        layoutHead.setBackgroundColor(Color.argb(0, 0xfd, 0x91, 0x5b));
        //获取顶部图片高度后，设置滚动监听
        ViewTreeObserver vto = imageView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                height =   imageView.getHeight();
                imageView.getWidth();

                scrollView.setScrollViewListener(DestinationActivity.this);
            }
        });


        //更多1
        fristMore=(TextView)findViewById(R.id.more_id1);
        fristMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(DestinationActivity.this ,FristMoreActivity.class) ;
                 startActivity(intent) ;
            }
        });
        //更多2
        twoMore=(TextView)findViewById(R.id.more_id2);
        twoMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(DestinationActivity.this ,TwoMoreActivity.class) ;
                startActivity(intent) ;
            }
        });
        //更多3
        thirdMore=(TextView)findViewById(R.id.more_id3);
        thirdMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(DestinationActivity.this ,ThirdMoreActivity.class) ;
                startActivity(intent) ;
            }
        });
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y,
                                int oldx, int oldy) {
        if(y<=height){
            float scale =(float) y /height;
            float alpha =  (255 * scale);

            //layout全部透明
//          layoutHead.setAlpha(scale);

            //只是layout背景透明(仿知乎滑动效果)
            layoutHead.setBackgroundColor(Color.argb((int) alpha, 0xfd, 0x91, 0x5b));
        }

    }
}
