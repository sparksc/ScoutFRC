package edu.erau.scoutfrc;

import android.net.Uri;
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


/**
 * The EndGameTabFragment class is the Auto tab of the new scouting form. This contains scouting
 * information pertaining to the End Game period of the match.
 *
 * @author Cierra Sparks
 * Date Created: 4/1/2015
 */
public class EndGameTabFragment extends Fragment {
    private Spinner spinnerCollect;
    private EditText other;
    private EditText totalTotes;

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
    public static EndGameTabFragment newInstance(int sectionNumber) {
        EndGameTabFragment fragment = new EndGameTabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Empty Constructor
     */
    public EndGameTabFragment() {
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
     * @return the updated activity view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_end_game_tab, container, false);

        setupWidgets();
        setupTextFields(view);
        setupSpinners(view);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    /**
     * Assign all id's to the appropriate variables.
     */
    public void setupWidgets(){
        // Checkboxes
        CheckBox checkBonus = (CheckBox) getActivity().findViewById(R.id.eCheck_StackYellow);
        CheckBox checkYellowTop = (CheckBox) getActivity().findViewById(R.id.eCheck_StackTop);
        CheckBox checkYellowBottom = (CheckBox) getActivity().findViewById(R.id.eCheck_StackBottom);
        CheckBox checkHP = (CheckBox) getActivity().findViewById(R.id.eCheck_AbleCollect);
        CheckBox checkStacker = (CheckBox) getActivity().findViewById(R.id.eCheck_Stacker);
        CheckBox checkHerder = (CheckBox) getActivity().findViewById(R.id.eCheck_Herder);
        CheckBox checkBinSpecialist = (CheckBox) getActivity().findViewById(R.id.eCheck_BinSpecialist);
        CheckBox checkNoodleSpecialist = (CheckBox) getActivity().findViewById(R.id.eCheck_NoodleSpecialist);
        CheckBox checkInbound = (CheckBox) getActivity().findViewById(R.id.eCheck_Inbound);
        CheckBox checkOther = (CheckBox) getActivity().findViewById(R.id.eCheck_Other);
    }

    /**
     * Assign all id's and listeners to the appropriate EditText fields.
     */
    public void setupTextFields(View v) {
        other = (EditText) v.findViewById(R.id.eText_Notes);
        totalTotes = (EditText) v.findViewById(R.id.eText_NumStacked);

        other.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setENOTES_COLUMN(other.getText().toString());
            }
        });

        totalTotes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setEBONUSTOTAL_COLUMN(totalTotes.getText().toString());
            }
        });
    }

    /**
     * Assign all spinners to their respective id from the layout. Also assign
     * the ArrayAdapters to the appropriate spinners.
     * @param v - the current view
     * @return the view, v
     */
    public View setupSpinners(View v){
        // Assign Spinners
        spinnerCollect = (Spinner) v.findViewById(R.id.eSpinner_CollectWhat);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.eCollectWhat_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCollect.setAdapter(adapter); // Apply the adapter to the spinner

        spinnerCollect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ((ScoutFormActivity) getActivity()).getScoutForm().setEHPCOLLECT_COLUMN(spinnerCollect.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        return v;
    }

    /**
     * Event handler for all checkbox events located in the End Game tab.
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
            case R.id.eCheck_StackYellow:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEBONUSYELLOW_COLUMN("1");
                    sfd.setEBONUSYELLOW_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEBONUSYELLOW_COLUMN("0");
                    sfd.setEBONUSYELLOW_COLUMN("0");
                }
                break;
            case R.id.eCheck_StackTop:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEBONUSTOP_COLUMN("1");
                    sfd.setEBONUSTOP_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEBONUSTOP_COLUMN("0");
                    sfd.setEBONUSTOP_COLUMN("0");
                }
                break;
            case R.id.eCheck_StackBottom:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEBONUSBOTTOM_COLUMN("1");
                    sfd.setEBONUSBOTTOM_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEBONUSBOTTOM_COLUMN("0");
                    sfd.setEBONUSBOTTOM_COLUMN("0");
                }
                break;
            case R.id.eCheck_AbleCollect:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPCOLLECT_COLUMN("1");
                    sfd.setEHPCOLLECT_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPCOLLECT_COLUMN("0");
                    sfd.setEHPCOLLECT_COLUMN("0");
                }
                break;
            case R.id.eCheck_Stacker:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPSTACKER_COLUMN("1");
                    sfd.setEHPSTACKER_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPSTACKER_COLUMN("0");
                    sfd.setEHPSTACKER_COLUMN("0");
                }
                break;
            case R.id.eCheck_Herder:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPHERDER_COLUMN("1");
                    sfd.setEHPHERDER_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPHERDER_COLUMN("0");
                    sfd.setEHPHERDER_COLUMN("0");
                }
                break;
            case R.id.eCheck_BinSpecialist:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPBIN_COLUMN("1");
                    sfd.setEHPBIN_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPBIN_COLUMN("0");
                    sfd.setEHPBIN_COLUMN("0");
                }
                break;
            case R.id.eCheck_NoodleSpecialist:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPNOODLE_COLUMN("1");
                    sfd.setEHPNOODLE_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPNOODLE_COLUMN("0");
                    sfd.setEHPNOODLE_COLUMN("0");
                }
                break;
            case R.id.eCheck_Inbound:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPINBOUND_COLUMN("1");
                    sfd.setEHPINBOUND_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPINBOUND_COLUMN("0");
                    sfd.setEHPINBOUND_COLUMN("0");
                }
                break;
            case R.id.eCheck_Other:
                if (checked) {
                    Log.i("Stack Yellow", "Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPOTHER_COLUMN("1");
                    sfd.setEHPOTHER_COLUMN("1");
                }
                else {
                    Log.i("Stack Yellow", "Un-Checked");
                    //((ScoutFormActivity) getActivity()).getScoutForm().setEHPOTHER_COLUMN("0");
                    sfd.setEHPOTHER_COLUMN("0");
                }
                break;
        }
    }
}
