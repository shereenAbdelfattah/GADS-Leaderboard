package com.example.gads_leaderboard.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.gads_leaderboard.LeadersFragment;
import com.example.gads_leaderboard.R;
import com.example.gads_leaderboard.SkillIQLeadersFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final int[] TAB_TITLES = new int[]{R.string.learning_leaders_tab, R.string.skill_iq_leaders_Tab};
    Context mContext;


   /* public SectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }*/

    public SectionsPagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       // Fragment fragment = null;
        if (position==0){
          return    new LeadersFragment();
        }else
            //if(position==1){
            return new SkillIQLeadersFragment();


    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  mContext.getResources().getString(TAB_TITLES[position]);
    }
}
