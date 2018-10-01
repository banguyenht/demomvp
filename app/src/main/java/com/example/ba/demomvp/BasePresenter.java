package com.example.ba.demomvp;

public interface BasePresenter<T> {
    void setView(T view);
    void onStart();
}
