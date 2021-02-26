package edu.uga.cs.project_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.TextView;
import android.widget.ImageView;
import android.os.Bundle;
import java.io.InputStream;

/**
 * <h1>Recipes</h1>
 * Recipes creates a layout where based on the passed Intent,
 * displays three recipes from a certain region of the world.
 *
 * @author Andreas Marsh
 * @version 1.0
 * @since 2021-02-23
 */
public class Recipes extends AppCompatActivity {

    private int         regionType;

    /**
     * This method creates the layout that the user sees upon entering Recipes tab.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView    regionTitle;
        TextView    recipe1Text;
        ImageView   recipe1Pic;
        TextView    recipe2Text;
        ImageView   recipe2Pic;
        TextView    recipe3Text;
        ImageView   recipe3Pic;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        regionTitle = findViewById( R.id.textView5 );
        recipe1Text = findViewById( R.id.textView2 );
        recipe1Pic = findViewById( R.id.imageView );
        recipe2Text = findViewById( R.id.textView3 );
        recipe2Pic = findViewById( R.id.imageView2 );
        recipe3Text = findViewById( R.id.textView4 );
        recipe3Pic = findViewById( R.id.imageView3 );

        // get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        regionType = intent.getIntExtra( MainActivity.REGIONTYPE, MainActivity.LATIN );

        // change what is displayed based on region selected
        if( regionType == MainActivity.LATIN ) {
            // set title
            regionTitle.setText("Latin America");

            // set picture for first recipe
            recipe1Pic.setImageResource( R.drawable.latin_recipe_one);
            // set recipe text for first recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.latin_recipe_one );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                recipe1Text.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                recipe1Text.setText( "Error: can't show info text." );
            }

            // set picture for second recipe
            recipe2Pic.setImageResource( R.drawable.latin_recipe_two);
            // set recipe text for second recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.latin_recipe_two );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                recipe2Text.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                recipe2Text.setText( "Error: can't show info text." );
            }

            // set picture for third recipe
            recipe3Pic.setImageResource( R.drawable.latin_recipe_three);
            // set recipe text for third recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.latin_recipe_three );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                recipe3Text.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                recipe3Text.setText( "Error: can't show info text." );
            }
        }
        else if( regionType == MainActivity.ASIA ) {
                // set title
                regionTitle.setText("Asia");

                // set picture for first recipe
                recipe1Pic.setImageResource( R.drawable.asia_recipe_one);
                // set recipe text for first recipe
                try {
                    // Gain access to the app's resources
                    Resources res = getResources();
                    // Open a rw resource (a file) for reading and read it's content into a byte array
                    InputStream in_s = res.openRawResource( R.raw.asia_recipe_one );
                    byte[] b = new byte[ in_s.available() ];
                    in_s.read( b );
                    // Display the content of the file as a TextView content
                    recipe1Text.setText( new String(b) );
                } catch (Exception e) {
                    // e.printStackTrace();
                    recipe1Text.setText( "Error: can't show info text." );
                }

                // set picture for second recipe
                recipe2Pic.setImageResource( R.drawable.asia_recipe_two);
                // set recipe text for second recipe
                try {
                    // Gain access to the app's resources
                    Resources res = getResources();
                    // Open a rw resource (a file) for reading and read it's content into a byte array
                    InputStream in_s = res.openRawResource( R.raw.asia_recipe_two );
                    byte[] b = new byte[ in_s.available() ];
                    in_s.read( b );
                    // Display the content of the file as a TextView content
                    recipe2Text.setText( new String(b) );
                } catch (Exception e) {
                    // e.printStackTrace();
                    recipe2Text.setText( "Error: can't show info text." );
                }

                // set picture for third recipe
                recipe3Pic.setImageResource( R.drawable.asia_recipe_three);
                // set recipe text for third recipe
                try {
                    // Gain access to the app's resources
                    Resources res = getResources();
                    // Open a rw resource (a file) for reading and read it's content into a byte array
                    InputStream in_s = res.openRawResource( R.raw.asia_recipe_three );
                    byte[] b = new byte[ in_s.available() ];
                    in_s.read( b );
                    // Display the content of the file as a TextView content
                    recipe3Text.setText( new String(b) );
                } catch (Exception e) {
                    // e.printStackTrace();
                    recipe3Text.setText( "Error: can't show info text." );
                }
            }

        else if( regionType == MainActivity.EUROPE ) {
            // set title
            regionTitle.setText("Europe");

            // set picture for first recipe
            recipe1Pic.setImageResource(R.drawable.euro_recipe_one);
            // set recipe text for first recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.euro_recipe_one);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipe1Text.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipe1Text.setText("Error: can't show info text.");
            }

            // set picture for second recipe
            recipe2Pic.setImageResource(R.drawable.euro_recipe_two);
            // set recipe text for second recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.euro_recipe_two);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipe2Text.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipe2Text.setText("Error: can't show info text.");
            }

            // set picture for third recipe
            recipe3Pic.setImageResource(R.drawable.euro_recipe_three);
            // set recipe text for third recipe
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource(R.raw.euro_recipe_three);
                byte[] b = new byte[in_s.available()];
                in_s.read(b);
                // Display the content of the file as a TextView content
                recipe3Text.setText(new String(b));
            } catch (Exception e) {
                // e.printStackTrace();
                recipe3Text.setText("Error: can't show info text.");
            }
        }
    }
}