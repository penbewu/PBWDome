package com.example.myapplication.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;

import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;

import java.io.File;

/**
 * sky
 * 2021/3/18 18:14
 */

public class ImageLoadUtil {

    @SuppressLint("CheckResult")
    public static void ImageLoadNoCaching(Context context, String url, ImageView imageView, int id) {

        RequestOptions options = new RequestOptions();
        options
//                .error(R.drawable.load_img_failure)
                .placeholder(id)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true) // 不使用内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE) // 不使用磁盘缓存
                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }


    @SuppressLint("CheckResult")
    public static void ImageLoadNoCaching( String url,Context context, ImageView imageView,int img) {

        RequestOptions options = new RequestOptions();
        options
                .placeholder(img)
//                .placeholder(R.color.transparent1)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(false); // 不使用内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE) // 不使用磁盘缓存
//                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }


    @SuppressLint("CheckResult")
    public static void ImageLoad(Context context, String url, ImageView imageView, int id) {

        RequestOptions options = new RequestOptions();
        options
                .error(R.drawable.load_img_failure)
                .placeholder(id)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void ImageLoad1(Context context, String url, ImageView imageView, int id) {

        RequestOptions options = new RequestOptions();
        options
                .error(R.drawable.load_img_failure)
                .placeholder(id)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }


//加载本地
    @SuppressLint("CheckResult")
    public static void ImageLoad(Context context, int url, ImageView imageView, int id) {

        RequestOptions options = new RequestOptions();
        options
//                .error(R.drawable.load_img_failure)
                .placeholder(id)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }


    @SuppressLint("CheckResult")
    public static void ImageLoad(Context context, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions();
        options
                .placeholder(R.drawable.load_img_failure)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .asBitmap() //必须
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void ImageLoad(Context context, String url, ImageView imageView,int arrimg,boolean is) {

        RequestOptions options = new RequestOptions();
        options
                .placeholder(arrimg)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fallback(arrimg);

        Glide.with(context)
                .asBitmap() //必须
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void ImageLoad1(Context context, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions();
        options
                .placeholder(R.drawable.load_img_failure)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .asBitmap() //必须
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void ImageLoadGif(String url, Context context, ImageView imageView) {
        RequestOptions options = new RequestOptions();
        options
                .fitCenter()
                .placeholder(R.drawable.load_img_failure)
                .fallback(R.drawable.load_img_failure);
        Glide.with(context).load(url).into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void ImageLoadGif2(String url, Context context, ImageView imageView) {
        RequestOptions options = new RequestOptions();
        options
                .fitCenter()
                .placeholder(R.drawable.load_img_failure)
                .fallback(R.drawable.load_img_failure);
        Glide.with(context).load(url).into(imageView);
    }

    /**
     * 加载动画，没有默认加载 resId
     * @param url
     * @param context
     * @param imageView
     * @param resId
     */
    @SuppressLint("CheckResult")
    public static void ImageLoadGifAward(String url, Context context, ImageView imageView, int resId) {
        RequestOptions options = new RequestOptions();
        options
                .fitCenter()
                .placeholder(R.drawable.load_img_failure)
                .fallback(R.drawable.load_img_failure);
        if (StringUtils.isEmpty(url)) {
            Glide.with(context).asGif().load(resId).into(imageView);
        } else {
            Glide.with(context).load(url).into(imageView);
        }
    }

//    @SuppressLint("CheckResult")
//    public static void ImageLoadGifRound(String url, Context context, ImageView imageView) {
//        RequestOptions options = new RequestOptions();
//        options.fitCenter()
////                .placeholder(R.drawable.load_img)
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(DensityUtil.dp2px(5))));
////                .fallback(R.drawable.load_img);
//        Glide.with(context).load(url)
//                .apply(options)
//                .into(imageView);
//    }

    @SuppressLint("CheckResult")
    public static void ImageLoadGif1(String url, Context context, ImageView imageView) {
//        RequestOptions options = new RequestOptions();
//        options
//                .fitCenter()
//                .placeholder(R.drawable.load_img1)
//                .fallback(R.drawable.load_img1);
        if (url != null && url.toLowerCase().startsWith("http")) {
            Glide.with(context)
                    .load(url)
                    .placeholder(R.drawable.load_img_failure)
                    .error(R.drawable.load_img_failure)
                    .into(imageView);
        } else {
            Glide.with(context)
                    .load(new File(url))
                    .placeholder(R.drawable.load_img_failure)
                    .error(R.drawable.load_img_failure)
                    .into(imageView);
        }
    }

    @SuppressLint("CheckResult")
    public static void ImageLoadGif(int url, Context context, ImageView imageView) {
        RequestOptions options = new RequestOptions();
        options
                .fitCenter()
                .placeholder(R.drawable.load_img_failure)
                .fallback(R.drawable.load_img_failure);
        Glide.with(context).load(url).into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void ImageLoadGif1(int url, Context context, ImageView imageView) {
        RequestOptions options = new RequestOptions();
        options
                .fitCenter()
                .placeholder(R.drawable.load_img_failure)
                .fallback(R.drawable.load_img_failure);
        Glide.with(context).load(url).into(imageView);
    }

//    R.drawable.z1
    //无占位图图片
    @SuppressLint("CheckResult")
    public static void ImageLoad(String url, Context context, ImageView imageView, String s) {

        RequestOptions options = new RequestOptions();
        options
                .placeholder(R.drawable.load_img_failure)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(context)
                .load(url)
//                .apply(options)
                .into(imageView);
    }

    @SuppressLint("CheckResult")
    public static void ImageLoad(Context context, int url, ImageView imageView) {

        RequestOptions options = new RequestOptions();
        options
                .error(R.drawable.load_img_failure)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView)
        ;
    }

    @SuppressLint("CheckResult")
    public static void ImageLoad1(Context context, int url, ImageView imageView) {

        RequestOptions options = new RequestOptions();
        options
                .error(R.drawable.load_img_failure)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .fallback(R.drawable.load_img_failure);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView)
        ;
    }

    public static void ImageLoad(Context context, File file, ImageView imageView) {

//        RoundedCorners roundedCorners= new RoundedCorners(90);
//        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);

        Glide.with(context)
                .load(file)
                .into(imageView);
    }

    public static void loadRoundImage(ImageView view, String url, int id) {
        RoundedCorners roundedCorners = null;
        //通过RequestOptions扩展功能
        RequestOptions options = null;
        if (id == 0) {
            roundedCorners = new RoundedCorners(30);
            options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300)
                    .fallback(R.drawable.load_img_failure).error(R.drawable.load_img_failure).circleCrop();
        } else {
            roundedCorners = new RoundedCorners(id);
            options = RequestOptions.bitmapTransform(roundedCorners) .fallback(R.drawable.
                    load_img_failure).error(R.drawable.load_img_failure)
                    .override(300, 300);
        }
        Glide.with(view.getContext())
                .load(url).apply(options).into(view);
    }

//    public static void loadRoundImage0(ImageView view, String url, int id) {
//        RoundedCorners roundedCorners = null;
//        //通过RequestOptions扩展功能
//        RequestOptions options = null;
//        if (id == 0) {
//            roundedCorners = new RoundedCorners(30);
//            options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300)
//                    .fallback(R.drawable.head).error(R.drawable.head).circleCrop();
//        } else {
//            roundedCorners = new RoundedCorners(id);
//            options = RequestOptions.bitmapTransform(roundedCorners) .fallback(R.drawable.
//                    head).error(R.drawable.head)
//                    .override(300, 300);
//        }
//        Glide.with(view.getContext())
//                .load(url).apply(options).into(view);
//    }


    public static void loadRoundImage(ImageView view, String url, int id,int img) {
        RoundedCorners roundedCorners = null;
        //通过RequestOptions扩展功能
        RequestOptions options = null;
        if (id == 0) {
            roundedCorners = new RoundedCorners(30);
            options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300)
                    .fallback(img).error(img).circleCrop();
        } else {
            roundedCorners = new RoundedCorners(id);
            options = RequestOptions.bitmapTransform(roundedCorners) .fallback(img).error(img)
                    .override(300, 300);
        }
        Glide.with(view.getContext())
                .load(url).apply(options).into(view);
    }


    @SuppressLint("CheckResult")
    public static void ImageLoad(int img,Context context, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions();
        options .placeholder(img)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fallback(img);

        Glide.with(context)
//                .asBitmap() //必须
                .load(url)
                .apply(options)
                .into(imageView);
    }


//    圆角
    public static void toRoundCorners(int img, Context context, String url, ImageView imageView) {
        // 圆角处理
//        RequestOptions options = new RequestOptions();
//        options .placeholder(img)
//                .skipMemoryCache(false)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(img)
//                .fallback(img);
        Glide.with(context)
                .asBitmap() //必须
                .load(url)
//                .apply(options)
                .into(imageView);
    }


//    圆角
//    public static void toRoundCorner2(int img, Context context, String url, ImageView imageView) {
//        // 圆角处理
//        RequestOptions options = new RequestOptions();
//        options.fitCenter()
////                .placeholder(R.drawable.load_img)
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(DensityUtil.dp2px(5))));
////                .fallback(R.drawable.load_img);
//        Glide.with(context)
//                .asBitmap() //必须
//                .load(url)
//                .apply(options)
//                .into(imageView);
//    }

    @SuppressLint("CheckResult")
    public static void ImageLoadCircleCrop(Context context, String url, ImageView imageView) {

        Glide.with(context)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()).error(R.drawable.load_img_failure))
                .into(imageView);
    }
    @SuppressLint("CheckResult")
    public static void ImageLoadAct(Context context, String url, ImageView imageView) {
        RequestOptions options = new RequestOptions();
        options.error(R.drawable.load_img_failure);
        Glide.with(context)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(1)))
                .into(imageView);
    }

