package com.example.dailynote10117003.CRUD;

//6-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.dailynote10117003.IView.IDatatView;
import com.example.dailynote10117003.R;

public class CreateDialog extends AppCompatDialogFragment {

    private EditText editTextName;
    private EditText editTextTime;
    private EditText editTextCatatan;

    private IDatatView iDatatView;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Insert Notes")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String name = editTextName.getText().toString();
                        String time = editTextTime.getText().toString();
                        String catatan = editTextCatatan.getText().toString();
                        iDatatView.createStudent(name, time, catatan);
                    }
                });

        editTextName = view.findViewById(R.id.edit_name);
        editTextTime = view.findViewById(R.id.edit_time);
        editTextCatatan = view.findViewById(R.id.edit_catatan);

        return builder.create();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            iDatatView = (IDatatView) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + "should implements Interface IView");
        }
    }


}
