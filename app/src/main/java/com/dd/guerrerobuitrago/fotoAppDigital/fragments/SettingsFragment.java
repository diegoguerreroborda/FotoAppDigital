package com.dd.guerrerobuitrago.fotoAppDigital.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dd.guerrerobuitrago.fotoAppDigital.LogIn;
import com.dd.guerrerobuitrago.fotoAppDigital.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private Button btnEdit;
    private Button btnServices;
    private Button btnBoughts;
    private Button btnCloseSession;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View settingsView = inflater.inflate(R.layout.fragment_settings, container, false);
        init(settingsView);
        return inflater.inflate(R.layout.fragment_settings, container, false);

    }

    private void init(View view) {
        btnEdit = view.findViewById(R.id.btn_edit_user);
        btnBoughts = view.findViewById(R.id.btn_bought_user);
        btnServices = view.findViewById(R.id.btn_services_user);
        btnCloseSession = view.findViewById(R.id.btn_close_session);

        btnCloseSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //closeSession();
            }
        });
    }


    public static SettingsFragment newInstance(){

        Bundle args = new Bundle();

        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    public void closeSession(){
//        Intent loginIntent = new Intent(getBaseContext(), LogIn.class);
//        startActivity(loginIntent);
//    }
}
