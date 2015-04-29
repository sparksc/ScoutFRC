package edu.erau.scoutfrc;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;


/**
 * The TeleopTabFragment class is the Teleop tab of the new scouting form. This contains scouting
 * information pertaining to the Teleoperated period of the match.
 *
 * @author Cierra Sparks
 * Date Created: 4/1/2015
 */
public class TeleopTabFragment extends Fragment {
    private Spinner spinnerTotesWhere;
    private Spinner spinnerControlTotes;
    private Spinner spinnerNumStacked;
    private Spinner spinnerHighStack;
    private Spinner spinnerHow;
    private Spinner spinnerHowMany;
    private Spinner spinnerNumHigh;

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
    public static TeleopTabFragment newInstance(int sectionNumber) {
        TeleopTabFragment fragment = new TeleopTabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Empty Constructor
     */
    public TeleopTabFragment() {
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
     * @return the view of the activity
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teleop_tab, container, false);

        setupWidgets();
        setupSpinners(view);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Assign all id's to the appropriate variables.
     */
    public void setupWidgets(){
        // Checkboxes
        CheckBox checkControl = (CheckBox) getActivity().findViewById(R.id.tCheck_Control);
        CheckBox checkStack = (CheckBox) getActivity().findViewById(R.id.tCheck_StackTotes);
        CheckBox checkPlaceTop = (CheckBox) getActivity().findViewById(R.id.tCheck_TopBins);
        CheckBox checkGoCenter = (CheckBox) getActivity().findViewById(R.id.tCheck_CenterBins);
        CheckBox checkDriveThrough = (CheckBox) getActivity().findViewById(R.id.tCheck_DriveThrough);
        CheckBox checkScoreLitter = (CheckBox) getActivity().findViewById(R.id.tCheck_ScoreLitter);
        CheckBox checkHerd = (CheckBox) getActivity().findViewById(R.id.tCheck_HerdLitter);
        CheckBox checkPickUp = (CheckBox) getActivity().findViewById(R.id.tCheck_PickUpLitter);
    }

    /**
     * Assign all spinners to their respective id from the layout. Also assign
     * the ArrayAdapters to the appropriate spinners.
     * @param v - the current view
     * @return the view, v
     */
    public View setupSpinners(View v){
        // Assign Spinners
        spinnerTotesWhere = (Spinner) v.findViewById(R.id.tSpinner_GetTotes);
        spinnerControlTotes = (Spinner) v.findViewById(R.id.tSpinner_ControlHow);
        spinnerNumStacked = (Spinner) v.findViewById(R.id.tSpinner_NumStacked);
        spinnerHighStack = (Spinner) v.findViewById(R.id.tSpinner_HighestStack);
        spinnerHow = (Spinner) v.findViewById(R.id.tSpinner_LitterHow);
        spinnerHowMany = (Spinner) v.findViewById(R.id.tSpinner_LitterHowMany);
        spinnerNumHigh = (Spinner) v.findViewById(R.id.tSpinner_NumTotesHigh);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.tControlWhere_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTotesWhere.setAdapter(adapter1); // Apply the adapter to the spinner

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.tControl_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerControlTotes.setAdapter(adapter2); // Apply the adapter to the spinner

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.tLitter_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHow.setAdapter(adapter3); // Apply the adapter to the spinner

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.gHowMany_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumStacked.setAdapter(adapter4); // Apply the adapter to the spinner
        spinnerHighStack.setAdapter(adapter4); // Apply the adapter to the spinner
        spinnerHowMany.setAdapter(adapter4); // Apply the adapter to the spinner
        spinnerNumHigh.setAdapter(adapter4); // Apply the adapter to the spinner

        spinnerTotesWhere.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setTWHERE_COLUMN(spinnerTotesWhere.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerControlTotes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setTCONTROLHOW_COLUMN(spinnerControlTotes.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerNumStacked.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setGSTACKNUM_COLUMN(spinnerNumStacked.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerHighStack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setGHIGHSTACK_COLUMN(spinnerHighStack.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerHow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERHOW_COLUMN(spinnerHow.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerHowMany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERNUM_COLUMN(spinnerHowMany.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerNumHigh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERNUM_COLUMN(spinnerNumHigh.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        return v;
    }

    /**
     * Event handler for all checkbox events located in the Teleop tab.
     * Check boxes checked = 1; Unchecked boxes = 0
     *
     * Source: http://developer.android.com/guide/topics/ui/controls/checkbox.html
     *
     * @param view
     */
    public void onCheckboxClicked(View view, ScoutFormData sfd) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.tCheck_Control:
                if (checked) {
                    Log.i("Control", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTCONTROL_COLUMN("1");
                    sfd.setTCONTROL_COLUMN("1");
                }
                else {
                    Log.i("Control", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTCONTROL_COLUMN("0");
                    sfd.setTCONTROL_COLUMN("0");
                }
                    break;
            case R.id.tCheck_StackTotes:
                if (checked) {
                    Log.i("Control", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setGSTACK_COLUMN("1");
                    sfd.setGSTACK_COLUMN("1");
                }
                else {
                    Log.i("Control", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setGSTACK_COLUMN("0");
                    sfd.setGSTACK_COLUMN("0");
                }
                break;
            case R.id.tCheck_TopBins:
                if (checked) {
                    Log.i("Control", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setGHIGHSTACK_COLUMN("1");
                    sfd.setGHIGHSTACK_COLUMN("1");
                }
                else {
                    Log.i("Control", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setGHIGHSTACK_COLUMN("0");
                    sfd.setGHIGHSTACK_COLUMN("0");
                }
                break;
            case R.id.tCheck_CenterBins:
                if (checked) {
                    Log.i("Control", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTBINSCENTER_COLUMN("1");
                    sfd.setTBINSCENTER_COLUMN("1");
                }
                else {
                    Log.i("Control", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTBINSCENTER_COLUMN("0");
                    sfd.setTBINSCENTER_COLUMN("0");
                }
                break;
            case R.id.tCheck_DriveThrough:
                if (checked) {
                    Log.i("Control", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTBINSTHROUGH_COLUMN("1");
                    sfd.setTBINSTHROUGH_COLUMN("1");
                }
                else {
                    Log.i("Control", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTBINSTHROUGH_COLUMN("0");
                    sfd.setTBINSTHROUGH_COLUMN("0");
                }
                break;
            case R.id.tCheck_ScoreLitter:
                if (checked) {
                    Log.i("Control", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERSCORE_COLUMN("1");
                    sfd.setTLITTERSCORE_COLUMN("1");
                }
                else {
                    Log.i("Control", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERSCORE_COLUMN("0");
                    sfd.setTLITTERSCORE_COLUMN("0");
                }
                break;
            case R.id.tCheck_HerdLitter:
                if (checked) {
                    Log.i("Control", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERHERD_COLUMN("1");
                    sfd.setTLITTERHERD_COLUMN("1");
                }
                else {
                    Log.i("Control", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERHERD_COLUMN("0");
                    sfd.setTLITTERHERD_COLUMN("0");
                }
                break;
            case R.id.tCheck_PickUpLitter:
                if (checked) {
                    Log.i("Control", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERPICK_COLUMN("1");
                    sfd.setTLITTERPICK_COLUMN("1");
                }
                else {
                    Log.i("Control", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setTLITTERPICK_COLUMN("0");
                    sfd.setTLITTERPICK_COLUMN("0");
                }
                break;
        }
    }
}
