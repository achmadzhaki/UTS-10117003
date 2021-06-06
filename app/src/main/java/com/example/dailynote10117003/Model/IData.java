package com.example.dailynote10117003.Model;

//6-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.content.ContentValues;
import android.database.Cursor;

public interface IData {
    Cursor getAllStudent();
    void createStudent(ContentValues values);
    Cursor getStudent(Long id);
    void updateStudent(ContentValues values, long id);
    void deleteStudent(long id);
}
