package com.example.dailynote10117003.IView;
//6-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.database.Cursor;

public interface IDatatView {

    void listStudent(Cursor cursor);
    void createStudent(String name, String time, String catatan);

}
