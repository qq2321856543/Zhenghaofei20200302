package com.example.zhenghaofei20200302.base;

import java.lang.ref.WeakReference;
/**
 * Zhenghaofei20200302
 * BasePresenter
 */
public abstract class BasePresenter<V extends IBaseView>  {

    private WeakReference<V> vWeakReference;

    public BasePresenter(V v) {
        vWeakReference = new WeakReference<>(v);
        getModel();
    }

    protected abstract void getModel();
    public V getView(){
        if (vWeakReference!=null){
            return vWeakReference.get();
        }
        return null;
    }
//    public void initDestory(){
//        if (vWeakReference!=null){
//            vWeakReference.clear();
//            vWeakReference=null;
//        }
//    }
}
