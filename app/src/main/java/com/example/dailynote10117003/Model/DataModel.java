package com.example.dailynote10117003.Model;

//6-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dailynote10117003.BD.DBHelper;
import com.example.dailynote10117003.IView.IEditDataView;
import com.example.dailynote10117003.IView.IDatatView;

public class DataModel implements IData {

    private SQLiteDatabase db;

    public DataModel(IEditDataView iStudentView) {
        db = new DBHelper( (Context)iStudentView).getWritableDatabase();
    }

    public DataModel(IDatatView iEditStudentView) {
        db = new DBHelper( (Context) iEditStudentView).getWritableDatabase();
    }

    @Override
    public Cursor getAllStudent() {
        // Cursor cursor = getAllStudent();
        // return cursor;

        Cursor cursor = db.rawQuery("SELECT * FROM " + DBHelper.table_name + " ORDER BY " + DBHelper.row_id + " DESC ", null );
        return  cursor;
    }

    @Override
    public void createStudent(ContentValues values) {
        db.insert(DBHelper.table_name, null, values);
    }

    @Override
    public Cursor getStudent(Long id) {
        System.out.println("Id en model " + id);
        Cursor cur = db.rawQuery("SELECT * FROM " + DBHelper.table_name + " WHERE " + DBHelper.row_id + " = " + id, null);
        return cur;
    }

    @Override
    public void updateStudent(ContentValues values, long id) {
        db.update(DBHelper.table_name, values, DBHelper.row_id + " = " + id, null);
    }

    @Override
    public void deleteStudent(long id) {
        db.delete(DBHelper.table_name, DBHelper.row_id + " = " + id, null);
    }


}
