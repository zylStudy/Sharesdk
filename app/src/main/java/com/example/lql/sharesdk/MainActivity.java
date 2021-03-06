package com.example.lql.sharesdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lql.sharesdk.utils.LogUtils;
import com.example.lql.sharesdk.utils.PublicStaticData;
import com.example.lql.sharesdk.utils.ShareSDKUtils;
import com.example.lql.sharesdk.utils.UmengShare;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;


public class MainActivity extends Activity implements View.OnClickListener, PlatformActionListener, UMShareListener, UMAuthListener {


    private android.widget.Button openShare;
    private Button QQLogin;
    private Button WXLogin;
    private Button SinaLogin;
    private Button QQshare;
    private Button QZONEshare;
    private Button Sinashare;
    private Button WXshare;
    private Button WXfriendsshare;
    private Button WXLike;
    private Button openShareUmeng;
    private Button QQLoginUmeng;
    private Button WXLoginUmeng;
    private Button SinaLoginUmeng;
    private Button QQshareUmeng;
    private Button QZONEshareUmeng;
    private Button SinashareUmeng;
    private Button WXshareUmeng;
    private Button WXfriendsshareUmeng;
    private Button WXLikeUmeng;


    String picurl = "http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg";//测试图片地址

    private int SharesdkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        showShare("测试标题", "测试文本", null);
    }

    private void initView() {
        this.SinaLogin = (Button) findViewById(R.id.SinaLogin);
        this.WXLogin = (Button) findViewById(R.id.WXLogin);
        this.QQLogin = (Button) findViewById(R.id.QQLogin);
        this.openShare = (Button) findViewById(R.id.openShare);

        this.WXLike = (Button) findViewById(R.id.WXLike);
        this.WXfriendsshare = (Button) findViewById(R.id.WXfriendsshare);
        this.WXshare = (Button) findViewById(R.id.WXshare);
        this.Sinashare = (Button) findViewById(R.id.Sinashare);
        this.QZONEshare = (Button) findViewById(R.id.QZONEshare);
        this.QQshare = (Button) findViewById(R.id.QQshare);


        this.WXLikeUmeng = (Button) findViewById(R.id.WXLikeUmeng);
        this.WXfriendsshareUmeng = (Button) findViewById(R.id.WXfriendsshareUmeng);
        this.WXshareUmeng = (Button) findViewById(R.id.WXshareUmeng);
        this.SinashareUmeng = (Button) findViewById(R.id.SinashareUmeng);
        this.QZONEshareUmeng = (Button) findViewById(R.id.QZONEshareUmeng);
        this.QQshareUmeng = (Button) findViewById(R.id.QQshareUmeng);
        this.SinaLoginUmeng = (Button) findViewById(R.id.SinaLoginUmeng);
        this.WXLoginUmeng = (Button) findViewById(R.id.WXLoginUmeng);
        this.QQLoginUmeng = (Button) findViewById(R.id.QQLoginUmeng);
        this.openShareUmeng = (Button) findViewById(R.id.openShareUmeng);


        WXLikeUmeng.setOnClickListener(this);
        WXfriendsshareUmeng.setOnClickListener(this);
        WXshareUmeng.setOnClickListener(this);
        SinashareUmeng.setOnClickListener(this);
        QZONEshareUmeng.setOnClickListener(this);
        QQshareUmeng.setOnClickListener(this);
        SinaLoginUmeng.setOnClickListener(this);
        WXLoginUmeng.setOnClickListener(this);
        QQLoginUmeng.setOnClickListener(this);
        openShareUmeng.setOnClickListener(this);


        this.WXLike.setOnClickListener(this);
        this.WXfriendsshare.setOnClickListener(this);
        this.WXshare.setOnClickListener(this);
        this.Sinashare.setOnClickListener(this);
        this.QZONEshare.setOnClickListener(this);
        this.QQshare.setOnClickListener(this);


        this.openShare.setOnClickListener(this);
        this.SinaLogin.setOnClickListener(this);
        this.WXLogin.setOnClickListener(this);
        this.QQLogin.setOnClickListener(this);

    }


    /**
     * @param title  标题
     * @param text   内容
     * @param picurl 图片链接
     *               <p>
     *               QQ和QQ空间设置分享链接使用setTitleUrl();
     *               设置标题：setTitle
     *               设置内容：setText
     *               设置网络图片：oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
     *               设置本地图片： //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
     *               <p>
     *               微信
     *               url仅在微信（包括好友和朋友圈）中使用
     *               oks.setUrl("http://qq.com");
     */
    private void showShare(String title, String text, String picurl) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        oks.setTitle(title);
        oks.setText(text);
        if (picurl != null) {
            oks.setImageUrl(picurl);
        }
        // 启动分享GUI
        oks.show(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.openShare:
                showShare("sharesdk测试", "sharesdk测试", "http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                break;
            case R.id.QQLogin://QQ登录
                SharesdkType = ShareSDKUtils.LOGINTYPE;
                ShareSDKUtils.Login(QQ.NAME, this);
                break;
            case R.id.WXLogin://微信登录
                SharesdkType = ShareSDKUtils.LOGINTYPE;
                ShareSDKUtils.Login(Wechat.NAME, this);
                break;
            case R.id.SinaLogin://微博登录
                SharesdkType = ShareSDKUtils.LOGINTYPE;
                ShareSDKUtils.Login(SinaWeibo.NAME, this);
                break;
            case R.id.WXLike://收藏分享(微信需要有图片)
                SharesdkType = ShareSDKUtils.SHARETYPE;
                ShareSDKUtils.shareWXF("微信收藏分享测试标题sharesdk", "微信收藏分享测试内容sharesdk", picurl, "http://www.haidu.com", this);
                break;
            case R.id.WXfriendsshare://朋友圈分享(微信需要有图片)
                SharesdkType = ShareSDKUtils.SHARETYPE;
                ShareSDKUtils.shareWXM("朋友圈分享测试标题sharesdk", "朋友圈分享测试内容sharesdk", picurl, "http://www.haidu.com", this);
                break;
            case R.id.WXshare://微信分享(微信需要有图片)
                SharesdkType = ShareSDKUtils.SHARETYPE;
                ShareSDKUtils.shareWX("微信分享测试标题sharesdk", "微信分享测试内容sharesdk", picurl, "http://www.haidu.com", this);
                break;
            case R.id.Sinashare://微博分享
                SharesdkType = ShareSDKUtils.SHARETYPE;
                ShareSDKUtils.shareSina("Sina分享测试sharesdk", null, this);
                break;
            case R.id.QZONEshare://空间
                SharesdkType = ShareSDKUtils.SHARETYPE;
                ShareSDKUtils.shareQzone("Qzone分享测试标题sharesdk", "Qzone分享测试内容sharesdk", picurl, "http://www.haidu.com", this);
                break;
            case R.id.QQshare://QQ
                SharesdkType = ShareSDKUtils.SHARETYPE;
                ShareSDKUtils.shareQQ("Qzone分享测试标题sharesdk", "Qzone分享测试内容sharesdk", picurl, "http://www.haidu.com", this);
                break;


//--------------------------------------------------------------以上是Sharesdk---------------------------------------------------------
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++华丽分分割线++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//----------------------------------------------------------------以下是友盟-------------------------------------------------------------


            case R.id.openShareUmeng:
                new ShareAction(MainActivity.this).withText("测试啊测试啊")
                        .withTitle("测试啊测试啊")
                        .withMedia(new UMImage(MainActivity.this, picurl))
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN_FAVORITE)
                        .setCallback(this).open();
                break;
            case R.id.QQLoginUmeng://QQ登录
                UmengShare.UmengLogin(MainActivity.this, SHARE_MEDIA.QQ, this);
                break;
            case R.id.WXLoginUmeng://微信登录
                UmengShare.UmengLogin(MainActivity.this, SHARE_MEDIA.WEIXIN, this);
                break;
            case R.id.SinaLoginUmeng://微博登录
                UmengShare.UmengLogin(MainActivity.this, SHARE_MEDIA.SINA, this);
                break;
            case R.id.WXLikeUmeng://收藏分享(微信需要有图片)
                UmengShare.SharePic(MainActivity.this, "测试收藏", "测试收藏内容", SHARE_MEDIA.WEIXIN_FAVORITE, picurl, this);
                break;
            case R.id.WXfriendsshareUmeng://朋友圈分享(微信需要有图片)
                UmengShare.SharePic(MainActivity.this, "测试朋友圈", "测试朋友圈内容", SHARE_MEDIA.WEIXIN_CIRCLE, picurl, this);
                break;
            case R.id.WXshareUmeng://微信分享(微信需要有图片)
                UmengShare.SharePic(MainActivity.this, "测试分享", "测试分享内容", SHARE_MEDIA.WEIXIN, picurl, this);
                break;
            case R.id.SinashareUmeng://微博分享
                UmengShare.SharePic(MainActivity.this, "测试微博", "测试微博内容", SHARE_MEDIA.SINA, null, this);
                break;
            case R.id.QZONEshareUmeng://空间
                UmengShare.SharePic(MainActivity.this, "测试空间", "测试空间内容", SHARE_MEDIA.QZONE, null, this);
                break;
            case R.id.QQshareUmeng://QQ
                UmengShare.SharePic(MainActivity.this, "测试QQ", "测试QQ内容", SHARE_MEDIA.QQ, null, this);
                break;
        }
    }


    /**
     * 友盟QQ登录需要的回调   在有些低端手机上登录之后不走回调，需要这个方法
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).HandleQQError(MainActivity.this, requestCode, this);
        PublicStaticData.mShareAPI.onActivityResult(requestCode, resultCode, data);
    }

    //=======================================================ShareSDK的回调=======================================================

    /**
     * 这里是ShareSDK的回调
     *
     * @param platform
     * @param i
     * @param hashMap
     */
    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (SharesdkType == ShareSDKUtils.LOGINTYPE) {
            LogUtils.Loge("登录成功");
            LogUtils.Loge("openid:" + platform.getDb().getUserId());//拿到登录后的openid
            LogUtils.Loge("username:" + platform.getDb().getUserName());//拿到登录后的昵称
        } else {
            LogUtils.Loge("分享成功");
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        LogUtils.Loge(SharesdkType == ShareSDKUtils.LOGINTYPE ? "登录失败" + throwable.toString() : "分享失败" + throwable.toString());
    }

    @Override
    public void onCancel(Platform platform, int i) {
        LogUtils.Loge(SharesdkType == ShareSDKUtils.LOGINTYPE ? "登录取消" : "分享取消");
    }


    //=======================================================友盟的回调=======================================================
    //这里注意：友盟的分享和登陆回调是分开的

    /**
     * 友盟分享的回调
     *
     * @param share_media
     */
    @Override
    public void onResult(SHARE_MEDIA share_media) {
        LogUtils.Loge("分享成功啦");
    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
        LogUtils.Loge("分享失败啦" + throwable.toString());
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        LogUtils.Loge("分享取消了");
    }

    /**
     * 友盟登陆的回调
     *
     * @param share_media
     */
    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        LogUtils.Loge("授权成功");
        LogUtils.Loge("data:" + map.toString());
        LogUtils.Loge("openid:" + map.get("openid"));
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        LogUtils.Loge("授权失败:" + throwable.toString());
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        LogUtils.Loge("关闭授权");
    }
}
