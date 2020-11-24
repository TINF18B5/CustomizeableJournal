package com.scherer.customizablejournal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.scherer.customizablejournal.R;

/**
 * Used to scroll between multiple days within {@link MainJournalActivity}.
 * <p>
 * Uses the a ViewPager and the {@link JournalActualDayFragment} to display the single days
 */
public class JournalScrollFragment extends Fragment {

    public JournalScrollFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_journal_scroll, container, false);
        final ViewPager2 pager = view.findViewById(R.id.pager);
        final FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(this);
        pager.setAdapter(pagerAdapter);
        return view;
    }
}