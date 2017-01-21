package com.example.hongu.meterdraw;

import android.os.Handler;

/**
 * Created by hongu on 2016/12/24.
 */

public class SubThreadSample extends Thread {
    private String myName;    //名前
    private long mySpan;      //周期
    private int myloopCount;  //ループ回数
    GraphView graphView; //ビュー
    //float v = 0;
    boolean runflg = true;
    final Handler handler = new Handler();

    //コンストラクタ
    public SubThreadSample(String name, long span, int loopCount, GraphView graphView1) {
        myName = name;
        mySpan = span;
        myloopCount = loopCount;
        graphView = graphView1;
    }

     public void run() {
         while (runflg) {
             for (int i = 0; i < 100; i++) {
                 try {
                     Thread.sleep(100);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

                 //int v = 0;
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                         graphView.v++;
                         graphView.invalidate();
                         System.out.println("debug" + graphView.v);
                     }
                 });

                 try {
                     Thread.sleep(100);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
         }
         runflg = false;
     }

    public void stopRunning(){
        this.runflg = false;
    }
    /*public void setValue(float v){
        this.v = v;
    }*/
}
