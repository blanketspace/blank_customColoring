package com.example.blank_customcoloring;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 *
 * @author Anne Marie Blank
 * @version 2/8/22
 *
 * class ClickManager serves as the controller for the project
 */
public class ClickManager implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    private PaintBrush lighthouseView;
    private ModelPicture lightModel;
    private TextView myText;
    private SeekBar redSeek;
    private SeekBar blueSeek;
    private SeekBar greenSeek;

    /**
     * ctor for class ClickManager
     *
     * @param pb  the SurfaceView the program is working with
     * @param tv  the TextView to be accessed, is passed in to ensure the onTouch can
     *            find the correct TextView to change-- full credit to Max Woods for helping me
     *            figure this out
     * @param r the red SeekBar, passed in for reasons similar to tv
     * @param b the blue SeekBar ""
     * @param g the green SeekBar ""
     */
    public ClickManager(PaintBrush pb, TextView tv, SeekBar r, SeekBar b, SeekBar g) {
        lighthouseView = pb;
        lightModel = lighthouseView.getModel();
        myText = tv;
        redSeek = r;
        blueSeek = b;
        greenSeek = g;
    }//ctor

    /**
     * onTouch
     *
     * @param view  the view where the touch event originated
     * @param motionEvent  what kind of touch event occurred
     * @return
     */
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
            lightModel.setChosenPaint(theChosen.myPaint);
            lightModel.setComponents(theChosen);

            //tell seekBars to move their sliders to the proper positions
            redSeek.setProgress(Color.red(theChosen.getColor()));
            greenSeek.setProgress(Color.green(theChosen.getColor()));
            blueSeek.setProgress(Color.blue(theChosen.getColor()));

        }
        lighthouseView.invalidate(); //so it knows to redraw itself
        return true;
    }//onTouch

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //changes the value of the correct item's correct color component
        if(seekBar.getId() == R.id.redSeek) {
            lightModel.redComponent = i;
        }
        else if (seekBar.getId() == R.id.blueSeek){
            lightModel.blueComponent = i;
        }
        else if(seekBar.getId() == R.id.greenSeek) {
            lightModel.greenComponent = i;
        }
        lightModel.resetColor();
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
