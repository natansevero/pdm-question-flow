package com.example.natan.flow;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import flow.Flow;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        newBase = Flow.configure(newBase, this)
                .dispatcher(new BasicDispatcher(this))
                .defaultKey(new SimpleScreen())
                .keyParceler(new BasicKeyParceler())
                .install();

        super.attachBaseContext(newBase);
    }

    @Override
    public void onBackPressed() {
        if(!Flow.get(this).goBack()) super.onBackPressed();
    }


}
