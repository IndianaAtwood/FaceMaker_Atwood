package edu.up.facemaker_atwood;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class EventHandler implements SeekBar.OnSeekBarChangeListener,
             RadioGroup.OnCheckedChangeListener,
             AdapterView.OnItemSelectedListener,
             Button.OnClickListener {

    private Face face;
    private MainActivity main;
    private int buttonChoice;
    private int red, green, blue;

    public EventHandler(MainActivity x) {
        main = x;
        face = x.getFace();

        setSeekBars(face.hairColor);
    }

    private void seekBarStartup() {
        red = Color.red(face.hairColor);
        green = Color.green(face.hairColor);
        blue = Color.blue(face.hairColor);
        setSeekBars(face.hairColor);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        Log.i("work", "onProgressChanged was called");
            if (seekBar == main.findViewById(R.id.redSeek)) {
                red = progress;
            } else if (seekBar == main.findViewById(R.id.greenSeek)) {
                green = progress;
            } else if (seekBar == main.findViewById(R.id.blueSeek)) {
                blue = progress;
            }

            if (buttonChoice == 0) {
                face.hairColor = Color.argb(255, red, green, blue);
            } else if (buttonChoice == 1) {
                face.skinColor = Color.argb(255, red, green, blue);
            } else if (buttonChoice == 2) {
                face.eyeColor = Color.argb(255, red, green, blue);
            }
            face.invalidate();
        }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.hairButton) {
            buttonChoice = 0;
            setSeekBars(face.hairColor);
        } else if (checkedId == R.id.skinButton) {
            buttonChoice = 1;
            setSeekBars(face.skinColor);
        } else if (checkedId == R.id.eyesButton) {
            buttonChoice = 2;
            setSeekBars(face.eyeColor);
        }
    }

    private void setSeekBars(int color) {
        red = Color.red(color);
        SeekBar redSeek = main.findViewById(R.id.redSeek);
        redSeek.setProgress(Color.red(color));

        green = Color.green(color);
        SeekBar greenSeek = main.findViewById(R.id.greenSeek);
        greenSeek.setProgress(Color.green(color));

        blue = Color.blue(color);
        SeekBar blueSeek = main.findViewById(R.id.blueSeek);
        blueSeek.setProgress(Color.blue(color));
    }

    @Override
    public void onItemSelected(AdapterView<?> adpt, View v, int pos, long id) {
        if (pos == 0) {
            face.hairStyle = pos;
        } else if (pos == 1) {
            face.hairStyle = pos;
        } else if (pos == 2) {
            face.hairStyle = pos;
        }
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    @Override
    public void onClick(View v) {
        face.hairColor = face.randomizeColor();
        face.skinColor = face.randomizeColor();
        face.eyeColor = face.randomizeColor();
        face.hairStyle = face.rand.nextInt(3);

        if (buttonChoice == 0) {
            setSeekBars(face.hairColor);
        } else if (buttonChoice == 1) {
            setSeekBars(face.skinColor);
        } else if (buttonChoice == 2) {
            setSeekBars(face.eyeColor);
        }
        face.invalidate();
    }
}
