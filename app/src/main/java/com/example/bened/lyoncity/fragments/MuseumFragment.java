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
        itemLists.add(new ItemList(R.drawable.museum_beaux_arts, "Museum of Fine Arts of Lyon", "Art and ancient and modern objects",
                45.767109, 151.214028, "http://www.mba-lyon.fr/mba/"));
        itemLists.add(new ItemList(R.drawable.museum_des_confluences, "Museum of Confluences", "Anthropology exhibition, modern building",
                45.732649, 4.818213, "http://www.museedesconfluences.fr/"));
        itemLists.add(new ItemList(R.drawable.museum_art_contemporain, "Museum of Contemporary Art of Lyon", "Exhibitions of contemporary art and coffee",
                45.784216, 4.852374, "http://www.mac-lyon.com/mac/"));
        itemLists.add(new ItemList(R.drawable.museum_maison_des_canuts, "House of the Canuts", "Exhibitions on the silk of the city",
                45.777089, 4.834003, "http://maisondescanuts.com/"));
        itemLists.add(new ItemList(R.drawable.museum_gadagne, "Museums Gadagne", "History of the city and puppets",
                45.764041, 4.827593, "http://www.gadagne.musees.lyon.fr/"));
        itemLists.add(new ItemList(R.drawable.museum_automate, "Museum of Automata of old Lyon", "Museum",
                45.756247, 4.824026, "https://www.museeautomates.com/"));
        itemLists.add(new ItemList(R.drawable.museum_demeure_du_chaos, "House of Chaos", "Museum Contemporary Art Outdoor",
                45.837459, 4.826721, "http://www.organe.org/"));
        itemLists.add(new ItemList(R.drawable.museum_lugdunum, "Lugdunum", "Museum with Roman objects and antiquities",
                45.760419, 4.819964, "http://www.museegalloromain.grandlyon.com/"));
        itemLists.add(new ItemList(R.drawable.museum_tissus_art_deco, "Museum of Fabrics and Decorative Arts", "Museum of Fabrics and Decorative Arts",
                45.753234, 4.831183, "http://www.mtmad.fr/fr/Pages/default.aspx"));
        itemLists.add(new ItemList(R.drawable.museum_institut_lumiere, "Institute Light", "Museum and cinema with projections",
                45.745211, 4.869649, "http://www.institut-lumiere.org/"));
        itemLists.add(new ItemList(R.drawable.museum_centre_histoire_resistance, "Center for the History of Resistance and Deportation", "Museum on the 2nd World War in Lyon",
                45.746684, 4.835544, "http://www.chrd.lyon.fr/chrd/"));
        itemLists.add(new ItemList(R.drawable.museum_imprimerie, "Printing Museum", "Museum, history of local printing",
                45.764240, 4.834668, "http://www.imprimerie.lyon.fr/imprimerie/"));
        itemLists.add(new ItemList(R.drawable.museum_urbain_tony_garnier, "Tony-Garnier Urban Museum", "Murals, local architecture",
                45.733491, 4.862952, "http://www.museeurbaintonygarnier.com/"));
        itemLists.add(new ItemList(R.drawable.museum_miniature_et_cinema, "Miniature Museum and Cinema", "Miniature scenes & movie props",
                45.761876, 4.827347, "https://www.museeminiatureetcinema.fr/"));

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
                intent.putExtra("TitleData", itemLists.get(position));
                intent.putExtra("WebLinkData", itemLists.get(position));

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






