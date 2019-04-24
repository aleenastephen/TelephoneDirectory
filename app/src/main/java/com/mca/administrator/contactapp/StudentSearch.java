package com.mca.administrator.contactapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StudentSearch extends AppCompatActivity {
    EditText e1,e2,e3,e0;
    String s1,s2,s3;
    TextView t1,t2,t0;
    DbHelper p;
    ImageView i;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_search);
        e1 = (EditText) findViewById(R.id.ssearch);
        e0= (EditText) findViewById(R.id.sna);
        e2 = (EditText) findViewById(R.id.sem);
        e3 = (EditText) findViewById(R.id.smo);

        t0=(TextView)findViewById(R.id.snam);
        t1=(TextView)findViewById(R.id.semail);
        t2=(TextView)findViewById(R.id.smob);
        i = (ImageView) findViewById(R.id.simg);

        b1=(Button)findViewById(R.id.stdlogout);

        p = new DbHelper(this);
        p.getWritableDatabase();
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                Log.d("name",s1);
                Cursor cur = p.search(s1);
                if (cur.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();
                } else {
                    while (cur.moveToNext()) {

                        s1=cur.getString(2);
                        s2 = cur.getString(3);
                        s3 = cur.getString(4);

                        t0.setVisibility(View.VISIBLE);
                        e0.setVisibility(View.VISIBLE);
                        e0.setText(s3);
                        t1.setVisibility(View.VISIBLE);
                        e2.setVisibility(View.VISIBLE);
                        e2.setText(s1);
                        t2.setVisibility(View.VISIBLE);
                        e3.setVisibility(View.VISIBLE);
                        e3.setText(s2);

                        b1.setVisibility(View.VISIBLE);


                    }
                }

            }
        });
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SharedPreferences.Editor obj=getSharedPreferences("LOGOUT",MODE_PRIVATE).edit();
               obj.clear();
               obj.apply();
               Intent j=new Intent(getApplicationContext(),MainLogin.class);
               startActivity(j);
           }
       });
    }
}
