package com.example.yuhongyang.testrotrofit;

import android.content.Context;

import rx.Subscriber;

/**
 * Created by yuhong.yang on 2018/1/31.
 */

public abstract class ProgressSubscriber<T>
        extends Subscriber<T> implements ProgressCancelListener{
    private SimpleLoadDialog dialogHandler;

    public ProgressSubscriber(Context context){
        dialogHandler = new SimpleLoadDialog(context,this,true);
    }

    @Override
    public void onCompleted(){
        dismissProgressDialog();
    }

    protected abstract void _onNext(T t);
    protected abstract void _onError(String message);

    @Override
    public void onNext(T t){
        _onNext(t);
    }
    @Override
    public void onError(Throwable e){
        e.printStackTrace();
        if (false){
            _onError("网络不可用");
        } else if (e instanceof ApiException){
            _onError(e.getMessage());
        }else {
            _onError("请求失败，请稍后重试。。。");
        }
        dismissProgressDialog();
    }

    @Override
    public void onCancelProgress(){
        if (!this.isUnsubscribed()){
            this.unsubscribe();
        }
    }
    public void showProgressDialog(){
        if (dialogHandler != null){
            dialogHandler.obtainMessage(
                    SimpleLoadDialog.SHOW_PROGRESS_DIALOG)
                    .sendToTarget();
        }
    }

    public void dismissProgressDialog(){
        if (dialogHandler != null){
            dialogHandler.obtainMessage(
                    SimpleLoadDialog.DISMISS_PROGRESS_DIALOG)
                    .sendToTarget();
            dialogHandler = null;
        }
    }

}


