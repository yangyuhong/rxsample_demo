package com.example.yuhongyang.testrotrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 假如返回值是：username=张三&male=男性 需要转换成键值对的形式放在map中
 * Created by yuhong.yang on 2018/1/30.
 */

public class CustomerConverterFactory extends Converter.Factory{



    public static CustomerConverterFactory create(){
        return new CustomerConverterFactory();

    }
    @Override
    public Converter<ResponseBody,?> responseBodyConverter(
            Type type, Annotation[] annotations, Retrofit retrofit){
        return  new CustomerConverter();
    }

    class CustomerConverter implements Converter<ResponseBody,Map<String,String>>{

        @Override
        public Map<String, String> convert(ResponseBody responseBody) throws IOException {
            Map<String,String> map = new HashMap<>();
            String content = responseBody.toString();
            content = "username=张三&male=男性";
            String[] fileds = content.split("&");
            for (int i = 0; i < fileds.length; i++){
                String filed = fileds[i];
                int divPos = filed.indexOf("=");
                String key = filed.substring(0,divPos);
                String value = filed.substring(divPos + 1);
                map.put(key,value);
            }
            return map;
        }
    }


}
