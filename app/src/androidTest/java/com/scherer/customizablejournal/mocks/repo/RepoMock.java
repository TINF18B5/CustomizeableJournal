package com.scherer.customizablejournal.mocks.repo;

import com.scherer.customizablejournal.model.customelements.JournalPage;
import com.scherer.customizablejournal.persistence.Repo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class RepoMock implements Repo {

    private final SortedSet<JournalPage> pages = new TreeSet<>(Comparator.comparing(JournalPage::getDate));

    @Override
    public void save(JournalPage page) {
        pages.add(page);
    }

    @Override
    public JournalPage getPage(int position) {
        return getAllPages().get(position);
    }

    @Override
    public List<JournalPage> getAllPages() {
        return new ArrayList<>(pages);
    }
}
