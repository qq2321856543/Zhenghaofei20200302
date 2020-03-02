package com.example.zhenghaofei20200302.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zhenghaofei20200302.R;
/**
 * Zhenghaofei20200302
 * BaseActivity
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
        presenter = initPresenter();
    }
    public P getPresenter(){
        return presenter;
    }

    protected abstract P initPresenter();

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (presenter!=null){
//            presenter.initDestory();
//            presenter=null;
//        }
//
//    }
}
