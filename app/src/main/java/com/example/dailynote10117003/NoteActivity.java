package com.example.dailynote10117003;

//7-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.dailynote10117003.BD.DBHelper;
import com.example.dailynote10117003.CRUD.CreateDialog;
import com.example.dailynote10117003.CRUD.CustomCursorAdapter;
import com.example.dailynote10117003.IView.IDatatView;
import com.example.dailynote10117003.Presenter.IDataPresenter;
import com.example.dailynote10117003.Presenter.DataPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity implements IDatatView, AdapterView.OnItemClickListener {

    private IDataPresenter iDataPresenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(this);
        iDataPresenter = new DataPresenter(this);
        iDataPresenter.getAllStudent();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                CreateDialog createDialog = new CreateDialog();
                createDialog.show(getSupportFragmentManager(), "Create Dialog");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View i;

        i= findViewById(R.id.menuList);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NoteActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void listStudent(Cursor cursor) {
        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this, cursor, 1);
        listView.setAdapter(customCursorAdapter);
    }

    @Override
    public void createStudent(String name, String time, String catatan) {

        if (name.trim().length() > 0 && time.trim().length() > 0 && catatan.trim().length() > 0) {

            ContentValues values = new ContentValues();
            values.put(DBHelper.row_name, name);
            values.put(DBHelper.row_time, time);
            values.put(DBHelper.row_catatan, catatan);

            iDataPresenter.createStudent(values);
            Toast.makeText(NoteActivity.this, "Save", Toast.LENGTH_SHORT).show();
            iDataPresenter.getAllStudent();

        } else {
            Toast.makeText(NoteActivity.this, "Nothing to save", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        TextView listId = (TextView) view.findViewById(R.id.listId);
        final long id = Long.parseLong(listId.getText().toString());
        System.out.println("id " + id);

        Intent editView = new Intent(NoteActivity.this, EditActivity.class);
        editView.putExtra(DBHelper.row_id, id);
        startActivity(editView);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        iDataPresenter.getAllStudent();
    }

}
