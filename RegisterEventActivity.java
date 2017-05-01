package com.example.senac.loginwithdatabase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.senac.loginwithdatabase.BaseMainActivity;
import com.example.senac.loginwithdatabase.R;

public class RegisterEventActivity extends BaseMainActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_event);

    }

    @Override
    protected String setActivityTitle()
    {
        return "Cadastro de Evento";
    }

    @Override
    protected int getActivityMenuId ()
    {
        return R.id.nav_register;
    }
}
