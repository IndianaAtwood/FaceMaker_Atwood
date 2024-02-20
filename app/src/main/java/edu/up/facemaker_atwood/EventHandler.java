package edu.up.facemaker_atwood;

import android.graphics.Color;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class EventHandler implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {

    private Face face;
    private MainActivity main;

    public EventHandler(MainActivity x) {
        main = x;
        face = x.getFace();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (face.buttonChoice == 0) {
            if (seekBar == main.findViewById(R.id.redSeek)) {
                face.hairColor = Color.argb(255, progress, Color.green(face.hairColor), Color.blue(face.hairColor));
            } else if (seekBar == main.findViewById(R.id.greenSeek)) {
                face.hairColor = Color.argb(255, Color.red(face.hairColor), progress, Color.blue(face.hairColor));
            } else if (seekBar == main.findViewById(R.id.blueSeek)) {
                face.hairColor = Color.argb(255, Color.red(face.hairColor), Color.green(face.hairColor), progress);
            }
        }
        else if (face.buttonChoice == 1) {
            if (seekBar == main.findViewById(R.id.redSeek)) {
                face.skinColor = Color.argb(255, progress, Color.green(face.skinColor), Color.blue(face.skinColor));
            } else if (seekBar == main.findViewById(R.id.greenSeek)) {
                face.skinColor = Color.argb(255, Color.red(face.skinColor), progress, Color.blue(face.skinColor));
            } else if (seekBar == main.findViewById(R.id.blueSeek)) {
                face.skinColor = Color.argb(255, Color.red(face.skinColor), Color.green(face.skinColor), progress);
            }
        }
        else if (face.buttonChoice == 2) {
            if (seekBar == main.findViewById(R.id.redSeek)) {
                face.eyeColor = Color.argb(255, progress, Color.green(face.eyeColor), Color.blue(face.eyeColor));
            } else if (seekBar == main.findViewById(R.id.greenSeek)) {
                face.eyeColor = Color.argb(255, Color.red(face.eyeColor), progress, Color.blue(face.eyeColor));
            } else if (seekBar == main.findViewById(R.id.blueSeek)) {
                face.eyeColor = Color.argb(255, Color.red(face.eyeColor), Color.green(face.eyeColor), progress);
            }
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
            face.buttonChoice = 0;
        }
        else if (checkedId == R.id.skinButton) {
            face.buttonChoice = 1;
        }
        else if (checkedId == R.id.eyesButton) {
            face.buttonChoice = 2;
        }
    }
}
