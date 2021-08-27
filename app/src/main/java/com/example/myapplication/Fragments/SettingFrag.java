package com.example.myapplication.Fragments;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.FragmentUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.example.myapplication.Adapter.SettingAdapter;
import com.example.myapplication.Base.BaseFragment;
import com.example.myapplication.Bean.LogInBean;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerviewUtil.BaseRecyclerAdapter;
import com.example.myapplication.Util.GsonUtil;
import com.example.myapplication.Util.PubStaic;
import com.example.myapplication.Util.UtilPub;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * sky
 * 2021/3/23 11:11
 */
public class SettingFrag extends BaseFragment {

    @BindView(R.id.rec)
    RecyclerView rec;

    private SettingAdapter adapter;

    public SettingFrag() {
        super(R.layout.setting_frag, true);
    }

    private int positions=0;

    private List<LogInBean.LogInBeanDa> list =new ArrayList<>();
    private List<Fragment> listFrag =new ArrayList<>();

    private LogInBean logInBean;
    @Override
    public void initView() {
        UtilPub.setRec(getContext(),rec,true);
        LogUtils.e(SPUtils.getInstance().getString(PubStaic.LOGINBEAN,""));
        if (!StringUtils.isEmpty(SPUtils.getInstance().getString(PubStaic.LOGINBEAN,""))){
            logInBean= GsonUtil.fromJson(SPUtils.getInstance().getString(PubStaic.LOGINBEAN,""),LogInBean.class);
            if (null!=logInBean&&null!=logInBean.getList())
                list=logInBean.getList();
        }else {
            logInBean =new LogInBean();
            for (int i = 0; i < 6; i++) {
                LogInBean.LogInBeanDa logInBeanDa = new LogInBean.LogInBeanDa();
                logInBeanDa.setType(i);
                logInBeanDa.setName("测试用例" + i);
                logInBeanDa.setImagId(i);
                list.add(logInBeanDa);
            }
            logInBean.setList(list);
        }

        if (null!=logInBean&&null!=logInBean.getList()&&logInBean.getList().size()>0){
            for (LogInBean.LogInBeanDa logInBeanDa :logInBean.getList()){
                listFrag.add(new SettingRightFrag(logInBeanDa));
            }
        }

        adapter =new SettingAdapter(getContext(),list,R.layout.setting_adapter);
        rec.setAdapter(adapter);

        FragmentUtils.add(getActivity().getSupportFragmentManager(),
                listFrag,R.id.frame1,positions);

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                if (positions==position)
                    return;

                LogUtils.e(position);
                FragmentUtils.show(listFrag.get(position));
                FragmentUtils.hide(listFrag.get(positions));
                positions =position;
            }
        });


    }

    @Override
    public void onDestroy() {

        if (null!=logInBean){
            SPUtils.getInstance().put(PubStaic.LOGINBEAN,GsonUtil.toJson(logInBean));
            LogUtils.e(logInBean+"");
            LogUtils.e(GsonUtil.toJson(logInBean));
        }
        super.onDestroy();
    }
}
