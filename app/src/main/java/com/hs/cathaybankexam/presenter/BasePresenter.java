package com.hs.cathaybankexam.presenter;

import java.lang.ref.WeakReference;

public class BasePresenter<T> extends Presenter<T> {

    private WeakReference<T> mViewRef;

    public BasePresenter(T view) {
        mViewRef = new WeakReference<>(view);
    }

    @Override
    public void destroy() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    @Override
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @Override
    public T getView() {
        return mViewRef.get();
    }
}
