package com.zhongyou.destination_library;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.*;
import com.zhongyou.destination_library.Views.ObservableScrollView;

import java.util.List;
import java.util.Map;

/**
 * Created by zlp on 2016/10/13.
 */
public class FristMoreActivity extends Activity {
    private View layoutHead;
    private ObservableScrollView scrollView;
    private ImageView imageView;
    int height;
    private TextView textView;
    private List<Map<String, Object>> mData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist_more_activity);

    }

}
