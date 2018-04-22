package com.example.bened.lyoncity.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bened.lyoncity.R;
import com.example.bened.lyoncity.objects.ItemList;

import java.util.ArrayList;

public class HomeItemListAdapter extends ArrayAdapter<ItemList> {

    /**
     * Constructor displaying the ArrayList
     *
     * @param context   The current context.
     * @param itemLists The ArrayList object
     */

    public HomeItemListAdapter(@NonNull Activity context, @NonNull ArrayList<ItemList> itemLists) {
        super(context, 0, itemLists);
    }

    /**
     * Inflates the ArrayList in a view
     *
     * @param position    The current page.
     * @param convertView The view in the list_wrapper layout
     * @param parent      The  list in the list_item layout
     * @return The ArrayList inflated
     */

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_home_wrapper, parent, false);
        }

        // Get the {@link ItemList} object located at this position in the list
        ItemList currentItemList = getItem(position);

        // Find the ImageView in the list_wrapper layout displaying the image
        ImageView imageWrapper = listItemView.findViewById(R.id.image_home_wrapper);
        // Get the image ID  and set this image on this ImageView
        if (currentItemList != null) {
            imageWrapper.setImageResource(currentItemList.getItemImageId());
        }

        // Find the TextView in the list_wrapper layout displaying the title
        TextView titleWrapper = listItemView.findViewById(R.id.title_wrapper);
        // Get the title  and set this text on this TextView
        if (currentItemList != null) {
            titleWrapper.setText(currentItemList.getItemTitle());
        }

        // Return the whole list item layout
        return listItemView;
    }
}