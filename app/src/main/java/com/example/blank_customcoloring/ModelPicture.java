package com.example.blank_customcoloring;

import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;

/**
 * @author Anne Marie Blank
 * @version 2/6/22
 *
 * class ModelPicture
 */
public class ModelPicture {
    //instance variables for each object's rgbs
    /**TODO: variable to be changed by OnTouch that indicates which part of the drawing is being modified */

    ArrayList<CustomRect> elements = new ArrayList<>();
    CustomRect chosenRect;
    SeekBar myGreen;
    SeekBar myRed;
    SeekBar myBlue;

    public ModelPicture(){

    }

    public CustomRect findRect(int x, int y){
        CustomRect temp = null;
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).containsPoint(x, y)){
                temp = elements.get(i);
                break;
            }
        }
        return temp;
    }

    /**
     * getSeekBars
     *
     * @param v  the View to look in
     * @param choice  an integer to designate which seekBar we're dealing with
     * @return  the SeekBar that matches the above paramaters
     */
    public SeekBar getSeekBars(View v, int choice) {
        if (choice == 1) {
            return myRed;
        }
        else if (choice == 2) {
            return myBlue;
        }
        else if (choice == 3) {
            return myGreen;
        }
        else {
            return null;
        }
    }
}
