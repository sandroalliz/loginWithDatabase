package com.example.senac.loginwithdatabase;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.senac.loginwithdatabase.Activity.EventActivity;
import com.example.senac.loginwithdatabase.Activity.HomeActivity;
import com.example.senac.loginwithdatabase.Activity.MyEventsActivity;
import com.example.senac.loginwithdatabase.Activity.RegisterEventActivity;
import com.example.senac.loginwithdatabase.Domain.User;
import com.example.senac.loginwithdatabase.infra.App;

public abstract class BaseMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseMainContract.View
{
    Toolbar toolbar;
    TextView tvNick;
    DrawerLayout fullLayout;
    NavigationView navigationView;
    BaseMainContract.Presenter mPresenter;

    private Context context;

    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        context = this;
        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base_main, null);

        FrameLayout activityContainer = (FrameLayout) fullLayout.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        super.setContentView(fullLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);


        if (useToolbar())
        {
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(useHomeAsBack());
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            updateActivityTitle();

            if (useHelpToolbarBackground())
            {
                getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(context,R.color.dark_turquoise));
                ((TextView)toolbar.findViewById(R.id.toolbar_title)).setTextColor(ContextCompat.getColor(context,R.color.white));
            }
        }
        else
        {
            toolbar.setVisibility(View.GONE);
        }

        //setup navview
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        if (!enableDrawer())
        {
            fullLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }

        if (!useHomeAsBack())
        {
            //setup drawer toogle
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, fullLayout, toolbar,
                    R.string.nav_drawer_opened,
                    R.string.nav_drawer_closed);

            // Tie DrawerLayout events to the ActionBarToggle
            fullLayout.addDrawerListener(drawerToggle);
            updateDrawerSelectedItem();
            drawerToggle.syncState();
        }

        updateNickname();
        mPresenter = new BaseMainPresenter(this);
    }

    private void updateNickname() {
        tvNick = (TextView) findViewById(R.id.tvNick);

        User user = App.getUserSession();

        tvNick.setText(user.getName());
    }


    protected boolean useHelpToolbarBackground ()
    {
        return false;
    }

    private void updateDrawerSelectedItem ()
    {
        int id = getActivityMenuId();

        if (id >= 0)
        {
            navigationView.setCheckedItem(id);
        }
    }

    protected int getActivityMenuId ()
    {
        return -1;
    }

    protected boolean enableDrawer ()
    {
        return true;
    }

    protected boolean useHomeAsBack ()
    {
        return false;
    }

    protected boolean useToolbar()
    {
        return true;
    }

    protected String setActivityTitle()
    {
        return "";
    }

    protected void updateActivityTitle()
    {
        ((TextView)toolbar.findViewById(R.id.toolbar_title)).setText(setActivityTitle());
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id)
        {

            case R.id.nav_home:
            {

                if (!(this instanceof HomeActivity))
                {
                    startHomeActivity();
                }
                break;
            }
            case R.id.nav_event:
            {
                if (!(this instanceof EventActivity))
                {
                    startEventActivity();
                }
                break;
            }
            case R.id.nav_myEvents:
            {
                if (!(this instanceof MyEventsActivity))
                {
                    startMyEventsActivity();
                }
                break;
            }
            case R.id.nav_register:
            {
                if (!(this instanceof RegisterEventActivity))
                {
                    startRegisterEventActivity();
                }
                break;
            }
            }
        
        return false;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id)
        {
            case android.R.id.home:
            {
                if (useHomeAsBack())
                {
                    onBackPressed();
                    return true;
                }
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed ()
    {
        if (fullLayout.isDrawerOpen(GravityCompat.START))
        {
            fullLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }


    public void startHomeActivity()
    {
        startActivity(new Intent(this, HomeActivity.class));
    }


    public void startEventActivity ()
    {

        startActivity(new Intent(this, EventActivity.class));
    }


    public void startMyEventsActivity ()
    {
        startActivity(new Intent(this, MyEventsActivity.class));
    }


    public void startRegisterEventActivity ()
    {
        startActivity(new Intent(this, RegisterEventActivity.class));
    }

}
