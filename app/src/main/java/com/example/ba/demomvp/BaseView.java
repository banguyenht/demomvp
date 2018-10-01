package com.example.ba.demomvp;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
