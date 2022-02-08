package com.example.blank_customcoloring;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 *
 * @author Anne Marie Blank
 * @version 2/7/22
 *
 * class ClickManager serves as the controller for the project
 */
public class ClickManager implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    private PaintBrush lighthouseView;
    private ModelPicture lightModel;
    private TextView myText;

    /**
     * ctor for class ClickManager
     *
     * @param pb  the SurfaceView the program is working with
     * @param tv  the TextView to be accessed, is passed in to ensure the onTouch can
     *            find the correct TextView to change-- full credit to Max Woods for helping me
     *            figure this out
     */
    public ClickManager(PaintBrush pb, TextView tv) {
        lighthouseView = pb;
        lightModel = lighthouseView.getModel();
        myText = tv;
    }//ctor

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //get drawing to recognize and report that it's been touched
        int x= (int)motionEvent.getX();
        int y= (int)motionEvent.getY();
        CustomRect theChosen = lightModel.findRect(x, y); //variable to store the rectangle that's been touched
        lightModel.chosenRect = theChosen;
        if(theChosen != null) {
            //change TextView to show name of selected rectangle
            CharSequence textName = theChosen.getName();
            myText.setText(textName);

            //TODO: tell seekBars to move their sliders to the proper positions
           SeekBar redOne = lighthouseView.getModel().getSeekBars(lighthouseView, 1);
           redOne.setProgress(theChosen.getColor()); //TODO: same problem as before, returns null
        }


        lighthouseView.invalidate(); //so it knows to redraw itself
        return true;
    }//onTouch

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //TODO: change the value of the correct item's correct color component

        //call a color change method in Model?
        if(seekBar.getId() == R.id.redSeek) {
            int redTemp = i;
            //lightModel.chosenRect.setColor();
        }
        else if (seekBar.getId() == R.id.blueSeek){

        }
        else if(seekBar.getId() == R.id.greenSeek) {

        }
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
