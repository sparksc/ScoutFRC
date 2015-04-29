package edu.erau.scoutfrc;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * The AutoTabFragment class is the Auto tab of the new scouting form. This contains scouting
 * information pertaining to the Auto period of the match. The Competition, Team number, and
 * Match Number spinners are all populated by using GET requests to The Blue Alliance website
 * to get the most current information. Therefor it requires an internet connection.
 *
 * @author Cierra Sparks
 * Date Created: 4/1/2015
 */
public class AutoTabFragment extends Fragment {
    private Spinner spinnerComp;
    private Spinner spinnerPosition;
    private Spinner spinnerMany1;
    private Spinner spinnerMany2;
    private Spinner spinnerMany3;
    private Spinner spinnerMove;
    private EditText number;
    private EditText match;
    private EditText scouterName;
    private Parser parse;
    private String response;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     *
     * @return A new instance of fragment
     */
    public static AutoTabFragment newInstance(int sectionNumber) {
        AutoTabFragment fragment = new AutoTabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Empty public Constructor
     */
    public AutoTabFragment() {
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
        View view = inflater.inflate(R.layout.fragment_auto_tab, container, false);

        parse = new Parser();

        // TODO: Populate spinnerComp, spinnerTeam, and spinnerMatch with GET requests; then parse
        RetrieveTask task = new RetrieveTask();
        task.execute(new String[]{"http://www.thebluealliance.com/api/v2/events/2015"});

        setupWidgets();
        setupTextFields(view);
        setupSpinners(view);

        // Inflate the layout for this fragment
        return view;
    }

    /**
     * Assign all id's to the appropriate variables.
     */
    public void setupWidgets(){
        // Checkboxes
        CheckBox checkMove = (CheckBox) getActivity().findViewById(R.id.aCheck_Move);
        CheckBox checkPush = (CheckBox) getActivity().findViewById(R.id.aCheck_Push);
        CheckBox checkStack = (CheckBox) getActivity().findViewById(R.id.aCheck_StackTotes);
        CheckBox checkRecycleBins = (CheckBox) getActivity().findViewById(R.id.aCheck_MoveRecycleBins);
        CheckBox checkCenterField = (CheckBox) getActivity().findViewById(R.id.aCheck_GoCenter);
        CheckBox checkGrey = (CheckBox) getActivity().findViewById(R.id.aCheck_MoveGreyTotes);
    }

    /**
     * Assign all id's and listeners to the appropriate EditText fields.
     */
    public void setupTextFields(View v) {
        number = (EditText) v.findViewById(R.id.aText_Team);
        match = (EditText) v.findViewById(R.id.aText_Match);
        scouterName = (EditText) v.findViewById(R.id.aText_Scouter);

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setTEAMUMBER_COLUMN(number.getText().toString());
            }
        });

        match.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setMATCH_COLUMN(match.getText().toString());
            }
        });

        scouterName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setSCOUTERNAME_COLUMN(scouterName.getText().toString());
            }
        });
    }

    /**
     * Assign all spinners to their respective id from the layout. Also assign
     * the ArrayAdapters to the appropriate spinners.
     *
     * Set the onItemSelected Listener
     * Source: http://stackoverflow.com/questions/9857127/adding-onitemselectedlistener-to-spinner
     *
     * @param v - the current view
     * @return the view, v
     */

    public View setupSpinners(View v){
        // Assign Spinners
        spinnerComp = (Spinner) v.findViewById(R.id.aSpinner_Comp);
        //spinnerTeam = (Spinner) v.findViewById(R.id.aSpinner_Team);
        //spinnerMatch = (Spinner) v.findViewById(R.id.aSpinner_Match);
        spinnerPosition = (Spinner) v.findViewById(R.id.aSpinner_StartingPos);
        spinnerMany1 = (Spinner) v.findViewById(R.id.aSpinner_HowMany1);
        spinnerMany2 = (Spinner) v.findViewById(R.id.aSpinner_HowMany2);
        spinnerMany3 = (Spinner) v.findViewById(R.id.aSpinner_HowMany3);
        spinnerMove = (Spinner) v.findViewById(R.id.aSpinner_HowMany4);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.aStartingPos_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPosition.setAdapter(adapter1); // Apply the adapter to the spinner

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.gHowMany_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMany1.setAdapter(adapter2); // Apply the adapter to the spinner
        spinnerMany2.setAdapter(adapter2); // Apply the adapter to the spinner
        spinnerMany3.setAdapter(adapter2); // Apply the adapter to the spinner
        spinnerMove.setAdapter(adapter2); // Apply the adapter to the spinner

        spinnerComp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setCOMPETITION_COLUMN(spinnerComp.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setPOSITION_COLUMN(spinnerPosition.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerMany1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setAYPUSHNUM_COLUMN(spinnerMany1.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerMany2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setAYSTACKNUM_COLUMN(spinnerMany2.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerMany3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setARMOVENUM_COLUMN(spinnerMany3.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerMove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setARCENTERNUM_COLUMN(spinnerMove.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        return v;
    }

    /**
     * Event handler for all checkbox events located in the Auto tab.
     * Check boxes checked = 1; Unchecked boxes = 0
     * Source: http://developer.android.com/guide/topics/ui/controls/checkbox.html
     *
     * @param view - the activity's view
     */
    public void onCheckboxClicked(View view, ScoutFormData sfd) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.aCheck_Move:
                if (checked){
                    Log.i("Move in Auto", "Checked");
                    sfd.setAYMOVE_COLUMN("1");
                }
                else {
                    Log.i("Move in Auto", "Un-Checked");
                    sfd.setAYMOVE_COLUMN("0");
                }
                break;
            case R.id.aCheck_Push:
                if (checked) {
                    Log.i("Push Totes", "Checked");
                    sfd.setAYPUSH_COLUMN("1");
                }
                else {
                    Log.i("Push Totes", "Un-Checked");
                    sfd.setAYPUSH_COLUMN("0");
                }
                break;
            case R.id.aCheck_StackTotes:
                if (checked) {
                    Log.i("Stack Totes", "Checked");
                    sfd.setAYSTACK_COLUMN("1");
                }
                else {
                    Log.i("Stack Totes", "Un-Checked");
                    sfd.setAYSTACK_COLUMN("0");
                }
                break;
            case R.id.aCheck_MoveRecycleBins:
                if (checked) {
                    Log.i("Move Bins", "Checked");
                    sfd.setARMOVE_COLUMN("1");
                }
                else {
                    Log.i("Move Bins", "Un-Checked");
                    sfd.setARMOVE_COLUMN("0");
                }
                break;
            case R.id.aCheck_GoCenter:
                if (checked) {
                    Log.i("Go Center", "Checked");
                    sfd.setARCENTER_COLUMN("1");
                }
                else {
                    Log.i("Go Center", "Un-Checked");
                    sfd.setARCENTER_COLUMN("0");
                }
                break;
            case R.id.aCheck_MoveGreyTotes:
                if (checked) {
                    Log.i("Move Grey", "Checked");
                    sfd.setAGMOVE_COLUMN("1");
                }
                else {
                    Log.i("Move Grey", "Un-Checked");
                    sfd.setAGMOVE_COLUMN("0");
                }
                break;
        }
    }

    /**
     * Creates an asynchronous task in which retrieves information from the internet that
     * is used to populate spinners within the AutoTab Fragment.
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
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(AutoTabFragment.this.getActivity(),
                    android.R.layout.simple_spinner_item, eventList);
            // Specify the layout to use when the list of choices appears
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerComp.setAdapter(adapter3); // Apply the adapter to the spinner
        }
    }
}
