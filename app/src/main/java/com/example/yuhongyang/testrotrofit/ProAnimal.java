package com.example.yuhongyang.testrotrofit;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yuhong.yang on 2018/2/7.
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({Constant.FISH ,Constant.BEAR,Constant.TAGER})
public @interface ProAnimal {


}