//右圆角
//    public static void rightRoundCorners(int img, Context context, String url, ImageView imageView) {
//        // 圆角处理
//
//        RequestOptions myOptions = new RequestOptions().optionalTransform
//                (new GlideRoundedCornersTransform(MeasureUtil.dip2px(context,40)
//                        , GlideRoundedCornersTransform.CornerType.TOP_RIGHT)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(img).fallback(img);
//
//        Glide.with(context)
////                .asBitmap() //必须
//                .load(url)
//                .apply(myOptions)
//                .into(imageView);
//    }

    public static void cacheRoundCorners(int img, Context context, String url, ImageView imageView) {
        // 圆形处理
//        RequestOptions myOptions = new RequestOptions().bitmapTransform(new CircleCrop()).skipMemoryCache(false)
//                .diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(img).fallback(img);

        Glide.with(context)
                .asBitmap() //必须
                .load(url)
                .placeholder(img)
                .error(img)
//                .apply(myOptions)
                .into(imageView);
    }

    public static void cacheRoundCorners(Context context,int img, String url, ImageView imageView) {
        // 圆形处理
        RequestOptions myOptions = new RequestOptions().bitmapTransform(new CircleCrop()).skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(img).fallback(img);

        Glide.with(context)
                .asBitmap() //必须
                .load(url)
                .apply(myOptions)
                .into(imageView);
    }



    //圆形图片
    public static void LoadCircleImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
