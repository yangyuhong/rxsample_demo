package com.example.yuhongyang.testrotrofit;

import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.yuhongyang.testrotrofit.bean.Subject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
//    private Animal log = new Animal();
    private Animal cat = Animal.CAT;
    @ProAnimal int bear = 4;
    @ProAnimal int tager = 9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        Log.d("Animal","this animal "+ tager);


    }
    public void onClick(View view) {
        ReqServer reqServer = new ReqServer();
        reqServer.testGet(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                List<Subject> data = (List<Subject>) o;
                String str = "";
                for (int i = 0; i < data.size(); i++) {
                    str += "电影名：" + data.get(i).getTitle() + "\n";
                }
                tv.setText(str);
            }
        });


    }

}
