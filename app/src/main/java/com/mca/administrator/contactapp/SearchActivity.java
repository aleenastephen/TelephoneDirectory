package com.mca.administrator.contactapp;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class SearchActivity extends AppCompatActivity {
    ImageView i;
    EditText e,e1,e2,a1,a2,a3,a4,a5,a6;
    String s, s1, s2, s3,u1,u2,u3,u4,u5,u6,getid;
    Button b1,b2;
    TextView t1,t2;
    DbHelper p;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        e = (EditText) findViewById(R.id.search);
        e1 = (EditText) findViewById(R.id.tem);
        e2 = (EditText) findViewById(R.id.tmo);
        t1=(TextView)findViewById(R.id.temail);
        t2=(TextView)findViewById(R.id.tmob);
        b1=(Button) findViewById(R.id.supdate);
        b2=(Button) findViewById(R.id.sdelete);

        i = (ImageView) findViewById(R.id.img);
        p = new DbHelper(this);
        p.getWritableDatabase();
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = e.getText().toString();
                Log.d("name",s);
                Cursor cur = p.search(s);
                if (cur.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();
                } else {
                    while (cur.moveToNext()) {
                        s1 = cur.getString(2);
                        s2 = cur.getString(3);
                        s3 = cur.getString(4);
                       t1.setVisibility(View.VISIBLE);
                        e1.setVisibility(View.VISIBLE);
                        e1.setText(s1);
                        t2.setVisibility(View.VISIBLE);
                        e2.setVisibility(View.VISIBLE);
                        e2.setText(s2);


                    }
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u1=a1.getText().toString();
                u2=a2.getText().toString();
                u3=a3.getText().toString();
                u4=a4.getText().toString();
                u5=a5.getText().toString();
                u6=a6.getText().toString();
                boolean result=p.updateData(getid,u1,u2,u3,u4,u5,u6);
                if(result== true){
                    Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}