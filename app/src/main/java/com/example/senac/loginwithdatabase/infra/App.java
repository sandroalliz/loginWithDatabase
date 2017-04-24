package com.example.senac.loginwithdatabase.infra;

import android.app.Application;

import com.example.senac.loginwithdatabase.Domain.User;

/**
 * Created by re033994 on 20/04/2017.
 */

public class App extends Application {

    private static App instance;

    @Override public void onCreate()
    {
        super.onCreate();

        instance = this;

    }

    public static void saveSession(User user)
    {
        new LocalStoreManager().put( AppConstants.NAME, user.getName() );
        new LocalStoreManager().put( AppConstants.EMAIL, user.getEmail());
    }

    public static User getUserSession()
    {
        User user = new User();
        LocalStoreManager localStoreManager = new LocalStoreManager();


        user.setName(localStoreManager.get( AppConstants.NAME, String.class ));
        user.setEmail(localStoreManager.get( AppConstants.EMAIL, String.class ));

        return user;
    }

    public static synchronized App getContext() {
        return instance;
    }
}
