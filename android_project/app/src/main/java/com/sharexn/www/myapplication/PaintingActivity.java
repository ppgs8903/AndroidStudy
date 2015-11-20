package com.sharexn.www.myapplication;

/**
 * Created by admin on 2015/11/19.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class PaintingActivity extends Activity {
    private Button button;

    @Override
    // Activity 运行的入口
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        super.onCreate(savedInstanceState);
        setContentView(R.layout.painting_activity);
        button = (Button)findViewById(R.id.painting_button);
        String name = getIntent().getStringExtra("name");
        button.setText(name);
    }

}
