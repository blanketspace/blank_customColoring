package com.example.blank_customcoloring;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

/**
 *
 * @author Anne Marie Blank
 * @version 2/4/22
 *
 * class ClickManager serves as the controller for the project
 */
public class ClickManager implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    private PaintBrush lighthouseView;
    private ModelPicture lightModel;

    public ClickManager(PaintBrush pb) {
        lighthouseView = pb;
        lightModel = lighthouseView.getModel();

    }//ctor

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //TODO: get drawing to recognize and report that it's been touched
        lighthouseView.invalidate(); //so it knows to redraw itself
        return true;
    }//onTouch

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //TODO: change the value of the correct item's correct color component
        //call color change method in Model?
        //if(seekBar.getId==R.id.redSeek){ then set red component to i

        lighthouseView.invalidate();
    }//onProgressChanged

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }
}//ClickManager
