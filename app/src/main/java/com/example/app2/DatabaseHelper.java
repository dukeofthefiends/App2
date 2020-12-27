package com.example.app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME;

    static {
        DATABASE_NAME = "Order";
    }

    public static final String ID = "ID";
    public static final String TIME = "time";
    public static final String SUM = "SUM";
    public static final String AMOUNT = "AMOUNT";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
  //      db.execSQL(TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  db.execSQL(TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData (String id, String time, String sum, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(TIME, time);
        contentValues.put(SUM, sum);
        contentValues.put(AMOUNT, amount);
        long result = db.insert(DATABASE_NAME, null, contentValues);
        if(result == -1) {
            return false;
        } else
            return true;
    }

    public boolean updateData(String id, String time, String sum, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(TIME, time);
        contentValues.put(SUM, sum);
        contentValues.put(AMOUNT, amount);
        db.update(DATABASE_NAME, contentValues, "ID = ?", new String[]{id});
        return  true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(  DATABASE_NAME , null);
        return res;
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(DATABASE_NAME, "ID = ?", new String[]{id});
    }

}
