package edu.erau.scoutfrc;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 *
 * @author Cierra Sparks
 */
public class MainActivity extends ActionBarActivity {

    /**
     * Sets the view to the activity_main layout. Then displays the app's icon in the action bar.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // display the app icon on the action bar
        // Source: http://stackoverflow.com/questions/27541802/android-app-icon-doesnt-show-on-actionbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_vortex);
    }

    /**
     * Sets up the action bar with the appropriate menu items to their id.
     * @param menu - the menu for the action bar items
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Add the + button to the ActionBar
        MenuItem newScoutingForm = menu.findItem(R.id.action_new);

        // Add the collapsible searchView to the ActionBar and set the listener
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        // Configure the search info and add any event listeners

        return true;
    }

    /**
     * Handles the event when an item on the Action bar is selected
     *
     * @param item - the menu item from the action bar
     * @return true if an action item was selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Set screen to a new Scouting Form
            case R.id.action_new:
                newScoutingForm();
                return true;
            // Search for the team entered
            case R.id.action_search:
                //openSearch();
                return true;
            // Expand the settings menu
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Creates a new scouting form when the "+" button is pressed from the action bar.
     * http://www.vogella.com/tutorials/AndroidActionBar/article.html#usingactionbar_selectionreaction
     */
    public void newScoutingForm(){
        // Create the intent to start a new activity
        Intent intent = new Intent(this, ScoutFormActivity.class);

        startActivity(intent);
    }
}
