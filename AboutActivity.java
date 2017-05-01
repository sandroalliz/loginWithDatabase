package com.example.senac.loginwithdatabase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.senac.loginwithdatabase.BaseMainActivity;
import com.example.senac.loginwithdatabase.R;

public class AboutActivity extends BaseMainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }

    @Override
    protected String setActivityTitle()
    {
        return "Sobre Nós";
    }

    @Override
    protected int getActivityMenuId ()
    {
        return R.id.nav_about;
    }
}
