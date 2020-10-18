package com.scherer.customizablejournal.persistence;

import com.scherer.customizablejournal.model.JournalPage;

import java.util.List;

public interface Repo {

    static Repo getInstance(){
        return RepoSingelton.getRepo();      //todo: refactor
    }

    void save(JournalPage page);
    JournalPage getPage(int position);
    List<JournalPage> getAllPages();
}
