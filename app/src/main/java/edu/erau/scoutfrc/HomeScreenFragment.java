package edu.erau.scoutfrc;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


/**
 * This fragment creates the home screen for the scouting app. This fragment
 * consists of a GridLayout that displays all teams or all teams competing at
 * the selected competition. To select a competition, there is a Spinner at the
 * top of the screen with all available regional competitions for the current
 * season. The teams displayed within the GridLayout display a picture of the
 * team's robot (if a picture is available), the team's number, and the team's
 * name. All teams are displayed in numerical order, from least to greatest.
 *
 * @author Cierra Sparks
 * @date 3/17/2015
 */
public class HomeScreenFragment extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeScreenFragment newInstance() {
        HomeScreenFragment fragment = new HomeScreenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Empty Constructor
     */
    public HomeScreenFragment() {
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Inflates the fragment to fir the device's screen.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        GridView gridview = (GridView) view.findViewById(R.id.gridview);
        /*gridview.setAdapter(new ImageAdapter(this.getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(HomeScreenFragment.this.getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });*/

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
