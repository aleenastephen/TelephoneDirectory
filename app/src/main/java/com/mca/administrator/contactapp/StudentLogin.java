package com.mca.administrator.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentLogin extends AppCompatActivity {
EditText ed1,ed2;
Button b;
String s1,s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        ed1=(EditText)findViewById(R.id.uname);
        ed2=(EditText)findViewById(R.id.psw);
        b=(Button)findViewById(R.id.stdlogin);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                Intent i=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(i);
            }
        });
    }

}
