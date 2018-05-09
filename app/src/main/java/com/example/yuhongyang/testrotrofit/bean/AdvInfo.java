package com.example.yuhongyang.testrotrofit.bean;

import java.util.List;

/**
 * Created by yuhong.yang on 2018/1/30.
 */

public class AdvInfo {

    /**
     * errorcode : 0
     * errormsg : 成功
     * results : [{"advtid":61,"advttitle":"专项营销","picurl":"/upload/image/advt/201710/1507795676_751x293.png","advttype":"1","androidurl":"","iosurl":"","showtime":"5","ordernum":"1","status":"0","jumptype":"1","intervaltime":"2"},{"advtid":63,"advttitle":"88理财节","picurl":"/upload/image/advt/201710/1507796019_597x289.png","advttype":"1","androidurl":"ytzyh5/index.html#/home/banners/banner2","iosurl":"ytzyh5/index.html#/home/banners/banner2","showtime":"5","ordernum":"2","status":"0","jumptype":"1","intervaltime":"2"}]
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
         * advtid : 61
         * advttitle : 专项营销
         * picurl : /upload/image/advt/201710/1507795676_751x293.png
         * advttype : 1
         * androidurl :
         * iosurl :
         * showtime : 5
         * ordernum : 1
         * status : 0
         * jumptype : 1
         * intervaltime : 2
         */

        private int advtid;
        private String advttitle;
        private String picurl;
        private String advttype;
        private String androidurl;
        private String iosurl;
        private String showtime;
        private String ordernum;
        private String status;
        private String jumptype;
        private String intervaltime;

        public int getAdvtid() {
            return advtid;
        }

        public void setAdvtid(int advtid) {
            this.advtid = advtid;
        }

        public String getAdvttitle() {
            return advttitle;
        }

        public void setAdvttitle(String advttitle) {
            this.advttitle = advttitle;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getAdvttype() {
            return advttype;
        }

        public void setAdvttype(String advttype) {
            this.advttype = advttype;
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

        public String getShowtime() {
            return showtime;
        }

        public void setShowtime(String showtime) {
            this.showtime = showtime;
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

        public String getIntervaltime() {
            return intervaltime;
        }

        public void setIntervaltime(String intervaltime) {
            this.intervaltime = intervaltime;
        }
    }
}
