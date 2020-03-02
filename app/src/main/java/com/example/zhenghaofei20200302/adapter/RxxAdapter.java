package com.example.zhenghaofei20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.zhenghaofei20200302.R;
import com.example.zhenghaofei20200302.bean.JsonBean;

import java.util.List;
/**
 * Zhenghaofei20200302
 * 适配器
 */
public class RxxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
          Context context;
           List<JsonBean.DataBean.HorizontalListDataBean> list;

    public RxxAdapter(Context context, List<JsonBean.DataBean.HorizontalListDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item1, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        JsonBean.DataBean.HorizontalListDataBean horizontalListDataBean = list.get(i);
        String imageurl = horizontalListDataBean.getImageurl();
        Glide.with(context).load(imageurl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).priority(Priority.HIGH).into(((ViewHolder)viewHolder).iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
