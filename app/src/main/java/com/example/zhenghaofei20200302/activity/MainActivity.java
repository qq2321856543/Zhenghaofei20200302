package com.example.zhenghaofei20200302.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhenghaofei20200302.R;
import com.example.zhenghaofei20200302.adapter.RxxAdapter;
import com.example.zhenghaofei20200302.adapter.RxxxAdapter;
import com.example.zhenghaofei20200302.adapter.RxxxxAdapter;
import com.example.zhenghaofei20200302.base.BaseActivity;
import com.example.zhenghaofei20200302.base.BasePresenter;
import com.example.zhenghaofei20200302.bean.JsonBean;
import com.example.zhenghaofei20200302.contert.IHomeContert;
import com.example.zhenghaofei20200302.presenter.HomePresenter;
import com.example.zhenghaofei20200302.utils.VolleyUtil;
import com.google.gson.Gson;

import java.util.List;

/**
 * Zhenghaofei20200302
 * 主类
 */
public class MainActivity extends BaseActivity implements IHomeContert.IView {


    private RecyclerView rv1;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private ImageView iivv;

    @Override
    protected BasePresenter initPresenter() {
        //return new HomePresenter(this);
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //获取控件
        rv1 = findViewById(R.id.rv1);
        rv2 = findViewById(R.id.rv2);
        rv3 = findViewById(R.id.rv3);
        iivv = findViewById(R.id.iivv);
    }

    @Override
    protected void initData() {
        HomePresenter homePresenter = new HomePresenter(this);
        String url="http://blog.zhaoliang5156.cn/api/shop/jingdong.json";

        Boolean wifi = VolleyUtil.getVolley().isWifi(this);
        //判断网络
        if (wifi){
            homePresenter.initJson(url);
        }else {

            iivv.setImageResource(R.mipmap.gou);
        }
//        BasePresenter presenter = getPresenter();
//        if (presenter!=null && presenter instanceof IHomeContert.IPresenter){
//            IHomeContert.IPresenter ipresenter=(IHomeContert.IPresenter) presenter;
//            ipresenter.initJson(url);
//        }else {
//            Log.i("xxx","不");
//        }
    }

    @Override
    public void getSuccess(String json) {//设置数据
        Log.i("xxx",""+json);

        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
        JsonBean.DataBean data = jsonBean.getData();
        List<JsonBean.DataBean.HorizontalListDataBean> horizontalListData = data.getHorizontalListData();

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rv1.setLayoutManager(layoutManager);
        RxxAdapter rxxAdapter = new RxxAdapter(this, horizontalListData);
        rv1.setAdapter(rxxAdapter);

        List<JsonBean.DataBean.VerticalListDataBean> verticalListData = data.getVerticalListData();
        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv2.setLayoutManager(layoutManager1);
        RxxxAdapter rxxxAdapter = new RxxxAdapter(this, verticalListData);
        rv2.setAdapter(rxxxAdapter);

        List<JsonBean.DataBean.GridDataBean> gridData = data.getGridData();
        RecyclerView.LayoutManager layoutManager2=new GridLayoutManager(this,2);
        rv3.setLayoutManager(layoutManager2);
        RxxxxAdapter rxxxxAdapter = new RxxxxAdapter(this, gridData);
        rv3.setAdapter(rxxxxAdapter);

    }

    @Override
    public void getErrey(String str) {
        Log.i("xxx",""+str);
    }
}
