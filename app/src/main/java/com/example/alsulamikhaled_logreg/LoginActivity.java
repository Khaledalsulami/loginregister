package com.example.alsulamikhaled_logreg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public  void log(View
                     view){
        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText pass = (EditText) findViewById(R.id.editText2);
        String names=name.getText().toString();
        String passes=pass.getText().toString();
        Bundle i = getIntent().getExtras();
        String username = i.getString ( "name" );
        String password = i.getString ( "pass" );
        if(!TextUtils.isEmpty(names)&&!TextUtils.isEmpty(names)){
        if(names.contains(username)&&passes.contains(password))
        { Toast.makeText(LoginActivity.this,"LoginSuccessfull", Toast.LENGTH_SHORT).show();}}
        else
        { Toast.makeText(LoginActivity.this,"Register first", Toast.LENGTH_SHORT).show();}

    }
}
