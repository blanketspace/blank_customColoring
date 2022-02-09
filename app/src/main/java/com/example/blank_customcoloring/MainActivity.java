package com.example.blank_customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;

/**
 * class MainActivity
 *
 * @author Anne Marie Blank
 * @version 2/8/22
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar reddy = findViewById(R.id.redSeek);
        SeekBar bluey = findViewById(R.id.blueSeek);
        SeekBar greenie = findViewById(R.id.greenSeek);
        PaintBrush lightPaint = findViewById(R.id.drawingBoard);  //view is now set up to be the SurfaceView
        ClickManager karen = new ClickManager(lightPaint, findViewById(R.id.componentName), reddy, bluey, greenie);
        lightPaint.setOnTouchListener(karen); //controller set to be listener for touch events on the view

        //let controller (ClickManager) act as listener for SeekBar events
        reddy.setOnSeekBarChangeListener(karen);
        reddy.setProgress(lightPaint.getModel().redComponent);

        bluey.setOnSeekBarChangeListener(karen);
        bluey.setProgress(lightPaint.getModel().blueComponent);

        greenie.setOnSeekBarChangeListener(karen);
        greenie.setProgress(lightPaint.getModel().greenComponent);
    }

}// class MainActivity