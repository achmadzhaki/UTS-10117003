package com.example.dailynote10117003;

//7-Juni-2021. Achmad Zhaki - 10117003 - IF8

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dailynote10117003.BD.DBHelper;
import com.example.dailynote10117003.IView.IEditDataView;
import com.example.dailynote10117003.Presenter.IDataPresenter;
import com.example.dailynote10117003.Presenter.DataPresenter;

public class EditActivity extends AppCompatActivity implements IEditDataView {

    private IDataPresenter iDataPresenter;
    long id;
    DBHelper helper;
    EditText txtName, txtTime, txtCatatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        helper = new DBHelper(this);
        id = getIntent().getLongExtra(DBHelper.row_id, 0);

        txtName = (EditText) findViewById(R.id.txtName_Edit);
        txtTime = (EditText) findViewById(R.id.txtTime_Edit);
        txtCatatan = (EditText) findViewById(R.id.txtCatatan_Edit);

        iDataPresenter = new DataPresenter(this);
        iDataPresenter.getStudent(id);

    }


    @Override
    public void getStudent(Cursor cursor) {
        if (cursor.moveToNext()) {
            txtName.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_name)));
            txtTime.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_time)));
            txtCatatan.setText(cursor.getString(cursor.getColumnIndex(DBHelper.row_catatan)));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.save_edit:
                String name = txtName.getText().toString().trim();
                String time = txtTime.getText().toString().trim();
                String catatan = txtCatatan.getText().toString().trim();

                if (name.length() > 0 & time.length() > 0 & catatan.length() >0) {

                    ContentValues values = new ContentValues();
                    values.put(DBHelper.row_name, name);
                    values.put(DBHelper.row_time, time);
                    values.put(DBHelper.row_catatan, catatan);

                    iDataPresenter.updateStudent(values, id);
                    Toast.makeText(EditActivity.this, "Successful Edited", Toast.LENGTH_SHORT).show();
                    finish();

                } else {
                    Toast.makeText(EditActivity.this, "Something went wrong on Edited", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.delete_edit:
                AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
                builder.setMessage("You want to deleted this");
                builder.setCancelable(true);
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        iDataPresenter.deleteStudent(id);
                        Toast.makeText(EditActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}