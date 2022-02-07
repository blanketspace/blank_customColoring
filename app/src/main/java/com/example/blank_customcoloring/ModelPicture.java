package com.example.blank_customcoloring;

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

}
