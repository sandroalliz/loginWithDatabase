package com.example.senac.loginwithdatabase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.senac.loginwithdatabase.BaseMainActivity;
import com.example.senac.loginwithdatabase.R;

public class HomeActivity extends BaseMainActivity {

    TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    @Override
    protected String setActivityTitle()
    {
        return "Get Food";
    }

    @Override
    protected int getActivityMenuId ()
    {
        return R.id.nav_home;
    }

}
