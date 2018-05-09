package com.example.yuhongyang.testrotrofit;


import com.example.yuhongyang.testrotrofit.bean.AdvInfo;
import com.example.yuhongyang.testrotrofit.bean.AdvInfoTemp;
import com.example.yuhongyang.testrotrofit.bean.HttpResult;
import com.example.yuhongyang.testrotrofit.bean.MovieEntity;
import com.example.yuhongyang.testrotrofit.bean.ShortcutMenuInfo;
import com.example.yuhongyang.testrotrofit.bean.Subject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yuhong.yang on 2018/1/30.
 */

public interface DemoService {
//    private String url = "https://t1st.ytzq.com:21800/middleware/api/index/shortcutmenu.json";
//    index/activity.json
    @POST("middleware/api/index/{apiname}")
    Call<ShortcutMenuInfo> getShortCutMenu(@Path("apiname") String apiname);

    @POST("middleware/api/index/{apiname}")
    Call<AdvInfo> getAdvInfo(@Path("apiname")String apiname, @Query("adtype") String adtype);

    @POST("middleware/api/index/{apiname}")
    Call<Map<String,String>> getMapTest(@Path("apiname")String apiname, @Query("adtype") String adtype);

    @POST("middleware/api/index/{apiname}")
    Observable<AdvInfoTemp> getAdvInfoTemp(@Path("apiname")String apiname, @Query("adtype") String adtype);

    @GET("top250")
    Observable<MovieEntity<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);


}


