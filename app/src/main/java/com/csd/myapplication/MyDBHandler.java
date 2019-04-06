package com.csd.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.csd.myapplication.models.MyItem;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final String TABLE_MYITEMS = "myItems";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "_title";
    public static final String COLUMN_SUBTITLE = "_subTitle";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myItems.db";

    public MyDBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_MYITEMS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_TITLE + " TEXT ," +
                COLUMN_SUBTITLE + " TEXT " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MYITEMS);
        onCreate(db);
    }

    public void addMyItem(MyItem myItem) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, myItem.getTitle());
        values.put(COLUMN_SUBTITLE, myItem.getSubTitle());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_MYITEMS, null, values);
        db.close();
    }

    public Cursor getMyItem() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_MYITEMS, null);
    }
}
