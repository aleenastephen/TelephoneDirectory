package com.mca.administrator.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2/12/2019.
 */
public class DbHelper extends SQLiteOpenHelper {
    public static final String dbname="Contact.db";
    public static final String tablename="Directory";
    public static final String col1="id";
    public static final String col2="name";
    public static final String col3="email";
    public static final String col4="mob";
    public static final String col5="username";
    public static final String col6="password";
    public static final String col7="confirm";
    public DbHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+tablename+"("+col1+ " integer primary key autoincrement, "+col2+" text, "+col3+" text, "+col4+" text, "+col5+" text, "+col6+" text, "+col7+" text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="drop table if exists "+tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insert(String name,String email,String mob,String username,String password,String confirm){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,name);
        cv.put(col3,email);
        cv.put(col4,mob);
        cv.put(col5,username);
        cv.put(col6,password);
        cv.put(col7,confirm);
        long status=sqLiteDatabase.insert(tablename,null,cv);
        if(status==-1){
            return false;
        }
        else{
            return true;
        }
    }
}
