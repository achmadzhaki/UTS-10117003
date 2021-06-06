package com.example.dailynote10117003.BD;

//6-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public static final String database_name = "db_notes";
    public static final String table_name = "notes";

    public static final String row_id = "_id";
    public static final String row_name = "name";
    public static final String row_time = "time";
    public static final String row_catatan = "catatan";



    public DBHelper(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_name + " ( " + row_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + row_name + " TEXT, " + row_time + " TEXT, " + row_catatan + " TEXT)";
        db.execSQL(query);
        db.execSQL("insert into notes(name, time, catatan) values('Ucup', '25-01-2000', 'Halo Gais Ini Aplikasi Saya')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }






}
