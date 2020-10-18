package com.scherer.customizablejournal.persistence;

import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.JournalPage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryRepo implements Repo{

    private List<JournalPage> pages = new ArrayList<>();

    public InMemoryRepo() {
        JournalPage page = new JournalPage(new ArrayList<>());
        JournalPage page2 = new JournalPage(new ArrayList<>(), LocalDate.now().minusDays(2));
        pages.add(page);
        pages.add(page2);
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
