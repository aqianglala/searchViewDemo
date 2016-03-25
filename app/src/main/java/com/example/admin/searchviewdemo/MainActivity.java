package com.example.admin.searchviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_expendable;
    private Button btn_unExpendable;
    private Button btn_custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void initView() {
        btn_expendable = (Button) findViewById(R.id.btn_expendable);
        btn_unExpendable = (Button) findViewById(R.id.btn_unExpendable);
        btn_custom = (Button) findViewById(R.id.btn_custom);
    }

    private void setListener() {
        btn_expendable.setOnClickListener(this);
        btn_unExpendable.setOnClickListener(this);
        btn_custom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_expendable:
                goActivity(ExpendableActivity.class);
                break;
            case R.id.btn_unExpendable:
                goActivity(UnExpendableActivity.class);
                break;
            case R.id.btn_custom:
                goActivity(CustomSvActivity.class);
                break;
        }
    }

    private void goActivity(Class clazz){
        startActivity(new Intent(this,clazz));
    }
}
