package com.example.nekto404.objmove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {


    TextView tv;
    float mX;
    float mY;
    String mCoords = "";
    View rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // инициализируем нужные элементы
        tv = (TextView) findViewById(R.id.tv);
        rl =  findViewById(R.id.rl);
        // назначаем слушателя касания для Layout-а
        rl.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mX = event.getX();
        mY = event.getY();

        // переключатель в зависимости от типа события
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
            case MotionEvent.ACTION_MOVE: // движение
                mCoords = "Coords: x = " + mX + ", y = " + mY;
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                // ничего не делаем
                break;
        }
        tv.setText(mCoords);
        return true;
    }
}
