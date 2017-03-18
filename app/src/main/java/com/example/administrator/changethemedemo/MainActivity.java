package com.example.administrator.changethemedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button button2;
    private Guideline guideline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getTheme(this)) {
            setTheme(R.style.MyTheme1);
        } else {
            setTheme(R.style.MyTheme2);
        }
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        guideline = (Guideline) findViewById(R.id.guideline);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                setTheme(this, true);
                finish();
                Intent intent =new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                setTheme(this, false);
                finish();
                Intent intent2 =new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent2);
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置主题
     *
     * @param context
     * @return true 表示明亮主题 false 表示安主题
     */
    public static void setTheme(Context context, boolean is) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("isTheme", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("theme", is).commit();
    }

    /**
     * 得到主题
     *
     * @param context
     * @return
     */
    public static boolean getTheme(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("isTheme", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("theme", false);
    }

}
