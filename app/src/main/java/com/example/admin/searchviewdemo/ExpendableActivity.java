package com.example.admin.searchviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * toolBar与searchView结合，searchView采用menu的形式引入
 */
public class ExpendableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expendable);

        /**
         * 1、布局文件中添加toolBar控件
         * 2、menifest文件中更改成noActionBar主题
         * 3、在代码中设置toolBar为actionBar
         *
         * 4、创建menu文件，创建searchView item
         * 5、onCreateOptionItem中引入menu
         * 6、设置searchView
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_expendable,menu);
        /**
         * 1、设置提示语
         * 2、设置提交按钮监听
          */
        MenuItem item = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setQueryHint("提示语");

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

        return true;
    }

    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
