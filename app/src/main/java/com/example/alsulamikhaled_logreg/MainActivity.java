package com.example.alsulamikhaled_logreg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loginAction(View view){
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        intent.putExtra("name",username);
        intent.putExtra("pass",password);

        MainActivity.this.startActivity(intent);
    }
    public void RegisterAction(View v){
        Intent intent1=new Intent(MainActivity.this,RegisterActivity.class);
        startActivityForResult(intent1, 1);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                username = data.getStringExtra("name");
                password=data.getStringExtra("pass");
            }}}
            }
