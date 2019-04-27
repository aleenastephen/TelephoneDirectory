package com.mca.administrator.contactapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
EditText ed1,ed2;
Button b;
String s1,s2;
String username="admin",pswd="admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        ed1=(EditText)findViewById(R.id.un);
        ed2=(EditText)findViewById(R.id.password);
        b=(Button)findViewById(R.id.adlogin);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                if ((s1.equals(username))&&(s2.equals(pswd))){
                    Intent i = new Intent(getApplicationContext(),AdminPage.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "You are not Authorized",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
