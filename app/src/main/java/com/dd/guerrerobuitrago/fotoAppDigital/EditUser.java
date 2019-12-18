package com.dd.guerrerobuitrago.fotoAppDigital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditUser extends AppCompatActivity {

    private EditText firstNameChange;
    private EditText lastNameChange;
    private EditText passwordChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        init();
    }

    private void init(){
        firstNameChange = findViewById(R.id.et_firstName_change);
        lastNameChange = findViewById(R.id.et_lastName_change);
        passwordChange = findViewById(R.id.et_password_change);

        Bundle bundleFN = getIntent().getExtras();
        if(bundleFN != null){
            firstNameChange.setText(bundleFN.getString("firstName"));
            lastNameChange.setText(bundleFN.getString("lastName"));
            passwordChange.setText(bundleFN.getString("password"));

        }
    }
}