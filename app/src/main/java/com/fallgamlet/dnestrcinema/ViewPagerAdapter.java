package com.fallgamlet.dnestrcinema;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fallgamlet on 07.01.17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    //region Fields
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mTitles = new ArrayList<>();
    //endregion

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mTitles.add(title);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object obj = super.instantiateItem(container, position);
        Fragment fragment = mFragments.get(position);

        if((obj!=null && fragment!=null) && obj != fragment){
            destroyItem(container, position, obj);
            obj = super.instantiateItem(container, position);
        }

        return obj;
    }
}
