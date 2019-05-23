package com.example.rumpilstilstkin.lesson1.moxy;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.rumpilstilstkin.lesson1.R;

import java.text.MessageFormat;


public class MoxyMainActivity extends MvpAppCompatActivity
        implements MoxyView, View.OnClickListener {

    @InjectPresenter
    Presenter presenter;

    @ProvidePresenter
    Presenter getPresenter() {
        return new Presenter(new ModelImpl());
    }

    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        btnCounter1 = findViewById(R.id.btnCounter1);
        btnCounter2 = findViewById(R.id.btnCounter2);
        btnCounter3 = findViewById(R.id.btnCounter3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCounter1: {
                presenter.changeValueFirst();
                break;
            }
            case R.id.btnCounter2: {
                presenter.changeValueSecond();
                break;
            }
            case R.id.btnCounter3: {
                presenter.changeValueThird();
                break;
            }
        }
    }

    @Override
    public void showValueFirst(int value) {
        btnCounter1.setText(MessageFormat.format("{0} = {1}", getString(R.string.quantity), value));
    }

    @Override
    public void showValueSecond(int value) {
        btnCounter2.setText(MessageFormat.format("{0} = {1}", getString(R.string.quantity), value));
    }

    @Override
    public void showValueThird(int value) {
        btnCounter3.setText(MessageFormat.format("{0} = {1}", getString(R.string.quantity), value));
    }
}