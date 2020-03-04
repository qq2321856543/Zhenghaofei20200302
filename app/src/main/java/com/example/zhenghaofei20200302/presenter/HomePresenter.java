package com.example.zhenghaofei20200302.presenter;

import android.util.Log;

import com.example.zhenghaofei20200302.base.BasePresenter;
import com.example.zhenghaofei20200302.base.IBaseView;
import com.example.zhenghaofei20200302.contert.IHomeContert;
import com.example.zhenghaofei20200302.model.HomeModel;
/**
 * Zhenghaofei20200302
 * p层
 */
public class HomePresenter extends BasePresenter implements IHomeContert.IPresenter {

    private HomeModel model;

    public HomePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void getModel() {
        model = new HomeModel();
    }

    @Override
    public void initJson(String url) {
        model.getJson(url, new IHomeContert.IModel.Callback() {
            @Override
            public void getSuccess(String json) {
                IBaseView view = getView();
                if (view !=null && view instanceof IHomeContert.IView){
                    Log.i("xxx",""+json);
                    IHomeContert.IView iView=(IHomeContert.IView) view;
                    iView.getSuccess(json);
                }
            }

            @Override
            public void getErrey(String str) {
                IBaseView view = getView();
                if (view !=null && view instanceof IHomeContert.IView){
                    IHomeContert.IView iView=(IHomeContert.IView) view;
                    iView.getErrey(str);
                }
            }
        });
    }

    @Override
    public void initSousuo(String url) {
        Log.i("ooo","P层");

        model.getJson(url, new IHomeContert.IModel.Callback() {
            @Override
            public void getSuccess(String json) {
                IBaseView view = getView();
                if (view !=null && view instanceof IHomeContert.IView){
                    IHomeContert.IView iView=(IHomeContert.IView) view;
                    iView.getSousuo(json);
                }
            }

            @Override
            public void getErrey(String str) {

            }
        });
    }
}
