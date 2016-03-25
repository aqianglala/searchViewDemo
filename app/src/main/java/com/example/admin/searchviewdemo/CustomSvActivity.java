package com.example.admin.searchviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class CustomSvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv_in_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        // 显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_unexpendable,menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        // 设置searchView总是展开，当然，menu文件中的showAsAction不能设置collapseActionView才有效
        searchView.onActionViewExpanded();
        // 设置提示语
        searchView.setQueryHint("提示语");
        // 设置确认监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showToast(query);
                // 消费了事件
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        /************************************** custom ***********************************/
        EditText editText = (EditText) searchView.findViewById(R.id.search_src_text);
        // 设置提示语颜色
        editText.setHintTextColor(Color.WHITE);
        // 设置输入文字的颜色
        editText.setTextColor(Color.WHITE);
        // 设置显示确认按钮,默认不显示
        searchView.setSubmitButtonEnabled(true);
        // 是否把搜索图标设置在editText的范围内
        searchView.setIconifiedByDefault(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
