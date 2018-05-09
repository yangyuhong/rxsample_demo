package com.example.yuhongyang.testrotrofit;

/**
 * Created by yuhong.yang on 2018/1/31.
 */

public class ApiException extends RuntimeException {

    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PADDWORD = 101;
    public static final int ERROR_PARAMTERS = -998;
    private static String message;
    public ApiException(int resultCode){
        this(getApiExceptionMessage(resultCode));
    }

    public ApiException(String detailMessage){
        super(detailMessage);
    }
    @Override
    public String getMessage(){
        return message;
    }


    private static String getApiExceptionMessage(int code){
        switch (code){
            case USER_NOT_EXIST:
                message = "该用户不存在";
                break;
            case WRONG_PADDWORD:
                message = "密码错误";
                break;
            case ERROR_PARAMTERS:
                message = "请传参数";
                break;
            default:
                break;
        }
        return message;
    }
}

