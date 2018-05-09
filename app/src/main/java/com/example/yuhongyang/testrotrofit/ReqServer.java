package com.example.yuhongyang.testrotrofit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.yuhongyang.testrotrofit.bean.AdvInfo;
import com.example.yuhongyang.testrotrofit.bean.AdvInfoTemp;
import com.example.yuhongyang.testrotrofit.bean.HttpResult;
import com.example.yuhongyang.testrotrofit.bean.MovieEntity;
import com.example.yuhongyang.testrotrofit.bean.Subject;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yuhong.yang on 2018/1/30.
 */

public class ReqServer {

    private String url = "https://t1st.ytzq.com:21800/middleware/api/index/shortcutmenu.json";

    public OkHttpClient initOkHttpClient(){
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        if (okHttpClientBuilder.interceptors() != null){
            okHttpClientBuilder.interceptors().clear();
        }
        okHttpClientBuilder.addInterceptor(new LoggerInterceptor());
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClientBuilder.addInterceptor(interceptor);
        okHttpClientBuilder.addInterceptor(new LoggerInterceptor());
        return okHttpClientBuilder
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS).build();

    }

    public void testGet(Subscriber subscriber) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURLTEMP)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initOkHttpClient())
                .build();
        DemoService demoService = retrofit.create(DemoService.class);
//        Call<ShortcutMenuInfo> repos = demoService.getShortCutMenu("shortcutmenu.json");
//        repos.enqueue(new Callback<ShortcutMenuInfo>() {
//            @Override
//            public void onResponse(Call<ShortcutMenuInfo> call, Response<ShortcutMenuInfo> response) {
//                Log.d("tag",response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<ShortcutMenuInfo> call, Throwable throwable) {
//                Log.d("tagfailure",throwable.toString());
//            }
//        });
//        Call<AdvInfo> advs = demoService.getAdvInfo("activity.json","1");
//        advs.enqueue(new Callback<AdvInfo>() {
//            @Override
//            public void onResponse(Call<AdvInfo> call, Response<AdvInfo> response) {
//                Log.d("tag",response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<AdvInfo> call, Throwable throwable) {
//                Log.d("tagfailure",throwable.toString());
//            }
//        });

//        Call<Map<String, String>> mapTest = demoService.getMapTest("activity.json", "1");
//        mapTest.enqueue(new Callback<Map<String, String>>() {
//            @Override
//            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
//                Log.e("TAG", response.toString());
//            }
//
//            @Override
//            public void onFailure(Call<Map<String, String>> call, Throwable throwable) {
//
//            }
//        });
//        demoService.getAdvInfoTemp(Constant.ADVINFO,"1")
//                //指定事件消费在子线程
//                .observeOn(AndroidSchedulers.mainThread())
//                //事件产生在新线程
//                .subscribeOn(Schedulers.newThread())
//                //指定一个观察者
//                .subscribe(new Observer<AdvInfoTemp>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(context,"请求结束",Toast.LENGTH_LONG).show();
//                        Log.d("reqserver","complete");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("reqerror","complete");
//
//                    }
//
//                    @Override
//                    public void onNext(AdvInfoTemp advInfo) {
//                        Log.d("reqserver","onnext "+advInfo);
//
//                    }
//                });

        Observable ob = demoService.getTopMovie(260,270);

        Observable.Transformer<MovieEntity<List<Subject>>,List<Subject>> result = handleResult();

        ob.compose(result).subscribe(subscriber);



//        demoService.getTopMovie(1,5)
//                //指定事件消费在子线程
//                .observeOn(AndroidSchedulers.mainThread())
//                //事件产生在新线程
//                .subscribeOn(Schedulers.newThread())
//                //指定一个观察者
//                .subscribe(new Observer<HttpResult<List<MovieEntity>>>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(context,"请求结束",Toast.LENGTH_LONG).show();
//                        Log.d("reqserver","complete");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("reqerror","complete");
//
//                    }
//
//                    @Override
//                    public void onNext(HttpResult<List<MovieEntity>> result) {
//                        Log.d("reqserver","onnext "+result);
//
//                    }
//                });


    }

    public static <T> Observable.Transformer<MovieEntity<T>,T> handleResult(){
        return new Observable.Transformer<MovieEntity<T>,T>(){

            @Override
            public Observable<T> call(Observable<MovieEntity<T>> httpResultObservable) {
                return httpResultObservable.flatMap(new Func1<MovieEntity<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(MovieEntity<T> listHttpResult) {
                        if (listHttpResult.getCount() != 0){
                            return createData(listHttpResult.getSubjects());
                        }else{
                            return Observable.error(new ApiException(listHttpResult.getCount()));
                        }
                    }
                }).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Observable<T> createData(final T data){
        return Observable.create(new Observable.OnSubscribe<T>(){

            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                }catch (Exception e){
                    subscriber.onError(e);
                }

            }
        });
    }


    private static ApiService SERVICE;
    private static final int DETAULT_TIMEOUT = 10000;

    public static ApiService getDefault(){
        if (SERVICE ==null){
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();
            httpClientBuilder.connectTimeout(DETAULT_TIMEOUT, TimeUnit.SECONDS);
            httpClientBuilder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    okhttp3.Response originalResponse = chain.proceed(request);
                    return originalResponse.newBuilder()
                            .header("key1","value1")
                            .addHeader("key2","value2").build();

                }
            });
            SERVICE = new Retrofit.Builder()
                    .baseUrl(Constant.BASEURL)
                    .client(httpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build().create(ApiService.class);
        }
        return SERVICE;
    }
}
