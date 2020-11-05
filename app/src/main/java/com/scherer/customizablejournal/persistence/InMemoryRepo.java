package com.scherer.customizablejournal.persistence;

import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.JournalPage;
import com.scherer.customizablejournal.model.customelements.Question;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * InMemory Implementation of a Repositry with Hardcoded entries.
 * Should only be used for developing and Testing Purposes!
 */
public class InMemoryRepo implements Repo {

    private final List<JournalPage> pages = new ArrayList<>();

    public InMemoryRepo() {
        createEntries();
    }

    /**
     * Pre-Seeds the Database with Test entries.
     */
    private void createEntries() {
        //Today we have an empty page
        final JournalPage emptyPageToday = new JournalPage(new ArrayList<>());
        save(emptyPageToday);

        //But the day before yesterday, we had a few questions answered
        final List<CustomElement> myPage = new ArrayList<>();
        myPage.add(new Question("Was ist der Sinn des Lebens?", new String[]{"Zweiundpfürzig", "42"}));
        myPage.add(new Question("Warum?", new String[]{"Weil halt..."}));
        save(new JournalPage(myPage, LocalDate.now().minusDays(2)));
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
