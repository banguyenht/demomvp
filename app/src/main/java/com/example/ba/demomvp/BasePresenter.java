package com.example.ba.demomvp;

public interface BasePresenter<T> {
    void setT(T view);
    void onStart();
    //void onStop();
}
