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
 * Activities that contain the Nature fragment
 */
public class NatureFragment extends Fragment {

    public NatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootViewNature = inflater.inflate(R.layout.list_items, container, false);

        // Create a list of nature objects
        final ArrayList<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList(R.drawable.nature_aquarium, "Aquarium of Lyon", "More than 5,000 fish from all over the world",
                45.727919, 4.815725, "https://www.aquariumlyon.fr/"));
        itemLists.add(new ItemList(R.drawable.nature_miribel_jonage, "Great Park Miribel Jonage", "Large park, nature & sports activities",
                45.798454, 4.941105, "https://www.grand-parc.fr/"));
        itemLists.add(new ItemList(R.drawable.nature_jardin_botanique, "Botanical Garden of Lyon", "Garden and park",
                45.773156, 4.854833, "https://www.lyon-france.com/"));
        itemLists.add(new ItemList(R.drawable.nature_parc_des_hauteurs, "Park of Heights", "Park and garden",
                45.761876, 4.823521, "http://www.patrimoine-lyon.org/colline-de-fourviere/fourviere/le-parc-des-hauteurs"));
        itemLists.add(new ItemList(R.drawable.nature_parc_tete_d_or, "Park head gold", "Large 19th century park with a lake",
                45.777403, 4.855214, "http://www.loisirs-parcdelatetedor.com/"));
        itemLists.add(new ItemList(R.drawable.nature_jardin_zoologique, "Zoo of Lyon", "Zoo 150 years old, monkeys and zebras",
                45.778441, 4.856714, "http://www.zoo.lyon.fr/zoo/"));
        itemLists.add(new ItemList(R.drawable.nature_jardin_palais_saint_pierre, "Palace Garden Saint-Pierre", "resting area ",
                45.766844, 4.833641, "https://www.ruesdelyon.net/jardin/131-jardin-du-palais-saint-pierre.html-"));
        itemLists.add(new ItemList(R.drawable.nature_parc_sergent_blandan, "Sergent Blandan Park ", "public park of 17 hectares",
                45.745637, 4.854416, "https://www.grandlyon.com/a-vivre/parc-blandan.html"));
        itemLists.add(new ItemList(R.drawable.natrure_mini_world_lyon, "Mini World Lyon", "Parc et parc d'attractions",
                45.764803, 4.923365, "https://miniworldlyon.com/"));

        //Create an Adapter to display the ArrayList in a ListView
        ItemListAdapter listViewAdapter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            listViewAdapter = new ItemListAdapter(Objects.requireNonNull(getActivity()), itemLists);
        }

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = rootViewNature.findViewById(R.id.list);

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

        return rootViewNature;
    }
}
