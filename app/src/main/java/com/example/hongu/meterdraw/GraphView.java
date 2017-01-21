package com.example.hongu.meterdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Paint;

/**
 * Created by hongu on 2016/12/21.
 */

public class GraphView extends View {
    protected int X_SIZE = 270;//GraphSize
    protected int Y_SIZE = 180;//GraphSize
    protected int x0=0, y0 =0;
    protected float vmax=0 , vmin=0;
    protected float[] value = new float[X_SIZE];
    protected String unit="a", title="a";
    protected float v = 0;

    public GraphView(Context context) {
        super(context);
    }

    public GraphView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*public GraphView(Context context, int x0, int y0, float vmin, float vmax, String unit, String title) {
        super(context);
        this.x0 = x0;
        this.y0 = y0;
        this.vmin = vmin;
        this.vmax = vmax;
        this.unit = unit;
        this.title = title;
    }*/
    Paint paint1 = new Paint();



    public void setSize(int X_SIZE, int Y_SIZE) {
        this.X_SIZE = X_SIZE;
        this.Y_SIZE = Y_SIZE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.scale(2.0f, 2.0f);
        super.onDraw(canvas);
        canvas.translate(50, 50);
        this.drawOption(canvas);
        this.drawGraph(v, canvas);
    }

    public void drawOption(Canvas canvas) {

        paint1.setColor(Color.BLACK);
        paint1.setStrokeWidth(2);
        paint1.setTextSize(27);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true);
        canvas.drawText(title, 0, 0, paint1);

        /*Inclement inclement = new Inclement("サンプル", 100);
        inclement.start();*/


        canvas.drawText((int)v + " " + unit, X_SIZE / 2, -10, paint1);

        paint1.setTextSize(12);
        canvas.drawText((int) vmin + unit, X_SIZE + 3, Y_SIZE + 3, paint1);
        canvas.drawText((int) vmax + unit, X_SIZE / 2, 3, paint1);
        RectF rectf = new RectF(0, 0, 2 * Y_SIZE, 2 * Y_SIZE);
        rectf.offset(-Y_SIZE / 2, 0);
        canvas.drawArc(rectf, 270, 90, true, paint1);
    }

    public void drawGraph(float v, Canvas canvas) {
        //pushMatrix(); //storing current coordinate
        //translate(x0,y0);
        Paint paint2 = new Paint();
        paint2.setColor(Color.RED);
        paint2.setStrokeWidth(3);
        paint2.setTextSize(27);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);

        double pi = 3.14159;

        double Rad =  pi * v / 200;
        double _x = X_SIZE - Y_SIZE + Y_SIZE * Math.cos(Rad);
        double _y = Y_SIZE - Y_SIZE  * Math.sin(Rad);

        canvas.drawLine(X_SIZE - Y_SIZE, Y_SIZE, (float) _x, (float) _y, paint2);
    }

    public void setValue(int x0, int y0, float vmin, float vmax, String unit, String title){
        this.x0 = x0;
        this.y0 = y0;
        this.vmin = vmin;
        this.vmax = vmax;
        this.unit = unit;
        this.title = title;
    }

    public class Inclement extends Thread {
        private String myName;    //名前
        private long mySpan;      //周期
        private int myloopCount;  //ループ回数

        //コンストラクタ
        /*public Inclement(String name, int loopCount) {
            myName = name;
            //mySpan = span;
            myloopCount = loopCount;
        }

        public void run() {
            //何かの処理
            for (int i = 0; i < myloopCount; i++) {
                try {
                    v++;
                    sleep(200);
                } catch (Exception e) {
                    // TODO 自動生成された catch ブロック
                    e.printStackTrace();
                }
            }
        }*/


            //translate(0,Y_SIZE);
            //scale(1,-1);
            //noFill();
            //stroke(255);
            //rect(0,0,X_SIZE,Y_SIZE);

        /*for(int i = 0; i < value.length - 1; i++){
            value[i] = value[i+1];
        }
        value[value.length - 1] = ((v - vmin) * Y_SIZE) / (vmax - vmin) ;
        for (int i = 0; i < X_SIZE - 1; i++){
            stroke(0,255,0);
            line(i,value[i],i+1,value[i+1]);
        }
        popMatrix(); //returning stored coordinate
    }
}

    public class ElevatorGraph extends GraphView{
        public ElevatorGraph(Context context ,int x0, int y0, float vmin, float vmax, String unit, String title){
            super(context ,x0, y0, vmin, vmax, unit, title);
        }

        @Override
        public void drawOption(float v){
            super.drawOption(v);
            fill(255);
            textSize(15);
            text("Up", X_SIZE + 5, Y_SIZE - 10);
            text("Down", X_SIZE + 5, 15);
            stroke(255);
            line(0, Y_SIZE/2, X_SIZE + 10, Y_SIZE/2);
        }
    }

    public class RudderGraph extends GraphView{
        public RudderGraph(Context context ,int x0, int y0, float vmin, float vmax, String unit, String title){
            super(context ,x0, y0, vmin, vmax, unit, title);
        }

        @Override
        public void drawOption(float v){
            super.drawOption(v);
            fill(255);
            textSize(15);
            text("Right", X_SIZE + 5, Y_SIZE - 10);
            text("Left", X_SIZE + 5, 15);
            stroke(255);
            line(0, Y_SIZE/2, X_SIZE + 10, Y_SIZE/2);
        }
    }*/
        }
    }

