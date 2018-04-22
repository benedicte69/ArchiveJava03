package com.example.bened.lyoncity.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemList implements Parcelable {

    public static final Creator<ItemList> CREATOR = new Creator<ItemList>() {
        @Override
        public ItemList createFromParcel(Parcel source) {
            return new ItemList(source);
        }

        @Override
        public ItemList[] newArray(int size) {
            return new ItemList[size];
        }
    };
    private final String mItemTitle;
    private final String mWebPage;
    /**
     * Items of the ArrayList
     */
    private int mItemImageId;
    private String mItemShortDescription;
    private double mV;
    private double mV1;

    /**
     * Constructor for the patrimony museum and nature fragments
     *
     * @param itemImageId          The image
     * @param itemTitle            The title
     * @param itemShortDescription A short description
     * @param v                    The latitude
     * @param v1                   The longitude
     * @param webPage              A web link
     */

    public ItemList(int itemImageId, String itemTitle, String itemShortDescription, double v, double v1, String webPage) {
        mItemImageId = itemImageId;
        mItemTitle = itemTitle;
        mItemShortDescription = itemShortDescription;
        mV = v;
        mV1 = v1;
        mWebPage = webPage;
    }

    /**
     * Constructor for the home fragment
     *
     * @param itemImageId The image
     * @param itemTitle   The title
     * @param webPage     A web link
     */

    public ItemList(int itemImageId, String itemTitle, String webPage) {
        mItemImageId = itemImageId;
        mItemTitle = itemTitle;
        mWebPage = webPage;
    }

    private ItemList(Parcel in) {
        this.mItemTitle = in.readString();
        this.mV = in.readDouble();
        this.mV1 = in.readDouble();
        this.mWebPage = in.readString();
    }

    /**
     * Getters for the patrimony museum and nature fragments returning the image, the title and
     * a short description
     * Getters for the MapInfoActivity returning the title, the latitude and the longitude
     */

    public int getItemImageId() {
        return mItemImageId;
    }

    public String getItemTitle() {
        if (mItemTitle != null) {
            return mItemTitle;
        }
        return null;
    }

    public String getItemShortDescription() {
        return mItemShortDescription;
    }

    public double getV() {
        return mV;
    }

    public double getV1() {
        return mV1;
    }

    public String getWebPage() {
        if (mWebPage != null) {
            return mWebPage;
        }
        return null;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mItemTitle);
        dest.writeDouble(this.mV);
        dest.writeDouble(this.mV1);
        dest.writeString(this.mWebPage);
    }
}
