package edu.up.facemaker_atwood;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * @author Indiana Atwood
 *
 * @version February 22, 2024
 */
public class Face extends SurfaceView {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    public Random rand;

    /* Paints that we'll use to draw the face */
    Paint skinARGB = new Paint();
    Paint eyeARGB = new Paint();
    Paint hairARGB = new Paint();
    Paint smile = new Paint();

    public final float faceLeft = 750.0f;
    public final float faceTop = 100.0f;
    public final float faceWidth = 500.0f;
    public final float faceHeight = 600.0f;

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        rand = new Random();

        // private variables are given random values using Random class
        randomizeVariables();
    }

    public void randomizeVariables() {
        skinColor = randomizeColor();
        eyeColor = randomizeColor();
        hairColor = randomizeColor();
        hairStyle = rand.nextInt(3);
    }

    /**
     * Randomizes the private variables between integers 0-2.
     */
    private int randomizeColor() {
        return Color.argb(255, rand.nextInt(256),
                         rand.nextInt(256), rand.nextInt(256));
    }

    private void drawHair(Canvas c) {
        // will add code for Part B
        if (hairStyle == 0) {
            c.drawArc(faceLeft, faceTop, faceLeft + faceWidth,
                    faceTop + 2*(faceHeight/3), 180, 180, true, hairARGB);
            c.drawRect(faceLeft, faceTop + faceHeight/3,
                    faceLeft + faceWidth/5, faceTop + 2*(faceHeight/3), hairARGB);
            c.drawRect(faceLeft + 4*(faceWidth/5), faceTop + faceHeight/3,
                    faceLeft + faceWidth, faceTop + 2*(faceHeight/3), hairARGB);
        }
        else if (hairStyle == 1) {
            Path spiky = new Path();
            spiky.moveTo(faceLeft + 25.0f, faceTop + 100.0f);
            spiky.lineTo(faceLeft + 75.0f, faceTop + 75.0f);
            spiky.lineTo(faceLeft + 50.0f, faceTop + 50.0f);
            spiky.lineTo(faceLeft + 100.0f, faceTop + 50.0f);
            spiky.lineTo(faceLeft + 100.0f, faceTop);
            spiky.lineTo(faceLeft + 150.0f, faceTop - 50.0f);
            spiky.lineTo(faceLeft + 195.0f, faceTop - 25.0f);
            spiky.lineTo(faceLeft + 350.0f, faceTop - 50.0f);
            spiky.lineTo(faceLeft + 400.0f, faceTop - 25.0f);
            spiky.lineTo(faceLeft + 400.0f, faceTop);
            spiky.lineTo(faceLeft + 450.0f, faceTop);
            spiky.lineTo(faceLeft + 425.0f, faceTop + 25.0f);
            spiky.lineTo(faceLeft + 475.0f, faceTop + 50.0f);
            spiky.lineTo(faceLeft + 450.0f, faceTop + 50.0f);
            spiky.lineTo(faceLeft + 425.0f, faceTop + 75.0f);
            spiky.lineTo(faceLeft + 475.0f, faceTop + 100.0f);
            spiky.lineTo(faceLeft + 300.0f, faceTop + 75.0f);
            spiky.lineTo(faceLeft + 300.0f, faceTop + 100.0f);
            spiky.lineTo(faceLeft + 150.0f, faceTop + 55.0f);

            c.drawPath(spiky, hairARGB);
        }
        else if (hairStyle == 2) {
            c.drawCircle(faceLeft + 50.0f, faceTop + 100.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 150.0f, faceTop + 75.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 200.0f, faceTop + 50.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 250.0f, faceTop + 50.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 350.0f, faceTop + 75.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 450.0f, faceTop + 125.0f, 75.0f, hairARGB);
        }
    }

    private void drawEyes(Canvas c) {
        // will add code for Part B
        c.drawOval(faceLeft + faceWidth/3, faceTop + faceHeight/4,
                  faceLeft + faceWidth/5, faceTop + faceHeight/2, eyeARGB);
        c.drawOval(faceLeft + 2*(faceWidth/3), faceTop + faceHeight/4,
                  faceLeft + 4*(faceWidth/5), faceTop + faceHeight/2, eyeARGB);
    }

    public void onDraw(Canvas canvas) {
        hairARGB.setColor(hairColor);
        skinARGB.setColor(skinColor);
        eyeARGB.setColor(eyeColor);
        smile.setColor(0xFFFFFFFF);

        canvas.drawOval(faceLeft, faceTop, faceLeft + faceWidth,
                 faceTop + faceHeight, skinARGB);

        canvas.drawArc(faceLeft + faceWidth/3, faceTop + 2*(faceHeight/3),
                      faceLeft + 2*(faceWidth/3), faceTop + 4*(faceHeight/5),
                  0,180,true,smile);

        drawEyes(canvas);
        drawHair(canvas);
        // will add code for Part B
    }
}
