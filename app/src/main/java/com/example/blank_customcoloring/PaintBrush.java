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
 * @version 2/6/22
 *
 * class PaintBrush implements SurfaceView interface to draw the
 * image on the screen
 */
public class PaintBrush extends SurfaceView {
    private ModelPicture lightModel;

    //colors
    Paint houseColor = new Paint();
    Paint stripesColor = new Paint();
    Paint lightColor = new Paint();
    Paint grassColor = new Paint();
    Paint skyColor = new Paint();
    Paint middleColor = new Paint();

   CustomRect house = new CustomRect("House Body", 0xFFffffff, 400,
           700, 700, 1500);
   CustomRect topStripe = new CustomRect("Top Stripe", 0xFFeb4034,400,
           800, 700, 900);
   CustomRect topMiddleStripe = new CustomRect("Middle Stripe 1", 0xFFeb4034,
           400, 1000, 700, 1100);
   CustomRect bottomMiddleStripe = new CustomRect("Middle Stripe 2", 0xFFeb4034,
           400, 1200, 700, 1300);
   CustomRect bottomStripe = new CustomRect("Bottom Stripe", 0xFFeb4034,
           400, 1400, 700, 1500);
   CustomRect lightBox = new CustomRect("Light", 0xFFffef73, 425,
           400, 675,700);


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
        grassColor.setStyle(Paint.Style.FILL);
        middleColor.setColor(0xFF737778);  //sky blue
        middleColor.setStyle(Paint.Style.FILL);
        setBackgroundColor(0xFF88e8f2);

        lightModel.elements.add(house);
        lightModel.elements.add(topStripe);
        lightModel.elements.add(topMiddleStripe);
        lightModel.elements.add(bottomMiddleStripe);
        lightModel.elements.add(bottomStripe);

    }//ctor

    public ModelPicture getModel() {
        return lightModel;
    }

    /**
     * method that draws the lighthouse
     */
    public void onDraw(Canvas canvas) {
        //grass
        canvas.drawRect(0.0f, 1400.0f, 1500.0f, 2100.0f, grassColor);
        //sky
         // maybe? this.setBackgroundColor();

        //main body
        house.drawMe(canvas);

        //stripes
        topStripe.drawMe(canvas);
        topMiddleStripe.drawMe(canvas);
        bottomMiddleStripe.drawMe(canvas);
        bottomStripe.drawMe(canvas);

        //light
        lightBox.drawMe(canvas);

        //railing thing
        canvas.drawRect(350.0f, 550.0f, 750.0f, 700.0f, middleColor);

        //"hat"
        Path triangle = new Path();
        triangle.moveTo(550.0f, 200.0f);
        triangle.lineTo(800.0f, 400.0f);
        triangle.lineTo(300.0f, 400.0f);
        triangle.lineTo(550.0f, 200.0f);
        triangle.close();
        canvas.drawPath(triangle, middleColor);

    }//onDraw



}//class PaintBrush
