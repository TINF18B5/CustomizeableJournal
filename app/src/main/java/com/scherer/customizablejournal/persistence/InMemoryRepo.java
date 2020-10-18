package com.scherer.customizablejournal.persistence;

import androidx.recyclerview.widget.SortedList;

import com.scherer.customizablejournal.model.JournalPage;
import com.scherer.customizablejournal.model.customelements.Question;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InMemoryRepo implements Repo{

    private final SortedSet<JournalPage> pages = new TreeSet<>();

    public InMemoryRepo() {
        final List<Question> questions = IntStream.range(0, 10)
                .mapToObj(i -> new Question("Question " + i, new String[3]))
                .collect(Collectors.toList());

        JournalPage page = new JournalPage(new ArrayList<>(questions));
        JournalPage page2 = new JournalPage(new ArrayList<>(questions), LocalDate.now().minusDays(2));
        pages.add(page);
        pages.add(page2);
    }

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
