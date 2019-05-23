package com.example.rumpilstilstkin.lesson1.moxy;

import com.arellomobile.mvp.MvpView;

interface MoxyView extends MvpView {
    void showValueFirst(int value);
    void showValueSecond(int value);
    void showValueThird(int value);
}