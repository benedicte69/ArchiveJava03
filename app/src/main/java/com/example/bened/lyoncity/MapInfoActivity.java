package com.example.bened.lyoncity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bened.lyoncity.objects.ItemList;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapInfoActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content of this activity
        setContentView(R.layout.activity_map_info);

        //get the Title Data parcel items we need in this page
        Intent intentTitleData = getIntent();
        ItemList parcelTitle = intentTitleData.getParcelableExtra(getString(R.string.java_title_data));
        final ItemList parcelWebLink = intentTitleData.getParcelableExtra(getString(R.string.java_web_link_data));

        //Set the parcelTitle in a view
        if (parcelTitle != null) {
            String mItemTitleMapInfo = parcelTitle.getItemTitle();
            TextView placeTitleView = findViewById(R.id.place_title);
            placeTitleView.setText(mItemTitleMapInfo);
        }

        //Set the WebLink Data parcel  in a variable
        if (parcelWebLink != null) {
            final String webLink = parcelWebLink.getWebPage();

            //Open a web page
            TextView webBrowser = findViewById(R.id.browse_the_web);
            webBrowser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(String.valueOf(webLink));
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Navigate back to the Main activity
        ImageView arrowBack = findViewById(R.id.arrow_back_intent);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent displayMainActivity = new Intent(MapInfoActivity.this, MainActivity.class);
                startActivity(displayMainActivity);
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //get the TitleData parcel items we need to set in the map
        Intent intentTitleData = getIntent();
        ItemList parcelTitle = intentTitleData.getParcelableExtra(getString(R.string.java_title_data));
        if (parcelTitle != null) {
            String marker = parcelTitle.getItemTitle();
            double latitude = parcelTitle.getV();
            double longitude = parcelTitle.getV1();
            //Set the new latitude and a longitude with a marker
            LatLng latLng = new LatLng(latitude, longitude);
            googleMap.addMarker(new MarkerOptions().position(latLng).title(marker));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 2));
        } else {
            stopService(intentTitleData);
            Intent displayMainActivity = new Intent(MapInfoActivity.this, MainActivity.class);
            startActivity(displayMainActivity);
            startService(displayMainActivity);
        }
    }
}
