package com.example.zhenghaofei20200302.contert;

import com.example.zhenghaofei20200302.base.IBaseView;
/**
 * Zhenghaofei20200302
 * 契约类
 */
public interface IHomeContert {
    interface IView extends IBaseView{
        void getSuccess(String json);
        void getErrey(String str);
    }
    interface IPresenter{
        void initJson(String url);
    }
    interface IModel{
        void getJson(String url,Callback callback);
        interface Callback{
            void getSuccess(String json);
            void getErrey(String str);
        }
    }
}
