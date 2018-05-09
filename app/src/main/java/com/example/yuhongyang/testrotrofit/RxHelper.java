package com.example.yuhongyang.testrotrofit;



import android.util.Log;

import com.example.yuhongyang.testrotrofit.bean.HttpResult;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by yuhong.yang on 2018/1/31.
 */

public class RxHelper {





    public static <T> Observable.Transformer<HttpResult<T>,T> handleResult(){
        return new Observable.Transformer<HttpResult<T>, T>() {

            @Override
            public Observable<T> call(final Observable<HttpResult<T>> httpResultObservable) {
                return httpResultObservable.flatMap(
                        new Func1<HttpResult<T>,Observable<T>>(){

                            @Override
                            public Observable<T> call(HttpResult<T> tHttpResult) {
                                Log.d("yyh",tHttpResult.getCount()+"");
                                if (tHttpResult.getCount() == 0){
                                    return createData(tHttpResult.getSubjects());
                                }else{
                                    return Observable.error(
                                            new ApiException(tHttpResult.getCount())
                                    );
                                }
                            }
                        }
                );
            }
        };
    }


    /*
    * 创造成功的数据
    * */
    private static <T> Observable<T> createData(final T data){
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


}