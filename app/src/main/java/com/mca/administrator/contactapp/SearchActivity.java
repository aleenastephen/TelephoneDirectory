package com.mca.administrator.contactapp;

import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
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
    EditText e,e1,e2,e0,a1,a2,a3;
    String s,s1,s2,s0,s3,s4,s5,u1,u2,u3,u4,u5,u6,getid;
    Button b1,b2;
    TextView t1,t2,t0,t3,t4,t5;
    DbHelper p;
    AlertDialog.Builder build;

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
        e0 = (EditText) findViewById(R.id.tna);
        e1 = (EditText) findViewById(R.id.tem);
        e2 = (EditText) findViewById(R.id.tmo);
       a1 = (EditText) findViewById(R.id.tre);
       a2 = (EditText) findViewById(R.id.tpa);
        a3 = (EditText) findViewById(R.id.tcpa);


        t0=(TextView)findViewById(R.id.tnam);
        t1=(TextView)findViewById(R.id.temail);
        t2=(TextView)findViewById(R.id.tmob);
        t3=(TextView)findViewById(R.id.treg);
        t4=(TextView)findViewById(R.id.tpas);
        t5=(TextView)findViewById(R.id.tcpass);

        b1=(Button) findViewById(R.id.supdate);
        b2=(Button) findViewById(R.id.sdelete);

        build=new AlertDialog.Builder(this);
        build.setTitle("Confirm");
        build.setMessage("Are you sure to want to delete?");
        build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean status = p.Delete(getid);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();
                }
                dialogInterface.dismiss();
            }
        });
        build.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Not clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });

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
                        getid=cur.getString(0);
                        s0 = cur.getString(1);
                        s1 = cur.getString(2);
                        s2 = cur.getString(3);
                       s3 = cur.getString(4);
                       s4 = cur.getString(5);
                       s5 = cur.getString(6);

                        t0.setVisibility(View.VISIBLE);
                        e0.setVisibility(View.VISIBLE);
                        e0.setText(s0);
                        t1.setVisibility(View.VISIBLE);
                        e1.setVisibility(View.VISIBLE);
                        e1.setText(s1);
                        t2.setVisibility(View.VISIBLE);
                        e2.setVisibility(View.VISIBLE);
                        e2.setText(s2);

                        t3.setVisibility(View.VISIBLE);
                        a1.setVisibility(View.VISIBLE);
                        a1.setText(s3);
                        t4.setVisibility(View.VISIBLE);
                        a2.setVisibility(View.VISIBLE);
                        a2.setText(s4);
                        t5.setVisibility(View.VISIBLE);
                        a3.setVisibility(View.VISIBLE);
                        a3.setText(s5);


                        b1.setVisibility(View.VISIBLE);
                        b2.setVisibility(View.VISIBLE);


                    }
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u1=e.getText().toString();
                u2=e1.getText().toString();
                u3=e2.getText().toString();
                u4=a1.getText().toString();
                u5=a2.getText().toString();
                u6=a3.getText().toString();
                boolean result=p.updateData(getid,u1,u2,u3);
                if(result == true){
                    Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert=build.create();
                alert.show();
            }
        });
    }
}