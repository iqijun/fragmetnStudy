package com.xinggs.viewStudy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.xinggs.fragmentstudy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ListViewAty extends AppCompatActivity {
    int[] imgs = new int[]{R.drawable.common_google_signin_btn_icon_light,R.drawable.common_full_open_on_phone};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_aty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView  listView = (ListView) findViewById(R.id.list2);
        ListView  listView1 = (ListView) findViewById(R.id.list1);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.tvparam,new String[]{"1111111111","2222222"});
        ArrayAdapter adapter1 = new ArrayAdapter(this,R.layout.tvparam,new String[]{"3333","4444"});
        listView1.setAdapter(adapter1);
        listView.setAdapter(adapter);

        //gridView

        List< Map<String,Object>> itemList = new ArrayList<Map<String,Object>>();
        for (int i =0;i<imgs.length;i++){
            Map<String,Object> map = new HashMap<String ,Object>();
            map.put("image",imgs[i]);
            itemList.add(map);
        }
        SimpleAdapter simpleAdapter = new  SimpleAdapter(this,itemList,R.layout.gridcell,new String[]{"image"},new  int[]{R.id.gridCellImg});
        GridView gridView = (GridView) findViewById(R.id.grid_img);
        gridView.setAdapter(simpleAdapter);

        final ImageView imageView = (ImageView) findViewById(R.id.grid_imgview);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imgs[position]);
            }
        });
    }

}
