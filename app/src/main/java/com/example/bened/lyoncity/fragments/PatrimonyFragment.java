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
        itemLists.add(new ItemList(R.drawable.patrimony_teatre_antique, "Amphitheater of the Three Gauls", "Roman Amphitheater of 19 AD",
                45.770584, 4.830532, "https://www.lyon-france.com/Je-decouvre-Lyon/Sites-et-monuments/Antique/Amphitheatre-des-Trois-Gaules"));
        itemLists.add(new ItemList(R.drawable.patrimony_hotel_dieu, "Hotel Dieu of Lyon", "Old hospital bordering the river",
                45.758857, 4.836919, "http://www.eiffageconstruction.com/metiers/realisations/reconversion-grand-hotel-dieu-lyon"));
        itemLists.add(new ItemList(R.drawable.patrimony_tour_metallique_fourviere, "Fourvière metal lathe", "Architecture",
                45.763878, 4.822344, "https://www.lyon-france.com/Je-decouvre-Lyon/Sites-et-monuments/Sites-et-monuments-remarquables/La-Tour-Metallique"));
        itemLists.add(new ItemList(R.drawable.patrimony_vieux_lyon, "Old Lyon", "Architecture, renaissance, cathedral and history",
                45.762981, 4.828020, "http://www.lyon-visite.info/vieux-lyon/"));
        itemLists.add(new ItemList(R.drawable.patrimony_quartier_croix_rousse, "The Croix-Rousse", "Urban art, convent, weaving and garden",
                45.778800, 4.825804, "http://www.patrimoine-lyon.org/la-colline-de-la-croix-rousse"));
        itemLists.add(new ItemList(R.drawable.patrimony_primatiale_saint_jean, "Primatiale Saint-Jean of Lyon", "Cathedral with 14th century treasures",
                45.760801, 4.827290, "https://fr.wikipedia.org/wiki/Primatiale_Saint-Jean_de_Lyon"));
        itemLists.add(new ItemList(R.drawable.patrimony_eglise_saint_georges, "St. George's Church of Lyon", "Church",
                45.757680, 4.825356, "https://fr.wikipedia.org/wiki/%C3%89glise_Saint-Georges_de_Lyon"));
        itemLists.add(new ItemList(R.drawable.patrimony_basilique_fourviere, "Basilica of Our Lady of Fourviere", "High Church, Museum of Religious Art",
                45.762293, 4.822626, "http://www.fourviere.org/"));
        itemLists.add(new ItemList(R.drawable.patrimony_temple_du_change, "Temple of the Change", "Church and architecture",
                45.764452, 4.827929, "https://fr.wikipedia.org/wiki/Temple_du_Change"));
        itemLists.add(new ItemList(R.drawable.patrimony_eglise_saint_nizier, "Saint-Nizier Church of Lyon", "Gothic church with a rich heritage",
                45.764707, 4.833673, "https://fr.wikipedia.org/wiki/%C3%89glise_Saint-Nizier_de_Lyon"));
        itemLists.add(new ItemList(R.drawable.patrimony_place_bellecour, "Place Bellecour", "Large pedestrian public square",
                45.757795, 4.832316, "http://www.patrimoine-lyon.org/la-presqu-ile/centre-ville-2/la-place-bellecour"));
        itemLists.add(new ItemList(R.drawable.patrimony_prison_montluc, "Prison Montluc", "History",
                45.750413, 4.861934, "http://www.memorial-montluc.fr/"));
        itemLists.add(new ItemList(R.drawable.patrimony_hotel_de_ville, "Lyon City Hall", "Imposing historic site, city hall",
                45.767707, 4.835709, "https://www.lyon.fr/lieu/moderne-17eme-18eme/hotel-de-ville-de-lyon"));
        itemLists.add(new ItemList(R.drawable.patrimony_fontaine_bartholdi, "Bartholdi Fountain", "Historic monument, famous sculptor",
                45.767632, 4.833463, "https://www.lyon-france.com/Je-decouvre-Lyon/Sites-et-monuments/Sites-et-monuments-remarquables/La-Fontaine-Bartholdi"));
        itemLists.add(new ItemList(R.drawable.patrimony_opera_de_lyon, "Lyon Opera", "Opera, concert and architecture",
                45.767792, 4.836613, "http://www.opera-lyon.com/fr"));
        itemLists.add(new ItemList(R.drawable.patrimony_fresque_canuts, "Fresco of the Canuts", "Painting",
                45.778085, 4.827952, "http://www.visitelyon.fr/murs-peints/mur,des,canuts/mur,des,canuts.php"));
        itemLists.add(new ItemList(R.drawable.patrimoine_freque_des_lyonnais, "Fresco of Lyonnais", "Painting",
                45.768086, 4.828025, "http://www.visitelyon.fr/murs-lyonnais.php"));

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
                intent.putExtra("TitleData", itemLists.get(position));
                intent.putExtra("WebLinkData", itemLists.get(position));

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





