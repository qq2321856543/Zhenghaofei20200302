package com.example.zhenghaofei20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.zhenghaofei20200302.R;
import com.example.zhenghaofei20200302.bean.JsonBean;

import java.util.List;
/**
 * Zhenghaofei20200302
 * 适配器
 */
public class RxxxxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
          Context context;
           List<JsonBean.DataBean.GridDataBean> list;

    public RxxxxAdapter(Context context, List<JsonBean.DataBean.GridDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item3, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        JsonBean.DataBean.GridDataBean gridDataBean = list.get(i);
        String imageurl = gridDataBean.getImageurl();
        String price = gridDataBean.getPrice();
        String title = gridDataBean.getTitle();

        Glide.with(context).load(imageurl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).priority(Priority.HIGH).into(((ViewHolder)viewHolder).iv);
        ((ViewHolder)viewHolder).tv1.setText(title);
        ((ViewHolder)viewHolder).tv2.setText("$"+price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv1;
        private final TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
