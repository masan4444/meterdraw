package com.example.hongu.meterdraw;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

//import static com.example.hongu.meterdraw.R.id.graphView1;
//よろぴこ
public class MainActivity extends AppCompatActivity {

    float ppap;
    SubThreadSample subThreadSample;
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraphView graphView;   //= new GraphView(this, 100, 100, 0, 100, "a", "sample");
        //GraphView graphView1;  //= new GraphView(this, 100, 100, 0, 100, "b", "sample2");
        //GraphView graphView2;  //= new GraphView(this, 100, 100, 0, 100, "c", "sample3");


        graphView = (GraphView) findViewById(R.id.view) ;
        //graphView1 = (GraphView) findViewById(R.id.graphView1) ;
        //graphView2 = (GraphView) findViewById(R.id.graphView2) ;
        //ballView ballView = new ballView(this);



        //setContentView(graphView);

        //LinearLayout linearLayout = new LinearLayout(this);
        setContentView(R.layout.activity_main);

        graphView.setValue(100, 100, 0, 100, "メートル", "Sample");

        //graphView1.setValue(100, 100, 0, 50, "グラム", "重さ");
        //graphView2.setValue(100, 100, 0, 200, "cm", "高さ");

        /*linearLayout.addView(graphView, new LinearLayout.LayoutParams(WC, WC));
        linearLayout.addView(graphView1, new LinearLayout.LayoutParams(WC, WC));
        linearLayout.addView(graphView2, new LinearLayout.LayoutParams(WC, WC));*/


        subThreadSample = new SubThreadSample("a", 100, 100, graphView);
        subThreadSample.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subThreadSample.stopRunning();
    }
}
