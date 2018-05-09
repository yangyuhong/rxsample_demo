package com.example.yuhongyang.testrotrofit;

import android.provider.SyncStateContract;

import com.example.yuhongyang.testrotrofit.bean.AdvInfo;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yuhong.yang on 2018/1/31.
 */


public interface ApiService {
    @POST(Constant.ADVINFO)
    Observable<AdvInfo> getAdvInfo(@Query("adtype") String adtype);



}
