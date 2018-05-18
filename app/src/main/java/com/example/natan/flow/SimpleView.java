package com.example.natan.flow;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

public class SimpleView extends LinearLayout {
    public SimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        TextView simpleTextView = (TextView) findViewById(R.id.tv_simple);
        simpleTextView.setText("Simple View with Flow");
    }
}
