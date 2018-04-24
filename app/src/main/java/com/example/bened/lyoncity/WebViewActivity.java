package com.example.bened.lyoncity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bened.lyoncity.objects.ItemList;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content of this activity
        setContentView(R.layout.activity_webview);

        //get the Title Data parcel items we need in this page
        final Intent intentTitleData = getIntent();
        final ItemList parcelTitle = intentTitleData.getParcelableExtra(getString(R.string.java_title_data));
        final ItemList parcelWebLink = intentTitleData.getParcelableExtra(getString(R.string.java_web_link_data));

        //Set the parcelTitle in a view
        if (parcelTitle != null) {
            String mItemTitleMapInfo = parcelTitle.getItemTitle();
            TextView placeTitleView = findViewById(R.id.place_title);
            placeTitleView.setText(mItemTitleMapInfo);

        }

        //Set the WebLink Data parcel  in a view
        if (parcelWebLink != null) {
            final String webLink = parcelWebLink.getWebPage();
            WebView webview = findViewById(R.id.web_view);
            webview.loadUrl(webLink);

        }

        //Navigate back to the Main activity
        ImageView arrowBack = findViewById(R.id.arrow_back_intent);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent displayMainActivity = new Intent(WebViewActivity.this, MainActivity.class);
                startActivity(displayMainActivity);
            }
        });

        /* if the user uses the back button of its device */
        if (((parcelWebLink == null) && (parcelTitle == null))) {
            Intent displayMainActivityAlso = new Intent(WebViewActivity.this, MainActivity.class);
            startActivity(displayMainActivityAlso);
        }
    }
}

