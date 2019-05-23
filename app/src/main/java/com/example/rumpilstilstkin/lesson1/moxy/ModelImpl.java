package com.example.rumpilstilstkin.lesson1.moxy;


import java.util.ArrayList;
import java.util.List;


public class ModelImpl implements Model {
    private List<Integer> mList;

    ModelImpl() {
        mList = new ArrayList<>(3);
        mList.add(0);
        mList.add(0);
        mList.add(0);
    }

    @Override
    public int getElementValueAtIndex(int _index) {
        return mList.get(_index);
    }

    @Override
    public void setElementValueAtIndex(int _index, int value) {
        mList.set(_index, value);
    }
}