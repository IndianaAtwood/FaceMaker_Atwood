package edu.up.facemaker_atwood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * @author Indiana Atwood
 *
 * @version February 10, 2024
 */
public class MainActivity extends AppCompatActivity {
    private Face originalFace;

    public MainActivity() {
        // the face is created upon running the program
        originalFace = new Face();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_main);

        // Spinner must be connected to array of Strings (called hair_styles)
        Spinner hairStyles = findViewById(R.id.styleSpinner);

        /**
         External Citation
         Date: 10 February 2024
         Problem: Was unsure how to add string values to the Spinner
         Resource:
                https://developer.android.com/develop
                /ui/views/components/spinner#java
         Solution: I used the example Java code from this post.
         */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.hair_styles,
                android.R.layout.simple_spinner_item);

        // sets the adapter as a resource that "drops down" the choices
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        // connects the Spinner to the adapter (and the values)
        hairStyles.setAdapter(adapter);
    }
}