package com.example.myapplication.Fragments;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.example.myapplication.Base.BaseFragment;
import com.example.myapplication.Base.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Util.ImageLoadUtil;
import com.example.myapplication.Util.PubStaic;
import com.example.myapplication.Views.BottomLineLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * sky
 * 2021/3/19 17:55
 */
public class GuidanceFrag extends BaseFragment {

    @BindView(R.id.view_pag)
    ViewPager viewPag;
    @BindView(R.id.botton_lin)
    BottomLineLayout bottonLin;
    @BindView(R.id.next_tex)
    TextView nextTex;

    public GuidanceFrag() {
        super(R.layout.guidance_frag, true);
    }

    private List<View> listv = new ArrayList<>();

    private int imgs[] = {R.mipmap.a2, R.mipmap.a5, R.mipmap.a3, R.mipmap.a4, R.mipmap.a6};

    @Override
    public void initView() {
        bottonLin.initViews(imgs.length, 20, 10);

        for (int i : imgs) {
            ImageView imageView = new ImageView(getActivity());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    , ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(layoutParams);
            ImageLoadUtil.ImageLoad(getActivity(), i, imageView);
            listv.add(imageView);
        }

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(listv);
        viewPag.setAdapter(myPagerAdapter);


        viewPag.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (bottonLin != null) {
                    bottonLin.changePosition(position);
                }

                if (position == listv.size() - 1)
                    nextTex.setVisibility(View.VISIBLE);
                    else
                    nextTex.setVisibility(View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick(R.id.next_tex)
    public void onViewClicked() {
        SPUtils.getInstance().put(PubStaic.FIRST,"ok");
        ActivityUtils.startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }

    public class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        //也可以重写构造器，传入Context，然后在PagerAdapter
        //中初始话Layout布局，感觉这种通用一些
        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            //返回有效的View的个数
            return mViewList.size();
        }

        //判断是否page view与 instantiateItem(ViewGroup, int)返回的object的key 是否相同，以提供给其他的函数使用
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //instantiateItem该方法的功能是创建指定位置的页面视图。finishUpdate(ViewGroup)返回前，页面应该保证被构造好
        //返回值：返回一个对应该页面的object，这个不一定必须是View，但是应该是对应页面的一些其他容器
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        //该方法的功能是移除一个给定位置的页面。
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
