package com.dahuozi.threadblcok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.tv);
        //违反一UI线程的第一条规定 主线程阻塞，开启工作线程
//        while (true){
//            count++;
//            try {
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            textView.setText(count+"");
//        }
    //违反了UI线程模型的第二条规则， 非UI线程不能操作UI工具包
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    count++;
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    textView.setText(count+"");
                }

            }
        }).start();
    }

}
