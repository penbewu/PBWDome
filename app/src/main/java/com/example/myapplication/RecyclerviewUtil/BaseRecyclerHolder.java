package com.example.myapplication.RecyclerviewUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.StringUtils;
import com.example.myapplication.Util.ImageLoadUtil;

import butterknife.ButterKnife;

/**
 * sky
 * 2021/3/18 18:14
 */
public class BaseRecyclerHolder extends RecyclerView.ViewHolder
{
    private SparseArray<View> views;
    private Context context;

//    private CountDownTimer countDownTimer;
//
//    public CountDownTimer getCountDownTimer() {
//        return countDownTimer;
//    }
//
//    public void setCountDownTimer(CountDownTimer countDownTimer) {
//        this.countDownTimer = countDownTimer;
//    }

    private BaseRecyclerHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        //指定一个初始为8
        views = new SparseArray<>(8);
    }

    /**
     * 取得一个RecyclerHolder对象
     * @param context 上下文
     * @param itemView 子项
     * @return 返回一个RecyclerHolder对象
     */
    public static BaseRecyclerHolder getRecyclerHolder(Context context,View itemView){
        return new BaseRecyclerHolder(context,itemView);
    }

    public SparseArray<View> getViews(){
        return this.views;
    }

    public Context getContext() {
        return context;
    }

    /**
     * 通过view的id获取对应的控件，如果没有则加入views中
     * @param viewId 控件的id
     * @return 返回一个控件
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId){
        View view = views.get(viewId);
        if (view == null ){
            view = itemView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 设置字符串
     */
    public BaseRecyclerHolder setText(int viewId,String text){
        if (0==viewId)
            return  this;

        TextView tv = getView(viewId);
        if (StringUtils.isEmpty(text)){
            tv.setText(null);
        }else{
            tv.setText(text);
        }
        return this;
    }

    /**
     * 设置字符串
     */
    public BaseRecyclerHolder setText(int viewId, SpannableStringBuilder text){
        if (0==viewId||null==text||text.equals(""))
            return  this;

        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置图片
     */
    public BaseRecyclerHolder setImageResource(int viewId,int drawableId){
        if (0==viewId||0==drawableId)
            return  this;

        ImageView iv = getView(viewId);
        iv.setImageResource(drawableId);
        return this;
    }

    /**
     * 设置图片
     */
    public BaseRecyclerHolder setImageBitmap(int viewId, Bitmap bitmap){
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 设置图片
     */
    public BaseRecyclerHolder setImageByUrl(int viewId,String url){
        ImageLoadUtil.ImageLoad(context,url,(ImageView) getView(viewId));
        return this;
    }

    /**
     * 设置图片
     */
    public BaseRecyclerHolder setImageByUrl(int viewId,int url){
        ImageLoadUtil.ImageLoad(context,url,(ImageView) getView(viewId));
        return this;
    }
}
