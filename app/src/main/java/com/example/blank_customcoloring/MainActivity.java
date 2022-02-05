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
        PaintBrush lightPaint = findViewById(R.id.drawingBoard);
        lightPaint.setOnTouchListener((View.OnTouchListener) lightPaint); //TODO: this is problematic
        ClickManager karen = new ClickManager(lightPaint);

        //let controller (ClickManager) act as listener for SeekBars
        SeekBar reddy = findViewById(R.id.redSeek);
        reddy.setOnSeekBarChangeListener(karen);
        SeekBar bluey = findViewById(R.id.blueSeek);
        bluey.setOnSeekBarChangeListener(karen);
        SeekBar greenie = findViewById(R.id.greenSeek);
        greenie.setOnSeekBarChangeListener(karen);
    }
}