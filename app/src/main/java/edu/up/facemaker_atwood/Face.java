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
    public int buttonChoice;
    private Random rand;
    private static final int STRAIGHT = 0;
    private static final int SPIKY = 1;
    private static final int CURLY = 2;

    // Paints that we'll use to draw the face
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

    /**
     * Sets each of the instance variables with a random color
     * or integer (corresponding to their usage in Face).
     */
    public void randomizeVariables() {
        skinColor = randomColor();
        eyeColor = randomColor();
        hairColor = randomColor();
        hairStyle = rand.nextInt(3);
        buttonChoice = rand.nextInt(3);
    }

    private int randomColor() {
        return Color.argb(255, rand.nextInt(256),
                         rand.nextInt(256), rand.nextInt(256));
    }

    /**
     * Draws the hair of the face depending on the selection of the Spinner
     * using the custom hair color.
     *
     * @param c is the canvas that the face is drawn to.
     */
    private void drawHair(Canvas c) {
        // if the Spinner is on "Straight", the hair consists of a filled Arc
        //      and two rectangles
        if (hairStyle == STRAIGHT) {
            c.drawArc(faceLeft, faceTop, faceLeft + faceWidth,
                    faceTop + 2*(faceHeight/3), 180, 180, true, hairARGB);
            c.drawRect(faceLeft, faceTop + faceHeight/3,
                    faceLeft + faceWidth/5, faceTop + 2*(faceHeight/3), hairARGB);
            c.drawRect(faceLeft + 4*(faceWidth/5), faceTop + faceHeight/3,
                    faceLeft + faceWidth, faceTop + 2*(faceHeight/3), hairARGB);
        }
        // "Spiky" hair is made of multiple connected points
        else if (hairStyle == SPIKY) {
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
        // "Curly" hair is made of a string of circles
        else if (hairStyle == CURLY) {
            c.drawCircle(faceLeft + 50.0f, faceTop + 100.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 150.0f, faceTop + 75.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 200.0f, faceTop + 50.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 250.0f, faceTop + 50.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 350.0f, faceTop + 75.0f, 75.0f, hairARGB);
            c.drawCircle(faceLeft + 450.0f, faceTop + 125.0f, 75.0f, hairARGB);
        }
    }

    /**
     * Draws the eyes on the face with the custom eye color.
     *
     * @param c is the canvas that the eyes are drawn to.
     */
    private void drawEyes(Canvas c) {
        c.drawOval(faceLeft + faceWidth/3, faceTop + faceHeight/4,
                  faceLeft + faceWidth/5, faceTop + faceHeight/2, eyeARGB);
        c.drawOval(faceLeft + 2*(faceWidth/3), faceTop + faceHeight/4,
                  faceLeft + 4*(faceWidth/5), faceTop + faceHeight/2, eyeARGB);
    }

    /**
     * Sets each paint value with their corresponding Hex color value,
     * and draws the face, hair and eyes onto the canvas.
     *
     * @param canvas is the canvas the face is drawn to.
     */
    public void onDraw(Canvas canvas) {
        // Each Paint is assigned the color that was custom made by SeekBars
        //      or random RGB values (except for the white mouth)
        hairARGB.setColor(hairColor);
        skinARGB.setColor(skinColor);
        eyeARGB.setColor(eyeColor);
        smile.setColor(0xFFFFFFFF); // color white

        // drawing the actual face
        canvas.drawOval(faceLeft, faceTop, faceLeft + faceWidth,
                 faceTop + faceHeight, skinARGB);

        // drawing the smile using a filled Arc
        canvas.drawArc(faceLeft + faceWidth/3, faceTop + 2*(faceHeight/3),
                      faceLeft + 2*(faceWidth/3), faceTop + 4*(faceHeight/5),
                  0,180,true,smile);

        // Eyes and hair are drawn separately, as they depend on other variables
        //      and have larger code blocks
        drawEyes(canvas);
        drawHair(canvas);
    }
}
