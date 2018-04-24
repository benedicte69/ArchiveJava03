package com.example.bened.lyoncity.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bened.lyoncity.MapInfoActivity;
import com.example.bened.lyoncity.R;
import com.example.bened.lyoncity.adapters.ItemListAdapter;
import com.example.bened.lyoncity.objects.ItemList;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain the museum fragment
 */
public class MuseumFragment extends Fragment {

    public MuseumFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootViewMuseum = inflater.inflate(R.layout.list_items, container, false);

        // Create a list of museum objects
        final ArrayList<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList(R.drawable.museum_beaux_arts, getString(R.string.museum_title_01), getString(R.string.museum_desc_01),
                45.767109, 151.214028, getString(R.string.museum_web_01)));
        itemLists.add(new ItemList(R.drawable.museum_des_confluences, getString(R.string.museum_title_02), getString(R.string.museum_desc_02),
                45.732649, 4.818213, getString(R.string.museum_web_02)));
        itemLists.add(new ItemList(R.drawable.museum_art_contemporain, getString(R.string.museum_title_03), getString(R.string.museum_desc_03),
                45.784216, 4.852374, getString(R.string.museum_web_03)));
        itemLists.add(new ItemList(R.drawable.museum_maison_des_canuts, getString(R.string.museum_title_04), getString(R.string.museum_desc_04),
                45.777089, 4.834003, getString(R.string.museum_web_04)));
        itemLists.add(new ItemList(R.drawable.museum_gadagne, getString(R.string.museum_title_05), getString(R.string.museum_desc_05),
                45.764041, 4.827593, getString(R.string.museum_web_05)));
        itemLists.add(new ItemList(R.drawable.museum_automate, getString(R.string.museum_title_06), getString(R.string.museum_desc_06),
                45.756247, 4.824026, getString(R.string.museum_web_06)));
        itemLists.add(new ItemList(R.drawable.museum_demeure_du_chaos, getString(R.string.museum_title_07), getString(R.string.museum_desc_07),
                45.837459, 4.826721, getString(R.string.museum_web_07)));
        itemLists.add(new ItemList(R.drawable.museum_lugdunum, getString(R.string.museum_title_08), getString(R.string.museum_desc_08),
                45.760419, 4.819964, getString(R.string.museum_web_08)));
        itemLists.add(new ItemList(R.drawable.museum_tissus_art_deco, getString(R.string.museum_title_09), getString(R.string.museum_desc_09),
                45.753234, 4.831183, getString(R.string.museum_web_09)));
        itemLists.add(new ItemList(R.drawable.museum_institut_lumiere, getString(R.string.museum_title_10), getString(R.string.museum_desc_10),
                45.745211, 4.869649, getString(R.string.museum_web_10)));
        itemLists.add(new ItemList(R.drawable.museum_centre_histoire_resistance, getString(R.string.museum_title_11), getString(R.string.museum_desc_11),
                45.746684, 4.835544, getString(R.string.museum_web_11)));
        itemLists.add(new ItemList(R.drawable.museum_imprimerie, getString(R.string.museum_title_12), getString(R.string.museum_desc_12),
                45.764240, 4.834668, getString(R.string.museum_web_12)));
        itemLists.add(new ItemList(R.drawable.museum_urbain_tony_garnier, getString(R.string.museum_title_13), getString(R.string.museum_desc_13),
                45.733491, 4.862952, getString(R.string.museum_web_13)));
        itemLists.add(new ItemList(R.drawable.museum_miniature_et_cinema, getString(R.string.museum_title_14), getString(R.string.museum_desc_14),
                45.761876, 4.827347, getString(R.string.museum_web_14)));

        //Create an Adapter to display the ArrayList in a ListView
        ItemListAdapter listViewAdapter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            listViewAdapter = new ItemListAdapter(Objects.requireNonNull(getActivity()), itemLists);
        }
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = rootViewMuseum.findViewById(R.id.list);
        // Make the {@link ListView} use the {@link ItemListAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link ItemList} in the list.
        listView.setAdapter(listViewAdapter);

        /*
          Navigates to an other activity
         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * Callback method to be invoked when an item in this AdapterView has
             * been clicked.
             * <p>
             * Implementers can call getItemAtPosition(position) if they need
             * to access the data associated with the selected item.
             *
             * @param parent   The AdapterView where the click happened.
             * @param view     The view within the AdapterView that was clicked (this
             *                 will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             * @param id       The row id of the item that was clicked.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //put in memory the TitleData and the WebLinkData parcel
                Intent intent = new Intent(getActivity(), MapInfoActivity.class);
                intent.putExtra(getString(R.string.java_title_data), itemLists.get(position));
                intent.putExtra(getString(R.string.java_web_link_data), itemLists.get(position));

                //Choose the new activity to be opened
                Intent displayMapInfo = new Intent(getActivity(), MapInfoActivity.class);

                //display the new activity with those parcels in memory
                startActivity(displayMapInfo);
                startActivity(intent);
            }
        });

        return rootViewMuseum;
    }
}






