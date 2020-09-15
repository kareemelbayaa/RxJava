package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.core.Observable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable observable = Observable.just(1,2,3,4,5);
        observable.doOnNext(c-> Log.d(TAG, "onCreate: upstream"+c +" Thread: "+Thread.currentThread().getName())).subscribe(o-> Log.d(TAG, "onCreate:downstream "+o+" Thread: "+Thread.currentThread().getName()));
    }

    public void sleep(int timeInMilliSeconds)
    {
        try {
            Thread.sleep(timeInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}