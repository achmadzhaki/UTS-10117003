package com.example.dailynote10117003.Presenter;

//6-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.content.ContentValues;
import android.database.Cursor;

import com.example.dailynote10117003.IView.IEditDataView;
import com.example.dailynote10117003.IView.IDatatView;
import com.example.dailynote10117003.Model.IData;
import com.example.dailynote10117003.Model.DataModel;

public class DataPresenter implements IDataPresenter {

    private IData iDataModel;
    private IDatatView iDatatView;
    private IEditDataView iEditDataView;

    public DataPresenter(IDatatView iDatatView) {
        this.iDatatView = iDatatView;
        iDataModel = new DataModel(iDatatView);
    }

    public DataPresenter(IEditDataView iEditDataView) {
        this.iEditDataView = iEditDataView;
        iDataModel = new DataModel(iEditDataView);
    }


    @Override
    public void getAllStudent() {
        Cursor cursor = iDataModel.getAllStudent();
        iDatatView.listStudent(cursor);
    }

    @Override
    public void createStudent(ContentValues values) {
        iDataModel.createStudent(values);
    }

    @Override
    public void getStudent(long id) {
        Cursor cursor = iDataModel.getStudent(id);
        iEditDataView.getStudent(cursor);
    }

    @Override
    public void updateStudent(ContentValues values, long id) {
        iDataModel.updateStudent(values, id);
    }

    @Override
    public void deleteStudent(long id) {
        iDataModel.deleteStudent(id);
    }
}