//                .transform(new CircleTransform(context))
                .into(imageView);
    }

    //圆形图片设置占位图
    public static void LoadCircleImage(Context context, String url, ImageView imageView, int placeholderResourceId, int errorResourceId) {
        Glide.with(context).load(url)
                .centerCrop()
                .placeholder(placeholderResourceId)
                .error(errorResourceId)
//                .transform(new CircleTransform(context))
                .into(imageView);
    }

    //一般图片
    public static void LoadImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

    //一般图片设置占位图
    public static void LoadImage(Context context, String url, ImageView imageView, int placeholderResourceId, int errorResourceId) {
        Glide.with(context).load(url)
                .placeholder(placeholderResourceId)
                .error(errorResourceId)
                .into(imageView);
    }

    //圆角图片
    public static void LoadCornersImage(Context context, String url, ImageView imageView, int num) {
        RoundedCorners roundedCorners = new RoundedCorners(num);
        Glide.with(context).load(url)
                .centerCrop()
                .apply(RequestOptions.bitmapTransform(roundedCorners))
                .into(imageView);
    }

    //瀑布流图片
    public static void LoadStaggeredImage(final Context context, String url, final ImageView imageView) {
//        int screenWidth = OtherUtils.getScreenWidth(context);
//        int width = screenWidth / 2;
//        Glide.with(context).load(url).override(width, SimpleTarget.SIZE_ORIGINAL).fitCenter().into(imageView);
    }

    //获取屏幕宽度的方法
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

}
