package com.example.dailynote10117003.ui.profile;

//5-Juni-2021. Achmad Zhaki - 10117003 - IF8

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.dailynote10117003.R;

public class ProfileFragment extends Fragment {
    private CardView  email;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        email = view.findViewById(R.id.cardEmail);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(Intent.ACTION_VIEW);
                e.setData(Uri.parse("mailto:achmad.zhaki21@gmail.com"));
                e.setType("text/plain");
                startActivity(e);
            }
        });
    }

}