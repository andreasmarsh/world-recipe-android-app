package edu.uga.cs.project_2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

/**
 * <h1>Project 2</h1>
 * Project 2 creates a layout where the user can select a region of the world from
 * a spinner and then select either an overview of three recipes from that region
 * or a list of three recipes form that region.
 *
 * @author Andreas Marsh
 * @version 1.0
 * @since 2021-02-23
 */
public class MainActivity extends AppCompatActivity {

    public static final String REGIONTYPE = "edu.uga.cs.project_2.REGIONTYPE";
    private static final String DEBUG_TAG = "edu.uga.cs.project_2";

    public static final int LATIN = 1;
    public static final int EUROPE = 2;
    public static final int ASIA = 3;

    private Spinner spinner;
    private Button  goButton;

    private int     spinnerPos;
    private int     direction;

    private int     leftRadioButtonId;
    private int     rightRadioButtonId;
    private RadioGroup     radioType;

    private int regionType = LATIN;

    /**
     * This method creates the layout that the user sees upon opening the app.
     *
     * @param savedInstanceState This can be used to pass in a Bundle when the app is Paused.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RadioButton leftRadioButton;
        RadioButton rightRadioButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        goButton = findViewById(R.id.button);

        rightRadioButtonId = R.id.radioButton2;
        leftRadioButtonId = R.id.radioButton;
        radioType = findViewById(R.id.radioGroup);

        /*
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        radioType = intent.getIntExtra( StartActivity.CONVTYPE, StartActivity.LENGTHS );

        if( conversionType == StartActivity.LENGTHS ) {
            infoView.setText( "Perform Lengh Conversion\n\nYou can convert from miles to kilometers or vice versa" );
            leftRadioButton.setText( "Miles to Km" );
            rightRadioButton.setText( "Km to Miles" );
        }
        else {
            infoView.setText( "Perform Weight Conversion\n\nYou can convert from pounds to kilograms or vice versa" );
            leftRadioButton.setText( "Pounds to Kg" );
            rightRadioButton.setText( "Kg to Pounds" );
        }
        */

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * Sets regionType var based on user selection of spinner
             *
             * @param parent
             * @param view
             * @param pos
             * @param id
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                if (((String) parent.getItemAtPosition(pos)).equals("Latin America"))
                    regionType = LATIN;
                else if (((String) parent.getItemAtPosition(pos)).equals("Europe"))
                    regionType = EUROPE;
                else if (((String) parent.getItemAtPosition(pos)).equals("Asia"))
                    regionType = ASIA;
                spinnerPos = pos;
            }

            /**
             * If user selects no options do nothing
             *
             * @param parent
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        // sets intent based on what is selected once go button is pressed
        goButton.setOnClickListener(v -> {
            direction = radioType.getCheckedRadioButtonId();

            if (direction == leftRadioButtonId) {
                Intent intent = new Intent(v.getContext(), Overview.class);
                intent.putExtra(REGIONTYPE, regionType);
                v.getContext().startActivity(intent);
            } else if (direction == rightRadioButtonId) {
                Intent intent = new Intent(v.getContext(), Recipes.class);
                intent.putExtra(REGIONTYPE, regionType);
                v.getContext().startActivity(intent);
            }
        });
    }

    /**
     * Saves instance state if app is paused or closed
     *
     * @param savedInstanceState
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        direction = radioType.getCheckedRadioButtonId();

        Log.d(DEBUG_TAG, "MainActivity.onSaveInstanceState(): " + spinnerPos);
        Log.d(DEBUG_TAG, "MainActivity.onSaveInstanceState(): " + regionType);

        // Save values
        savedInstanceState.putInt( "spinnerpos", spinnerPos );
        savedInstanceState.putInt( "direction", direction );

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Sets the buttons from layout based on what was passed through Bundle
     *
     * @param savedInstanceState A Bundle possesing settings for state of layout
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(DEBUG_TAG, "MainActivity.onRestoreInstanceState()" );

        // Restore the counter value
        if( savedInstanceState != null ) {
            spinnerPos = savedInstanceState.getInt("spinnerpos");
            direction = savedInstanceState.getInt("direction");
            spinner.setSelection( spinnerPos );

            Log.d(DEBUG_TAG, "MainActivity.onRestoreInstanceState(): " + spinnerPos);
            Log.d(DEBUG_TAG, "MainActivity.onRestoreInstanceState(): " + direction);
        }

    }
}