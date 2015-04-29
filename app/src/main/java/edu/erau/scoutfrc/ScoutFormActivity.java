package edu.erau.scoutfrc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ScoutFormActivity extends ActionBarActivity {
    private static final int AUTO = 0;
    private static final int TELEOP = 1;
    private static final int END_GAME= 2;

    private Fragment[] fragments;
    AutoTabFragment autoTabFragment;
    TeleopTabFragment teleopTabFragment;
    EndGameTabFragment endGameTabFragment;
    private FormDBHandler scoutFormDB;
    public ScoutFormData sfd;
    ArrayList<String> viewData;


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout_form);

        // display the app icon on the action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_vortex);

        // Create a blank scouting form
        sfd = new ScoutFormData(" "," "," "," "," ","0","0","0","0","0","0","0","0","0","0","0"," "," ","0",
                "0","0","0","0","0","0","0"," ","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"," ");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        setupFragmentTabs();
    }

    /**
     * Creates a new instance of all three tabs of the Scouting form.
     */
    public void setupFragmentTabs(){
        autoTabFragment = new AutoTabFragment();
        teleopTabFragment = new TeleopTabFragment();
        endGameTabFragment = new EndGameTabFragment();

        scoutFormDB = new FormDBHandler((this));
        if(scoutFormDB.isEmpty()) {
            try{
                loadDatabase();
                Log.i("Scouted DB", "Database loaded from file.");
            } catch (IOException io){
                io.printStackTrace();
                System.exit(0);
            }
        }
        else{
            Log.i("Scouted DB","Database Already Exists. No load from file.");
        }
    }

    /**
     * Loads the database
     * @throws IOException
     */
    public void loadDatabase() throws IOException
    {
        List<ScoutFormData> data = scoutFormDB.getScoutedData();
        viewData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            String info = "Team "+ data.get(i).getTEAMUMBER_COLUMN() +" - "+ data.get(i).getCOMPETITION_COLUMN() +": Match "+ data.get(i).getMATCH_COLUMN();
            viewData.add(info);
            Log.i("Data: ", "" + info);
        }
    }

    public ScoutFormData getScoutForm(){
        return sfd;
    }

    /**
     * Called when the user presses the submit form button. Saves the scouted information into the DB.
     */
    public void addNewScoutForm(){
        Log.i("Updating DB ", sfd.toString());
        scoutFormDB.addScoutedData(sfd);
    }

    /**
     * Create the Action bar and add the appropriate items.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scout_form, menu);

        MenuItem scoutDataItem = menu.findItem(R.id.action_storage);

        // Add the collapsible searchView to the ActionBar and set the listener
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        // Configure the search info and add any event listeners
        return true;
    }

    /**
     * Handle the events for the Action bar items.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_storage:
                try{
                    loadDatabase();
                    Log.i("Scouted DB", "Database loaded from file.");
                } catch (IOException io){
                    io.printStackTrace();
                    System.exit(0);
                }

                // Pass data from activity to fragment using bundles
                //Source: http://stackoverflow.com/questions/15392261/android-pass-dataextras-to-a-fragment
                ScoutDataInfo fragment = new ScoutDataInfo();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("scoutDB", viewData);
                fragment.setArguments(bundle);

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
     * Listener for checkbox selections. Passes the selected/deselected checkbox to the
     * appropriate fragment to handle the correct action for that checkbox.
     *
     * Source: http://stackoverflow.com/questions/6091194/how-to-handle-button-clicks-using-the-xml-onclick-within-fragments
     * @param v
     */
    public void CheckBoxClickMethod(View v){
        autoTabFragment.onCheckboxClicked(v, sfd);
        teleopTabFragment.onCheckboxClicked(v, sfd);
        endGameTabFragment.onCheckboxClicked(v, sfd);
    }

    /**
     * Commits all information to the database when the Submit button is pressed.
     * @param v - the current view
     */
    public void SubmitForm(View v){
        Button submit = (Button) findViewById(R.id.eSubmitBtn);
        addNewScoutForm();
        Toast.makeText(getApplicationContext(), "Scouting Form Saved", Toast.LENGTH_SHORT).show();
    }

    /**
     * Resets all data in the current scouting form.
     * @param v - the current view
     */
    public void ResetForm(View v){
        Button reset = (Button) findViewById(R.id.eResetBtn);
        autoTabFragment = new AutoTabFragment();
        teleopTabFragment = new TeleopTabFragment();
        endGameTabFragment = new EndGameTabFragment();
        sfd = new ScoutFormData(" "," "," "," "," ","0","0","0","0","0","0","0","0","0","0","0"," "," ","0",
                "0","0","0","0","0","0","0"," ","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"," ");
        Toast.makeText(getApplicationContext(), "Scouting Form Reset", Toast.LENGTH_SHORT).show();
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new Fragment[3];
        }

        /**
         * Populate the different tabs with the appropriate fragment in the Scouting Form.
         *
         * Source: http://stackoverflow.com/questions/22737168/how-to-use-actionbar-viewpager-and-fragments-and-correctly-replace-fragments-in
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);

            //Fragment frag;
            switch(position){
                case AUTO:
                    if(fragments[AUTO] == null) {
                        fragments[AUTO] = AutoTabFragment.newInstance(position + 1);
                    }
                    break;
                case TELEOP:
                    if(fragments[TELEOP] == null) {
                        fragments[TELEOP] = TeleopTabFragment.newInstance(position + 1);
                    }
                    break;
                case END_GAME:
                    if(fragments[END_GAME] == null) {
                        fragments[END_GAME] = EndGameTabFragment.newInstance(position + 1);
                    }
                    break;
            }
            return fragments[position];
        }

        /**
         * @return the total number of tabs
         */
        @Override
        public int getCount() {
            // Show 3 total pages.
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.auto).toUpperCase(l);
                case 1:
                    return getString(R.string.teleop).toUpperCase(l);
                case 2:
                    return getString(R.string.endGame).toUpperCase(l);
            }
            return null;
        }
    }
}
