package com.zhongyou.bottom_library;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Tang on 2016/10/9.
 */
public class BottomFragment extends Fragment {
    RadioButton rb1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_activity,container,false);
        rb1 = (RadioButton) view.findViewById(R.id.tab_rb_a);
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),R.string.app_name,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
