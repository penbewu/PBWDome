package com.example.myapplication.Fragments;

import android.widget.LinearLayout;

import com.example.myapplication.Base.BaseFragment;
import com.example.myapplication.Bean.LogInBean;
import com.example.myapplication.R;

import butterknife.BindView;

/**
 * pengbiwu@Skyworth.com
 * 2021/3/23 14:05
 */
public class SettingRightFrag extends BaseFragment {

    @BindView(R.id.lin_ly)
    LinearLayout linLy;
    private LogInBean.LogInBeanDa logInBeanDa;

    public SettingRightFrag(LogInBean.LogInBeanDa logInBeanDa) {
        super(R.layout.setting_right_frag, true);
        this.logInBeanDa = logInBeanDa;
    }

    @Override
    public void initView() {
//        switch (logInBeanDa.getType()) {
//            case 0:
//                linLy.setBackgroundColor(getContext().getResources().getColor(R.color.yellow));
//                break;
//            case 1:
//                linLy.setBackgroundColor(getContext().getResources().getColor(R.color.orchid));
//                break;
//            case 2:
//                linLy.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
//                break;
//            case 3:
//                linLy.setBackgroundColor(getContext().getResources().getColor(R.color.burlywood));
//                break;
//            case 4:
//                linLy.setBackgroundColor(getContext().getResources().getColor(R.color.crimson));
//                break;
//            case 5:
//                linLy.setBackgroundColor(getContext().getResources().getColor(R.color.darkorange));
//                break;
//            case 6:
//                linLy.setBackgroundColor(getContext().getResources().getColor(R.color.thistle));
//                break;
//
//        }
    }
}
