package com.mca.administrator.contactapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLogin extends AppCompatActivity {
Button b1,b2,b3;
String s1,s2,s3;
    DbHelper contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        b1=(Button)findViewById(R.id.sl);
        b2=(Button)findViewById(R.id.al);
        b3=(Button)findViewById(R.id.reg);
        contact=new DbHelper(this);
        contact.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),StudentLogin.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(j);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(getApplicationContext(),Registration.class);
                startActivity(k);
            }
        });
    }
}
