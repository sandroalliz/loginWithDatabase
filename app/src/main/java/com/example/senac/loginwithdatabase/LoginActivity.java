package com.example.senac.loginwithdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvCreate;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadComponents();
    }


    private void loadComponents() {
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvCreate = (TextView) findViewById(R.id.tvCreate);
        databaseHelper = new DatabaseHelper(getApplicationContext());

        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (databaseHelper.checkUser(edtEmail.getText().toString().trim()
                        , edtPassword.getText().toString().trim())) {

                    Toast toast = Toast.makeText(getApplicationContext(), "Login efetuado!!", Toast.LENGTH_SHORT);
                    toast.show();


                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Dados inválidos!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
