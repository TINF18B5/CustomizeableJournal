package com.scherer.customizablejournal.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.scherer.customizablejournal.model.customelements.JournalPage;
import com.scherer.customizablejournal.persistence.Repo;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    private final Repo repo;

    public ScreenSlidePagerAdapter(Fragment fragment) {
        super(fragment);
        repo= Repo.getInstance();
    }

    @NonNull
    @Override
    public JournalActualDayFragment createFragment(int position) {
        JournalPage page = repo.getPage(position);
        JournalActualDayFragment journalActualDayFragment = new JournalActualDayFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(JournalActualDayFragment.PARCEABLEPARAM, page);
        journalActualDayFragment.setArguments(bundle);
        return journalActualDayFragment;
    }

    @Override
    public int getItemCount() {
        return repo.getAllPages().size();
    }
}