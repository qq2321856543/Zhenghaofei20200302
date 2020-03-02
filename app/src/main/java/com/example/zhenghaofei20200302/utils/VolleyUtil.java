package com.example.zhenghaofei20200302.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zhenghaofei20200302.base.App;

import java.io.UnsupportedEncodingException;
/**
 * Zhenghaofei20200302
 * 工具类
 */
public class VolleyUtil {

    private final RequestQueue queue;

    private VolleyUtil() {
        queue = Volley.newRequestQueue(App.getContext());
    }
    private static class getUtil{
        private static VolleyUtil volleyUtil = new VolleyUtil();
    }
    public static VolleyUtil getVolley(){
        return getUtil.volleyUtil;
    }
    public Boolean isWifi(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }
        return false;
    }
    public void doGet(String url, final Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.getSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    callback.Errey(error.getMessage());
            }
        }
        )
        {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String a;
                try {
                    a = new String(response.data, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    a=new String(response.data);
                }
                return Response.success(a, HttpHeaderParser.parseCacheHeaders(response));
            }
        }
        ;
        queue.add(stringRequest);
    }
    public interface Callback{
        void getSuccess(String json);
        void Errey(String  str);
    }
}
