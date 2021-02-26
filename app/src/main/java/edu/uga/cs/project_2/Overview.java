package edu.uga.cs.project_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.TextView;
import android.widget.ImageView;
import android.os.Bundle;

import java.io.InputStream;

/**
 * <h1>Overview</h1>
 * Overview creates a layout where based on the passed Intent,
 * displays information about three foods from a certain region of the world.
 *
 * @author Andreas Marsh
 * @version 1.0
 * @since 2021-02-23
 */
public class Overview extends AppCompatActivity {

    private int         regionType;

    /**
     * This method creates the layout that the user sees upon entering Overview tab.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView    regionTitle;
        TextView    regionText;
        ImageView   regionPic;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        regionTitle = findViewById( R.id.textView6 );
        regionText = findViewById( R.id.textView7 );
        regionPic = findViewById( R.id.imageView4 );

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        regionType = intent.getIntExtra( MainActivity.REGIONTYPE, MainActivity.LATIN );

        // Use Intent to display specific region info
        if( regionType == MainActivity.LATIN ) {

            regionTitle.setText("Latin America");
            regionPic.setImageResource( R.drawable.latin_overview);

            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.latin_text );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                regionText.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                regionText.setText( "Error: can't show info text." );
            }
        }
        else if( regionType == MainActivity.ASIA ) {

            regionTitle.setText("Asia");
            regionPic.setImageResource( R.drawable.asia_overview);

            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.asia_text );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                regionText.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                regionText.setText( "Error: can't show info text." );
            }
        }
        else if( regionType == MainActivity.EUROPE ) {

            regionTitle.setText("Europe");
            regionPic.setImageResource( R.drawable.euro_overview);

            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.euro_text );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                regionText.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                regionText.setText( "Error: can't show info text." );
            }
        }
    }
}