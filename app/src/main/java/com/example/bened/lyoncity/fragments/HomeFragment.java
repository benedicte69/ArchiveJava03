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

import com.example.bened.lyoncity.R;
import com.example.bened.lyoncity.WebViewActivity;
import com.example.bened.lyoncity.adapters.HomeItemListAdapter;
import com.example.bened.lyoncity.objects.ItemList;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain the home fragment
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootViewHome = inflater.inflate(R.layout.list_items, container, false);

        // Create a list of home objects
        final ArrayList<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList(R.drawable.lyon_home_guide, "Enjoy a guided tour", "https://www.visiterlyon.com/"));
        itemLists.add(new ItemList(R.drawable.lyon_home_break, "Have a break", "https://www.heurebleue.fr/ou-sortir-a-lyon/"));
        itemLists.add(new ItemList(R.drawable.lyon_home_move, "Move your way", "http://www.lyon-renaissance.com/se-deplacer-a-lyon/"));

        //Create an Adapter to display the ArrayList in a ListView
        HomeItemListAdapter listViewAdapter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            listViewAdapter = new HomeItemListAdapter(Objects.requireNonNull(getActivity()), itemLists);
        }
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = rootViewHome.findViewById(R.id.list);
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
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("TitleData", itemLists.get(position));
                intent.putExtra("WebLinkData", itemLists.get(position));

                //Choose the new activity to be opened
                Intent displayWebView = new Intent(getActivity(), WebViewActivity.class);

                //display the new activity with those parcels in memory
                startActivity(displayWebView);
                startActivity(intent);
            }
        });

        return rootViewHome;
    }
}
