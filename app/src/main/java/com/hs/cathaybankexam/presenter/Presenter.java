package com.hs.cathaybankexam.presenter;

public abstract class Presenter<T> {

    public abstract void destroy();

    public abstract boolean isViewAttached();

    public abstract T getView();
}
