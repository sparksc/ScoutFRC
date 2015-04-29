package edu.erau.scoutfrc;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.erau.scoutfrc.dummy.DummyContent;

/**
 * List fragment used to display all saved scouting forms.
 *
 * @author Cierra Sparks
 */
public class ScoutDataInfo extends ListFragment {
    ArrayList<String> viewData;
    FormDBHandler scoutFormDB;

    // TODO: Rename and change types of parameters
    public static ScoutDataInfo newInstance() {
        ScoutDataInfo fragment = new ScoutDataInfo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ScoutDataInfo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the database from the intent
        //viewData = getActivity().getIntent().getExtras().getStringArrayList("scoutDB");

        Bundle bundle = this.getArguments();
        if(bundle != null){
            viewData = bundle.getStringArrayList("scoutDB");
        }

        setListAdapter(new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, viewData));
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
