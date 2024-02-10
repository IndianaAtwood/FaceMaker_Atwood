package edu.up.facemaker_atwood;

import android.graphics.Canvas;
import java.util.Random;

/**
 * @author Indiana Atwood
 *
 * @version February 10, 2024
 */
public class Face {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;
    private Random rand;

    public Face() {
        // private variables are given random values using Random class
        rand = new Random();
        randomize();
    }

    private void randomize() {
        // each variable is given an integer between 0-2
        skinColor = rand.nextInt(3);
        eyeColor = rand.nextInt(3);
        hairColor = rand.nextInt(3);
        hairStyle = rand.nextInt(3);
    }

    private void drawHair() {
        // will add code for Part B
    }

    private void drawEyes() {
        // will add code for Part B
    }

    public void onDraw(Canvas canvas) {
        // will add code for Part B
    }
}
