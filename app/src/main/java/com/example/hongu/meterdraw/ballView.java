package com.example.hongu.meterdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hongu on 2016/12/20.
 */

public class ballView extends View {
    public ballView(Context context) {
        super(context);
    }

    public ballView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint();


    Resources res = getResources();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.yakyuboru);
        canvas.drawBitmap(bmp, 0, 0,mPaint);

        canvas.scale(2.5f, 2.5f);
        canvas.drawBitmap(bmp, 0, 0, mPaint);

    }
}
