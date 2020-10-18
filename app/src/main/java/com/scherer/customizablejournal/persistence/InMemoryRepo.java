package com.scherer.customizablejournal.persistence;

import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.JournalPage;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepo implements Repo{

    private List<JournalPage> pages = new ArrayList<>();

    public InMemoryRepo() {
        JournalPage page = new JournalPage(new ArrayList<>());
        pages.add(page);
    }

    @Override
    public void save(JournalPage page) {
        pages.add(page);
    }

    @Override
    public JournalPage getPage(int position) {
        return pages.get(position);
    }

    @Override
    public List<JournalPage> getAllPages() {
        return pages;
    }
}
