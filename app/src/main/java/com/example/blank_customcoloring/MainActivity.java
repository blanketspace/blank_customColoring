package com.example.blank_customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PaintBrush lightPaint = findViewById(R.id.drawingBoard);  //view is now set up to be the SurfaceView
        ClickManager karen = new ClickManager(lightPaint);
        lightPaint.setOnTouchListener(karen); //controller set to be listener for touch events on the view

        //let controller (ClickManager) act as listener for SeekBar events
        SeekBar reddy = findViewById(R.id.redSeek);
        reddy.setOnSeekBarChangeListener(karen);
        SeekBar bluey = findViewById(R.id.blueSeek);
        bluey.setOnSeekBarChangeListener(karen);
        SeekBar greenie = findViewById(R.id.greenSeek);
        greenie.setOnSeekBarChangeListener(karen);
    }
}