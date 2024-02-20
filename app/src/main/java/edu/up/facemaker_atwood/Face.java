package edu.up.facemaker_atwood;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * @author Indiana Atwood
 *
 * @version February 10, 2024
 */
public class Face extends SurfaceView {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    public int buttonChoice;
    private Random rand = new Random();

    /* Paints that we'll use to draw the face */
    Paint skinARGB = new Paint();
    Paint eyeARGB = new Paint();
    Paint hairARGB = new Paint();

    public static final float faceLeft = 100.0f;
    public static final float faceTop = 50.0f;

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        // private variables are given random values using Random class
        skinColor = randomize();
        eyeColor = randomize();
        hairColor = randomize();
        hairStyle = rand.nextInt(3);
    }

    /**
     * Randomizes the private variables between integers 0-2.
     */

    private int randomize() {
        return Color.argb(255, rand.nextInt(256),
                         rand.nextInt(256), rand.nextInt(256));
    }

    private void drawHair() {
        // will add code for Part B
    }

    private void drawEyes() {
        // will add code for Part B
    }

    public void onDraw(Canvas canvas) {
        hairARGB.setColor(hairColor);
        skinARGB.setColor(skinColor);
        eyeARGB.setColor(eyeColor);

        canvas.drawRect(0.0f, 0.0f, 10000.0f, 10000.0f, hairARGB);

        canvas.drawOval(faceLeft, faceTop, faceLeft + 550.0f, faceTop + 600.0f, skinARGB);
        canvas.drawOval(faceLeft + 1100.0f, faceTop, faceLeft + 550.0f, faceTop + 600.0f, eyeARGB);

        drawHair();
        drawEyes();
        // will add code for Part B
    }
}
