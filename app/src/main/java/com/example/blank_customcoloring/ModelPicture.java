package com.example.blank_customcoloring;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * @author Anne Marie Blank
 * @version 2/8/22
 *
 * class ModelPicture
 */
public class ModelPicture {
    ArrayList<CustomRect> elements = new ArrayList<>();
    CustomRect chosenRect;
    Paint chosenPaint;

    //instance variables for each object's rgbs
    int redComponent;
    int blueComponent;
    int greenComponent;
    int alphaComponent;

    public ModelPicture() {
        chosenPaint = new Paint();
        alphaComponent = 0xFF;
    }//ctor


    /**
     *findRect
     *
     * method to assist in determining whether or not a touch happened in a given element
     */
    public CustomRect findRect(int x, int y){
        CustomRect temp = null;
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i).containsPoint(x, y)){
                temp = elements.get(i);
                break;
            }
        }
        return temp;
    }// findRect

    /**
     * setComponents
     *
     * sets the rgb values in this Model to reflect those in the chosen Element's Paint
     * @param chosenRect  the Element that has been selected by the user
     */
    public void setComponents(CustomRect chosenRect){
        greenComponent = Color.green(chosenRect.getColor());
        redComponent = Color.red(chosenRect.getColor());
        blueComponent = Color.blue(chosenRect.getColor());
    }// setComponents

    public void setChosenPaint(Paint p){
        chosenPaint = p;
    }

    public Paint resetColor(){
       chosenPaint.setARGB(alphaComponent, redComponent, greenComponent, blueComponent);
       return chosenPaint;
    }

}//class ModelPicture
