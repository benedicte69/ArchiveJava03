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
 * Activities that contain the patrimony fragment
 */
public class PatrimonyFragment extends Fragment {
    public PatrimonyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootViewPatrimony = inflater.inflate(R.layout.list_items, container, false);

        // Create a list of patrimony objects
        final ArrayList<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList(R.drawable.patrimony_teatre_antique, getString(R.string.patrimony_title_01), getString(R.string.patrimony_desc_01),
                45.770584, 4.830532, getString(R.string.patrimony_web_01)));
        itemLists.add(new ItemList(R.drawable.patrimony_hotel_dieu, getString(R.string.patrimony_title_02), getString(R.string.patrimony_desc_02),
                45.758857, 4.836919, getString(R.string.patrimony_web_02)));
        itemLists.add(new ItemList(R.drawable.patrimony_tour_metallique_fourviere, getString(R.string.patrimony_title_03), getString(R.string.patrimony_desc_03),
                45.763878, 4.822344, getString(R.string.patrimony_web_03)));
        itemLists.add(new ItemList(R.drawable.patrimony_vieux_lyon, getString(R.string.patrimony_title_04), getString(R.string.patrimony_desc_04),
                45.762981, 4.828020, getString(R.string.patrimony_web_04)));
        itemLists.add(new ItemList(R.drawable.patrimony_quartier_croix_rousse, getString(R.string.patrimony_title_05), getString(R.string.patrimony_desc_05),
                45.778800, 4.825804, getString(R.string.patrimony_web_05)));
        itemLists.add(new ItemList(R.drawable.patrimony_primatiale_saint_jean, getString(R.string.patrimony_title_06), getString(R.string.patrimony_desc_06),
                45.760801, 4.827290, getString(R.string.patrimony_web_06)));
        itemLists.add(new ItemList(R.drawable.patrimony_eglise_saint_georges, getString(R.string.patrimony_title_07), getString(R.string.patrimony_desc_07),
                45.757680, 4.825356, getString(R.string.patrimony_web_07)));
        itemLists.add(new ItemList(R.drawable.patrimony_basilique_fourviere, getString(R.string.patrimony_title_08), getString(R.string.patrimony_desc_08),
                45.762293, 4.822626, getString(R.string.patrimony_web_08)));
        itemLists.add(new ItemList(R.drawable.patrimony_temple_du_change, getString(R.string.patrimony_title_09), getString(R.string.patrimony_desc_09),
                45.764452, 4.827929, getString(R.string.patrimony_web_09)));
        itemLists.add(new ItemList(R.drawable.patrimony_eglise_saint_nizier, getString(R.string.patrimony_title_10), getString(R.string.patrimony_desc_10),
                45.764707, 4.833673, getString(R.string.patrimony_web_10)));
        itemLists.add(new ItemList(R.drawable.patrimony_place_bellecour, getString(R.string.patrimony_title_11), getString(R.string.patrimony_desc_11),
                45.757795, 4.832316, getString(R.string.patrimony_web_11)));
        itemLists.add(new ItemList(R.drawable.patrimony_prison_montluc, getString(R.string.patrimony_title_12), getString(R.string.patrimony_desc_12),
                45.750413, 4.861934, getString(R.string.patrimony_web_12)));
        itemLists.add(new ItemList(R.drawable.patrimony_hotel_de_ville, getString(R.string.patrimony_title_13), getString(R.string.patrimony_desc_13),
                45.767707, 4.835709, getString(R.string.patrimony_web_13)));
        itemLists.add(new ItemList(R.drawable.patrimony_fontaine_bartholdi, getString(R.string.patrimony_title_14), getString(R.string.patrimony_desc_14),
                45.767632, 4.833463, getString(R.string.patrimony_web_14)));
        itemLists.add(new ItemList(R.drawable.patrimony_opera_de_lyon, getString(R.string.patrimony_title_15), getString(R.string.patrimony_desc_15),
                45.767792, 4.836613, getString(R.string.patrimony_web_15)));
        itemLists.add(new ItemList(R.drawable.patrimony_fresque_canuts, getString(R.string.patrimony_title_16), getString(R.string.patrimony_desc_16),
                45.778085, 4.827952, getString(R.string.patrimony_web_16)));
        itemLists.add(new ItemList(R.drawable.patrimoine_freque_des_lyonnais, getString(R.string.patrimony_title_17), getString(R.string.patrimony_desc_17),
                45.768086, 4.828025, getString(R.string.patrimony_web_17)));

        //Create an Adapter to display the ArrayList in a ListView
        ItemListAdapter listViewAdapter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            listViewAdapter = new ItemListAdapter(Objects.requireNonNull(getActivity()), itemLists);
        }

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = rootViewPatrimony.findViewById(R.id.list);
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

        return rootViewPatrimony;
    }
}





