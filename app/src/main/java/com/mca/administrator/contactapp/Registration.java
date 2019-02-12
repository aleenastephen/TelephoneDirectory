package com.mca.administrator.contactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6;
Button b;
String s1,s2,s3,s4,s5,s6;
    DbHelper contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.mob);
        e4=(EditText)findViewById(R.id.regname);
        e5=(EditText)findViewById(R.id.regpass);
        e6=(EditText)findViewById(R.id.cpass);
        b=(Button)findViewById(R.id.registraion);
        contact=new DbHelper(this);
        contact.getWritableDatabase();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                Log.d("name",s1);
                Log.d("email",s2);
                Log.d("mob",s3);
                Log.d("user",s4);
                Log.d("pass",s5);
                Log.d("cnf",s6);
                boolean status=contact.insert(s1,s2,s3,s4,s5,s6);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"Successfully Registered...",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }

            }
        });





    }
}
