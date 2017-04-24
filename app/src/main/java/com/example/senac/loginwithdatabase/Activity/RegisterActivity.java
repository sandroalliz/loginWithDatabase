package com.example.senac.loginwithdatabase.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senac.loginwithdatabase.Database.DatabaseHelper;
import com.example.senac.loginwithdatabase.R;
import com.example.senac.loginwithdatabase.Domain.User;
import com.example.senac.loginwithdatabase.infra.App;

public class RegisterActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private EditText edtRegEmail;
    private EditText edtPass;
    private EditText edtConfPass;
    private Button btnCreate;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loadComponents();
    }

    private void loadComponents() {
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtRegEmail = (EditText) findViewById(R.id.edtRegEmail);
        edtConfPass = (EditText) findViewById(R.id.edtConfPass);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        user = new User();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!databaseHelper.checkUser(edtRegEmail.getText().toString().trim())) {

                    user.setEmail(edtRegEmail.getText().toString().trim());
                    user.setPassword(edtPass.getText().toString().trim());

                    databaseHelper.addUser(user);
                    App.saveSession(user);

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);

                    Toast toast = Toast.makeText(getApplicationContext(), "Usuario criado com sucesso!", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Dados inválidos", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });


    }
}
