package com.mca.administrator.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminPage extends AppCompatActivity {
Button b1,b2,b3;
String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        b1=(Button)findViewById(R.id.ac);
        b2=(Button)findViewById(R.id.uc);
        b3=(Button)findViewById(R.id.dc);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i=new Intent(getApplicationContext(),)
            }
        });

    }
}
