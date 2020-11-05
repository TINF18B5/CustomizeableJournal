package com.scherer.customizablejournal.persistence;

import androidx.annotation.IntRange;

import com.scherer.customizablejournal.model.customelements.JournalPage;

import java.util.List;

/**
 * Holds the data for this application.
 * <p>
 * Can be retrieved via {@link #getInstance()}
 */
public interface Repo {

    /**
     * Retrieves a repository instance
     */
    static Repo getInstance() {
        return RepoSingelton.getRepo();      //todo: refactor
    }

    /**
     * Persists the given journalPage
     */
    void save(JournalPage page);

    /**
     * Retrieves the page at position {@code position}.
     * The most recent entry is at the highest position and the oldest at position {@code 0}
     *
     * @param position The index
     */
    JournalPage getPage(@IntRange(from = 0) int position);

    /**
     * Retrieves a list of all pages
     * The list can be assumed ordered from oldest (index 0) to most recent (highest index)
     */
    List<JournalPage> getAllPages();
}
