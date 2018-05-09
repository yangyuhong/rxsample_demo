package com.example.yuhongyang.testrotrofit.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */
public class ShortcutMenuInfo {


    /**
     * errorcode : 0
     * errormsg : 成功
     * results : [{"scmid":60,"menuname":"我的消息","iconurlnor":"/upload/image/shortcutmenu/201710/1507794635_90x90.png","backgroundcolor":"red","androidurl":"yintai.szkingdom.android.activity.MyMessageActivity","iosurl":"YT_MyNews","webviewloginflag":"3","ordernum":"1","status":"0","jumptype":"0"},{"scmid":64,"menuname":"意见反馈","iconurlnor":"/upload/image/shortcutmenu/201710/1507794757_90x90.png","backgroundcolor":"red","androidurl":"yintai.szkingdom.android.activity.SuggesstionReplyActivity","iosurl":"YT_FeedBack","webviewloginflag":"3","ordernum":"2","status":"0","jumptype":"0"},{"scmid":55,"menuname":"营销推广","iconurlnor":"/upload/image/shortcutmenu/201710/1507794411_90x90.png","backgroundcolor":"red","androidurl":"ytzyh5/index.html#/home/account","iosurl":"ytzyh5/index.html#/home/account","webviewloginflag":"1","ordernum":"3","status":"0","jumptype":"1"},{"scmid":58,"menuname":"我的二维码","iconurlnor":"/upload/image/shortcutmenu/201710/1507794527_90x90.png","backgroundcolor":"","androidurl":"ytzyh5/index.html#/client/insert/myqrcode","iosurl":"ytzyh5/index.html#/client/insert/myqrcode","webviewloginflag":"1","ordernum":"4","status":"0","jumptype":"1"},{"scmid":59,"menuname":"佣金计算器","iconurlnor":"/upload/image/shortcutmenu/201710/1507794584_90x90.png","backgroundcolor":"red","androidurl":"ytzyh5/index.html#/find/commission","iosurl":"ytzyh5/index.html#/find/commission","webviewloginflag":"0","ordernum":"5","status":"0","jumptype":"1"},{"scmid":61,"menuname":"新手指南","iconurlnor":"/upload/image/shortcutmenu/201710/1507794669_90x90.png","backgroundcolor":"red","androidurl":"ytzyh5/index.html#/home/guide/list/faq","iosurl":"ytzyh5/index.html#/home/guide/list/faq","webviewloginflag":"3","ordernum":"6","status":"0","jumptype":"1"},{"scmid":62,"menuname":"知识库","iconurlnor":"/upload/image/shortcutmenu/201710/1507794700_90x90.png","backgroundcolor":"red","androidurl":"ytzyh5/index.html#/find/knowledge","iosurl":"ytzyh5/index.html#/find/knowledge","webviewloginflag":"3","ordernum":"7","status":"0","jumptype":"1"},{"scmid":63,"menuname":"英雄榜","iconurlnor":"/upload/image/shortcutmenu/201710/1507794725_90x90.png","backgroundcolor":"red","androidurl":"ytzyh5/index.html#/find/rank","iosurl":"ytzyh5/index.html#/find/rank","webviewloginflag":"3","ordernum":"8","status":"0","jumptype":"1"}]
     */

    private String errorcode;
    private String errormsg;
    private List<ResultsBean> results;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * scmid : 60
         * menuname : 我的消息
         * iconurlnor : /upload/image/shortcutmenu/201710/1507794635_90x90.png
         * backgroundcolor : red
         * androidurl : yintai.szkingdom.android.activity.MyMessageActivity
         * iosurl : YT_MyNews
         * webviewloginflag : 3
         * ordernum : 1
         * status : 0
         * jumptype : 0
         */

        private int scmid;
        private String menuname;
        private String iconurlnor;
        private String backgroundcolor;
        private String androidurl;
        private String iosurl;
        private String webviewloginflag;
        private String ordernum;
        private String status;
        private String jumptype;

        public int getScmid() {
            return scmid;
        }

        public void setScmid(int scmid) {
            this.scmid = scmid;
        }

        public String getMenuname() {
            return menuname;
        }

        public void setMenuname(String menuname) {
            this.menuname = menuname;
        }

        public String getIconurlnor() {
            return iconurlnor;
        }

        public void setIconurlnor(String iconurlnor) {
            this.iconurlnor = iconurlnor;
        }

        public String getBackgroundcolor() {
            return backgroundcolor;
        }

        public void setBackgroundcolor(String backgroundcolor) {
            this.backgroundcolor = backgroundcolor;
        }

        public String getAndroidurl() {
            return androidurl;
        }

        public void setAndroidurl(String androidurl) {
            this.androidurl = androidurl;
        }

        public String getIosurl() {
            return iosurl;
        }

        public void setIosurl(String iosurl) {
            this.iosurl = iosurl;
        }

        public String getWebviewloginflag() {
            return webviewloginflag;
        }

        public void setWebviewloginflag(String webviewloginflag) {
            this.webviewloginflag = webviewloginflag;
        }

        public String getOrdernum() {
            return ordernum;
        }

        public void setOrdernum(String ordernum) {
            this.ordernum = ordernum;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getJumptype() {
            return jumptype;
        }

        public void setJumptype(String jumptype) {
            this.jumptype = jumptype;
        }
    }
}
