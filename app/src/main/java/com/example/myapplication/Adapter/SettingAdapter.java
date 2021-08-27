package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.View;

import com.example.myapplication.Bean.LogInBean;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerviewUtil.BaseRecyclerAdapter;
import com.example.myapplication.RecyclerviewUtil.BaseRecyclerHolder;
import com.example.myapplication.Util.ImageLoadUtil;

import java.util.List;

/**
 * pengbiwu@Skyworth.com
 * 2021/3/23 11:52
 */
public class SettingAdapter extends BaseRecyclerAdapter<LogInBean.LogInBeanDa> {

    public SettingAdapter(Context context , List<LogInBean.LogInBeanDa>list , int layid){
        super(context,list,layid);
    }
    @Override
    public void convert(final BaseRecyclerHolder holder,final LogInBean.LogInBeanDa item,
                        int position, boolean isScrolling) {

        holder.setText(R.id.tex,item.getName());
        switch (item.getType()%2){
            case 1:
                holder.getView(R.id.img).setVisibility(View.VISIBLE);
                holder.getView(R.id.context_tex).setVisibility(View.GONE);
                setImg(holder,item);
                break;
            case 2:
                holder.setText(R.id.context_tex,item.getName());
                holder.getView(R.id.img).setVisibility(View.GONE);
                holder.getView(R.id.context_tex).setVisibility(View.VISIBLE);
                break;
        }


    }
    private void setImg(BaseRecyclerHolder holder, LogInBean.LogInBeanDa item){

        switch (item.getImagId()){
            case 0:
                ImageLoadUtil.ImageLoad(context,R.mipmap.a1,holder.getView(R.id.img));
                break;
            case 1:
                ImageLoadUtil.ImageLoad(context,R.mipmap.a2,holder.getView(R.id.img));
                break;
            case 2:
                ImageLoadUtil.ImageLoad(context,R.mipmap.a3,holder.getView(R.id.img));
                break;
            case 3:
                ImageLoadUtil.ImageLoad(context,R.mipmap.a4,holder.getView(R.id.img));
                break;
            case 4:
                ImageLoadUtil.ImageLoad(context,R.mipmap.a5,holder.getView(R.id.img));
                break;
            case 5:
                ImageLoadUtil.ImageLoad(context,R.mipmap.a6,holder.getView(R.id.img));
                break;
        }
    }
}
