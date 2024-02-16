package edu.up.facemaker_atwood;

import android.graphics.Canvas;
import java.util.Random;
import android.graphics.Color;

/**
 * @author Indiana Atwood
 *
 * @version February 15, 2024
 */
public class Face {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;
    private Random rand = new Random();

    /**
     * Sets each color integer to a random ARGB value.
     * Sets hairStyle to a random int between 0-2,
     *    which will correstpond to different hair types.
     */
    public Face() {
        // private variables are given random values using Random class
        skinColor = randomize();
        eyeColor = randomize();
        hairColor = randomize();
        hairStyle = rand.nextInt(3);
    }

    /**
     * Generates a random ARGB value (with full opacity).
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
        drawHair();
        drawEyes();
        // will add code for Part B
    }
}
