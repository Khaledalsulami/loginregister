package com.example.alsulamikhaled_logreg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }
    //call registration button event
    public void reg(View view2){
        final EditText name= (EditText)findViewById(R.id.editText3);
        final EditText fname= (EditText)findViewById(R.id.editText4);
        final EditText dob= (EditText)findViewById(R.id.editText5);
        final EditText email= (EditText)findViewById(R.id.editText6);
        final EditText pass= (EditText)findViewById(R.id.editText7);

        final String firstname=name.getText().toString();
        String familyname=fname.getText().toString();
        String birthdate=dob.getText().toString();
        String mail=email.getText().toString();
      final   String password=pass.getText().toString();
        //no empty field check
        if(!TextUtils.isEmpty(firstname)&& !TextUtils.isEmpty(familyname)&& !TextUtils.isEmpty(birthdate) && !TextUtils.isEmpty(mail)&& !TextUtils.isEmpty(password)){
            //first name value check
            if(firstname.length()>3&&firstname.length()<30){
                String regEx ="^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d{2}$";
                Matcher matcherObj = Pattern.compile(regEx).matcher(birthdate);
                if (matcherObj.matches())
                {
                //Email validation
                String Pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(mail.matches(Pattern)){
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(RegisterActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(RegisterActivity.this);
                    }
                    builder.setTitle("Register Successfull")
                            .setMessage("You are successfully register, To Login now, go to main screen")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                                    Bundle bundle=new Bundle();
                                    bundle.putString("name",firstname);
                                    bundle.putString("pass",password);
                                    intent.putExtras(bundle);
                                    setResult(RESULT_OK, intent);
                                    finish();
                                }
                            }).setIcon(R.drawable.logo)
                            .show();
                  }
                    else Toast.makeText(RegisterActivity.this,"Email invalid", Toast.LENGTH_SHORT).show();}
                else Toast.makeText(RegisterActivity.this,"Date of birth not in correct format", Toast.LENGTH_SHORT).show();

            }else  Toast.makeText(RegisterActivity.this, "first name should at least 3 char and not more than 30", Toast.LENGTH_SHORT).show();
        }
        else
        { Toast.makeText(RegisterActivity.this, "Donot left any field empty ", Toast.LENGTH_SHORT).show();}


    }
}
