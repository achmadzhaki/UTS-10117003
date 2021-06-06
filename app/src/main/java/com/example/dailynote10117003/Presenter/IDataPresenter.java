package com.example.dailynote10117003.Presenter;

//6-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.content.ContentValues;

public interface IDataPresenter {
    void getAllStudent();
    void createStudent(ContentValues values);
    void getStudent(long id);
    void updateStudent(ContentValues values, long id);
    void deleteStudent(long id);
}
