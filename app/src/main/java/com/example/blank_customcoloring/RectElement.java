package com.example.blank_customcoloring;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class RectElement {
    /**
     * list of things needed:
     *
     * method to calculate area (so we know when the touch event is no longer on the
     * element)
     * ctor: params: all the ones drawRect takes
     * method to return the name that will display in the TextView
     *
     * IF TIME PERMITS:
     * add a highlight to indicate which elements will be changed
     */

      private CharSequence myName;
      private Paint myColor;
      private float myArea = -1.0f;


          public RectElement(CharSequence name){
              myName = name;
          }
          public void drawRect(float l, float t, float r, float b, Paint color, Canvas c){
              c.drawRect(l, t, r, b, color);
          }

          public CharSequence getName(){
              return myName;
          }

          public Paint getColor() {
              return myColor;
          }

          public void setColor(Paint newColor) {
             this.myColor = newColor;
          }

          public float getArea(RectElement rectangle){

              return myArea;
          }
}
