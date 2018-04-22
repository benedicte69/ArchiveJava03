package com.example.bened.lyoncity.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.bened.lyoncity.R;
import com.example.bened.lyoncity.fragments.HomeFragment;
import com.example.bened.lyoncity.fragments.MuseumFragment;
import com.example.bened.lyoncity.fragments.NatureFragment;
import com.example.bened.lyoncity.fragments.PatrimonyFragment;

public class TabFragmentPageAdapter extends FragmentPagerAdapter {

    /**
     * The app context
     */
    private final Context mContext;


    /**
     * Constructor implementing fragments
     * <p>
     * Creates a new {@link ItemListAdapter} object.
     *
     * @param context The activity context
     * @param fm      The fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */

    public TabFragmentPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    /**
     * Stipulates the number of pages to be created with the fragments
     *
     * @return The  number of fragments
     */

    @Override
    public int getCount() {
        return 4;
    }

    /**
     * Determines the fragment that should be displayed for the given page number.
     *
     * @param position the given page number
     * @return The fragment
     */

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new PatrimonyFragment();
            case 2:
                return new MuseumFragment();
            case 3:
                return new NatureFragment();
            default:
                return null;
        }
    }

    /**
     * Method called by the ViewPager to obtain a title string describing
     * the specified page.
     * <p>
     * Indicates the title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the page requested
     * @return A title for the requested page
     */

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab_home);
            case 1:
                return mContext.getString(R.string.tab_patrimony);
            case 2:
                return mContext.getString(R.string.tab_museum);
            case 3:
                return mContext.getString(R.string.tab_nature);
            default:
                return null;
        }
    }
}
