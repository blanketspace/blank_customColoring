package com.example.blank_customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * @author Anne Marie Blank
 * @version 2/4/22
 *
 * class PaintBrush implements SurfaceView interface to draw the
 * image on the screen
 */
public class PaintBrush extends SurfaceView {
    private ModelPicture lightModel;

    //TODO: instance variables, for sizing
    //private float houseWidth = 100.0f;
    //private float houseHeight = 300.0f;

    //colors
    Paint houseColor = new Paint();
    Paint stripesColor = new Paint();
    Paint lightColor = new Paint();
    Paint grassColor = new Paint();
    Paint roofColor = new Paint();
    Paint skyColor = new Paint();
    Paint middleColor = new Paint();



    public PaintBrush(Context context, AttributeSet attrs) {
        super(context, attrs);
        lightModel = new ModelPicture();

        setWillNotDraw(false);

        //set up the initial color scheme
        houseColor.setColor(0xFFffffff);    //white
        houseColor.setStyle(Paint.Style.FILL);
        stripesColor.setColor(0xFFeb4034);  //red
        stripesColor.setStyle(Paint.Style.FILL);
        lightColor.setColor(0xFFffef73);    //yellow
        lightColor.setStyle(Paint.Style.FILL);
        grassColor.setColor(0xFF77b35b);    //darkish green
        grassColor.setStyle(Paint.Style.FILL);
        roofColor.setColor(0xFF701500);    //maroon
        grassColor.setStyle(Paint.Style.FILL);
        middleColor.setColor(0xFF737778);  //sky blue
        middleColor.setStyle(Paint.Style.FILL);
        setBackgroundColor(0xFF88e8f2);
    }//ctor

    public ModelPicture getModel() {
        return lightModel;
    }

    //TODO: methods for drawing components
    /**
     * method that draws the lighthouse
     */
    public void onDraw(Canvas canvas) {
        //grass
        canvas.drawRect(0.0f, 1400.0f, 1500.0f, 2100.0f, grassColor);
        //sky
         // maybe? this.setBackgroundColor();

        //main body
        canvas.drawRect(400.0f, 700.0f, 700.0f, 1500.0f, houseColor);

        //stripes
        canvas.drawRect(400.0f, 800.0f, 700.0f, 900.0f, stripesColor);
        canvas.drawRect(400.0f, 1000.0f, 700.0f, 1100.0f, stripesColor);
        canvas.drawRect(400.0f, 1200.0f, 700.0f, 1300.0f, stripesColor);
        canvas.drawRect(400.0f, 1400.0f, 700.0f, 1500.0f, stripesColor);

        //light
        canvas.drawRect(425.0f, 400.0f, 675.0f,700.0f, lightColor);


        //railing thing
        canvas.drawRect(350.0f, 550.0f, 750.0f, 700.0f, middleColor);


        //"hat"
        Path triangle = new Path();
        triangle.moveTo(550.0f, 200.0f);
        triangle.lineTo(800.0f, 400.0f);
        triangle.lineTo(300.0f, 400.0f);
        triangle.lineTo(550.0f, 200.0f);
        triangle.close();
        canvas.drawPath(triangle, roofColor);

    }//onDraw

}//class PaintBrush
