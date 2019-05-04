package com.example.experience_three;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.othermain_layout);
        final Button gotoAD = (Button)findViewById(R.id.btn_AD);
        gotoAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        final Button gotoLV = (Button)findViewById(R.id.btn_LV);
        gotoLV.setOnClickListener(listener_LV);
        final Button gotoMA = (Button)findViewById(R.id.btn_Menu);
        gotoMA.setOnClickListener(listener_MA);
    }
    /* 实现监听器 */
    Button.OnClickListener listener_LV = new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,listViewActivity.class);
            startActivity(intent);
        }
    };
    Button.OnClickListener listener_MA = new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this, menuActivity.class);
            startActivity(intent);
        }
    };
    private void showDialog(){
        //创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //获取布局
        View view = View.inflate(MainActivity.this, R.layout.alertdialog_layout, null);
        //获取布局中的控件
        final EditText username = (EditText) view.findViewById(R.id.et_name);
        final EditText password = (EditText) view.findViewById(R.id.et_pass);
        final Button cancel = (Button) view.findViewById(R.id.btn_NO1);
        final Button login = (Button) view.findViewById(R.id.btn_NO2);
        //设置参数
        builder.setView(view);
        //创建对话框
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                alertDialog.dismiss();
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                if(name.equals("Wang") && pwd.equals("wang")){
                    Toast.makeText(MainActivity.this, "Login Succeed!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Wrong username or password , please check it out", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
