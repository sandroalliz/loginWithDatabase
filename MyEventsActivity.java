package com.example.senac.loginwithdatabase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.senac.loginwithdatabase.BaseMainActivity;
import com.example.senac.loginwithdatabase.R;

public class MyEventsActivity extends BaseMainActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

    }

    @Override
    protected String setActivityTitle()
    {
        return "Meus Eventos";
    }

    @Override
    protected int getActivityMenuId ()
    {
        return R.id.nav_myEvents;
    }
}
