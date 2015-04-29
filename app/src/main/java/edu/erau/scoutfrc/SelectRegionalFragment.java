package edu.erau.scoutfrc;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * The SelectRegionalFragment class is located on the top of the home screen.
 * The user can select from one of the events/regionals provided in the spinner. The spinner
 * is populated using a GET Event List request to The Blue Alliance.
 *
 * @author Cierra Sparks
 * @date 3/17/2015
 */
public class SelectRegionalFragment extends Fragment {
    private Spinner spinnerRegional;
    private String response;
    private Parser parse;


    /**
     * This factory method creates a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SelectRegionalFragment.
     */
    public static SelectRegionalFragment newInstance() {
        SelectRegionalFragment fragment = new SelectRegionalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Empty Constructor
     */
    public SelectRegionalFragment() {
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * When the view is created, assign all widgets and listeners.
     *
     * Pass the view v to set up the spinners in a fragment
     * Source: http://stackoverflow.com/questions/9351691/error-populating-spinner-in-a-fragment/12935831#12935831
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_regional, container, false);

        parse = new Parser();
        RetrieveTask task = new RetrieveTask();
        task.execute(new String[]{"http://www.thebluealliance.com/api/v2/events/2015"});

        setupSpinners(view);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Assign all spinners to their respective id from the layout. Also assign
     * the ArrayAdapters to the appropriate spinners.
     *
     * @param v - the current view
     * @return the view, v
     */
    public View setupSpinners(View v){
        // Assign Spinners
        spinnerRegional = (Spinner) v.findViewById(R.id.hsSpinner_regional);

        return v;
    }

    /**
     * Creates an asynchronous task in which retrieves information from the internet that
     * is used to populate spinners within the Fragment.
     *
     * Source1: http://www.javaexperience.com/android-create-non-blocking-user-interface/
     *      Using AsyncTask in Android
     * Source2: http://www.vogella.com/tutorials/AndroidBackgroundProcessing/article.html
     *      7.5. Example: AsyncTask
     */
    private class RetrieveTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String[] urls) {
            String eventResponse = "";

            for (String url : urls) {
                try {
                    eventResponse = HTTPBlueAlliance.GET(url);
                    //Log.i("response", ""+eventResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return eventResponse;
        }



        /**
         * Once the response has been completed, call setCompetitionData() to populate the adapter.
         * @param result - the Event List Request response from The Blue Alliance website
         */
        @Override
        protected void onPostExecute(String result) {
            setCompetitionData(result);
        }

        /**
         * Uses the data response to then parse it for all event names for the current year.
         * The resulting ArrayList of event names is then used to populate the Competition spinner.
         *
         * @param data - the Event List Request response from The Blue Alliance website
         */
        private void setCompetitionData(String data){
            response = data;
            ArrayList<Event> events = parse.EventListParser(response);  // get the current list of event's for the year
            ArrayList<String> eventList = parse.EventListStringParser(events);

            // Create an ArrayAdapter using the string array and a default spinner layout. Gets the
            // event names from The Blue Alliance and loads the names into the spinner.
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(SelectRegionalFragment.this.getActivity(),
                    android.R.layout.simple_spinner_item, eventList);
            // Specify the layout to use when the list of choices appears
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerRegional.setAdapter(adapter3); // Apply the adapter to the spinner
        }
    }
}
