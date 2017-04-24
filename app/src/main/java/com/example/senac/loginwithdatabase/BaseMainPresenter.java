package com.example.senac.loginwithdatabase;

/**
 * Created by jnunes on 21/07/16.
 */
public class BaseMainPresenter implements BaseMainContract.Presenter
{
    private final BaseMainContract.View view;

    public BaseMainPresenter(BaseMainContract.View view)
    {
        this.view = view;
    }

}
