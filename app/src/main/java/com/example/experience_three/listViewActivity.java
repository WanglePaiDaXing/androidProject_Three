package com.example.experience_three;

import android.app.LauncherActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listViewActivity extends AppCompatActivity {
    private String[] content = { "Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"  };
    private int[] images = new int[]{ R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.listviewlayout);
        final int color = 0xFFC5B5FF;
        //创建一个list集合，list集合的元素是Map
        final List<Map<String, Object>> ListItems = new ArrayList<Map<String, Object>>();
        for(int i=0;i<content.length;i++){
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put( "texts", content[i] );
            listItem.put( "images", images[i] );
            //加入list集合
            ListItems.add(listItem);
        }
        //创建一个simpleAdapter，此处严格按照定义数组names与image顺序，否则会出现程序build成功却运行失败且难以解决错误
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListItems, R.layout.listviewitemlayout, new String[]{"texts", "images"}, new int[]{R.id.texts, R.id.images});
        final ListView list = (ListView)findViewById(R.id.LV);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        //对应单击事件
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(content[position]+" 位置是："+position+"被单击");
                CharSequence text = content[position];
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(listViewActivity.this, text, duration);
                toast.show();
            }
        });
        //选中函数
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(content[position]+"选中");
                view.setBackgroundColor(color);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
