package edu.up.facemaker_atwood;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

/**
 * @author Indiana Atwood
 *
 * @version February 22, 2024
 */
public class EventHandler implements SeekBar.OnSeekBarChangeListener,
             RadioGroup.OnCheckedChangeListener,
             AdapterView.OnItemSelectedListener,
             Button.OnClickListener {

    private Face face;
    private MainActivity main;
    private int red, green, blue;
    private RadioButton button;
    private Spinner hairOptions;
    private static final int HAIR = 0;
    private static final int SKIN = 1;
    private static final int EYES = 2;

    /**
     * Sets the first face upon startup with random RGB values
     * for a random face selection (hair, skin or eyes).
     *
     * @param x passes the MainActivity to the class, in which
     *          it can derive the necessary components from Face.
     */
    public EventHandler(MainActivity x) {
        main = x;
        face = x.getFace();
        hairOptions = main.findViewById(R.id.styleSpinner);

        itemStartup();
    }

    /**
     * Used on startup and from the Random Face button, this method will set
     * the progress of each SeekBar depending on the RGB value of the hair,
     * skin or eyes. Also sets Spinner with random selection.
     */
    private void itemStartup() {
        // calls setSeekBars() to set the RGB values for the color
        if (face.buttonChoice == HAIR) {
            button = main.findViewById(R.id.hairButton);
            setSeekBars(face.hairColor);
        }
        else if (face.buttonChoice == SKIN) {
            button = main.findViewById(R.id.skinButton);
            setSeekBars(face.skinColor);
        }
        else if (face.buttonChoice == EYES) {
            button = main.findViewById(R.id.eyesButton);
            setSeekBars(face.eyeColor);
        }
        // the button for the corresponding face part is selected on screen
        button.setChecked(true);

        // the Spinner is set to the randomly selected hairStyle
        hairOptions.setSelection(face.hairStyle);
    }

    /**
     * Sets the SeekBars with the correct RGB values of the color passed to it.
     *
     * @param color is the color we want to find the RGB values of.
     */
    private void setSeekBars(int color) {
        // takes the RGB values of the color, and assigns them to each SeekBar
        red = Color.red(color);
        SeekBar redSeek = main.findViewById(R.id.redSeek);
        redSeek.setProgress(red);

        green = Color.green(color);
        SeekBar greenSeek = main.findViewById(R.id.greenSeek);
        greenSeek.setProgress(green);

        blue = Color.blue(color);
        SeekBar blueSeek = main.findViewById(R.id.blueSeek);
        blueSeek.setProgress(blue);
    }

    /**
     * When the progress of a SeekBar is altered, the RGB values are used
     * to create a new color that is sent back to the variables in Face.
     *
     * @param seekBar is used to determine which SeekBar called this method.
     * @param progress is used to assign the RGB values to the given slider
     *                 position.
     * @param b is unused.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        // sets the RGB instance variables to the progress of the SeekBar
        if (seekBar == main.findViewById(R.id.redSeek)) {
            red = progress;
        }
        else if (seekBar == main.findViewById(R.id.greenSeek)) {
            green = progress;
        }
        else if (seekBar == main.findViewById(R.id.blueSeek)) {
            blue = progress;
        }

        // changes the color corresponding to the type of button selected
        if (face.buttonChoice == HAIR) {
            face.hairColor = Color.argb(255, red, green, blue);
        }
        else if (face.buttonChoice == SKIN) {
            face.skinColor = Color.argb(255, red, green, blue);
        }
        else if (face.buttonChoice == EYES) {
            face.eyeColor = Color.argb(255, red, green, blue);
        }
        // redraws the face to reflect the changed values
        face.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

    /**
     * Updates the buttonChoice to the selected button, and resets the
     * progress bars of the SeekBars to their corresponding RGB values.
     *
     * @param group is unused.
     * @param checkedId is used to determine which RadioButton was selected.
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // updates buttonChoice to reflect the selected RadioButton
        if (checkedId == R.id.hairButton) {
            face.buttonChoice = HAIR;
            // the SeekBars' progress is reassigned to the chosen face part
            setSeekBars(face.hairColor);
        }
        else if (checkedId == R.id.skinButton) {
            face.buttonChoice = SKIN;
            setSeekBars(face.skinColor);
        }
        else if (checkedId == R.id.eyesButton) {
            face.buttonChoice = EYES;
            setSeekBars(face.eyeColor);
        }
    }

    /**
     * Will reassign the hairStyle type with the selection that the given
     * position. The hairStyle variable is used to draw the face.
     *
     * @param parent is unused.
     * @param v is unused.
     * @param pos is used to assign the hairStyle tracker
     *            with the given position.
     * @param id is unused.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View v,
                               int pos, long id) {
        if (pos == 0) {
            face.hairStyle = pos;
        }
        else if (pos == 1) {
            face.hairStyle = pos;
        }
        else if (pos == 2) {
            face.hairStyle = pos;
        }
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    /**
     * Randomizes the face by reassigning the instance variables, the SeekBars
     * and the Spinner selection.
     *
     * @param v a is unused in this case.
     */
    @Override
    public void onClick(View v) {
        // variables are reset to random ones
        face.randomizeVariables();

        // the SeekBars are reset to reflect new random variables
        itemStartup();

        face.invalidate();
    }
}
