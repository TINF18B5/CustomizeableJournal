package com.scherer.customizablejournal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.scherer.customizablejournal.R;

public class JournalScrollFragment extends Fragment {
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;

    public JournalScrollFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_journal_scroll, container, false);
        pager = view.findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(Integer.MAX_VALUE, false);
        return view;
    }
}