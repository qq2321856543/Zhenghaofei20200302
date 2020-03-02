package com.example.zhenghaofei20200302.model;

import com.example.zhenghaofei20200302.contert.IHomeContert;
import com.example.zhenghaofei20200302.utils.VolleyUtil;
/**
 * Zhenghaofei20200302
 * M层
 */
public class HomeModel implements IHomeContert.IModel {
    @Override
    public void getJson(String url, final Callback callback) {
        VolleyUtil.getVolley().doGet(url, new VolleyUtil.Callback() {
            @Override
            public void getSuccess(String json) {
                callback.getSuccess(json);
            }

            @Override
            public void Errey(String str) {
                callback.getErrey(str);
            }
        });
    }
}
