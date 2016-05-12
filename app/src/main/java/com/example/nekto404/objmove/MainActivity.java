package com.example.nekto404.objmove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {


    TextView tv;
    float mX;
    float mY;
    String mCoords = "";
    View rl;
    ImageView el;
    int heightview;
    int widthview;
    DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // инициализируем нужные элементы
        tv = (TextView) findViewById(R.id.tv);
        rl = findViewById(R.id.rl);
        el = (ImageView) findViewById(R.id.imageView);
        // назначаем слушателя касания для Layout-а
        rl.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mX = event.getX();
        mY = event.getY();

        // переключатель в зависимости от типа события
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        heightview = metrics.heightPixels;
        widthview = metrics.widthPixels;

        // переключатель в зависимости от типа события
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
            case MotionEvent.ACTION_MOVE: // движение

                mCoords = "Coords: x = " + mX + ", y = " + mY;
                el.setTranslationX(mX - widthview / 2);
                el.setTranslationY(mY - heightview / 2);
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                // ничего не делае
                // break;
        }
        tv.setText(mCoords);
        return true;
    }
}