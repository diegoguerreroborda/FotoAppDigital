package com.dd.guerrerobuitrago.fotoAppDigital.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dd.guerrerobuitrago.fotoAppDigital.EditUser;
import com.dd.guerrerobuitrago.fotoAppDigital.LogIn;
import com.dd.guerrerobuitrago.fotoAppDigital.R;
import com.dd.guerrerobuitrago.fotoAppDigital.models.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private Button btnEdit;
    private Button btnServices;
    private Button btnBoughts;
    private Button btnCloseSession;
    private EditText txtNameUser;

    private String firstName;
    private String lastName;
    private String password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        btnEdit = view.findViewById(R.id.btn_edit_user);
        txtNameUser = view.findViewById(R.id.txt_name_user);
        Bundle bun = getArguments();
        firstName = bun.getString("firstName");
        lastName = bun.getString("lastName");
        password = bun.getString("password");
        txtNameUser.setText(firstName + " " + lastName);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUser();
            }
        });
        btnBoughts = view.findViewById(R.id.btn_bought_user);
        btnServices = view.findViewById(R.id.btn_services_user);
        btnCloseSession = view.findViewById(R.id.btn_close_session);

        btnCloseSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSession();
            }
        });
    }

    public void editUser(){
        Intent editUserIntent = new Intent(getActivity(), EditUser.class);
        editUserIntent.putExtra("firstName", firstName);
        editUserIntent.putExtra("lastName", lastName);
        editUserIntent.putExtra("password", password);
        startActivity(editUserIntent);
    }

    public void closeSession(){
        Intent loginIntent = new Intent(getActivity(), LogIn.class);
        startActivity(loginIntent);
    }

    public static SettingsFragment newInstance(String firstName, String lastName, String password){
        Bundle args = new Bundle();
        args.putString("firstName", firstName);
        args.putString("lastName", lastName);
        args.putString("password", password);
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}