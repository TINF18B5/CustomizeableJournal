package com.scherer.customizablejournal;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.scherer.customizablejournal.mocks.repo.RepoMock;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.JournalPage;
import com.scherer.customizablejournal.model.customelements.Question;
import com.scherer.customizablejournal.persistence.RepoSingelton;
import com.scherer.customizablejournal.view.MainJournalActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleUITest {
    private static final String questionText = "Was ist der Sinn des Lebens";
    private static final String answerText = "42";


    @SuppressWarnings({"FieldCanBeLocal"})
    private ActivityScenario<MainJournalActivity> activityScenario;


    @Before
    public void before() {
        final RepoMock repo = new RepoMock();
        RepoSingelton.supersedeSingleton(repo);
        activityScenario = ActivityScenario.launch(MainJournalActivity.class);


        final Question question = new Question(questionText, new String[]{answerText});
        final List<CustomElement> elements = Collections.singletonList(question);
        repo.save(new JournalPage(elements, LocalDate.now()));
    }

    @Test
    public void questionTextAndAnswersShown() {
        onView(withId(R.id.questionText))
                .check(matches(withText(questionText)));

        onView(withId(R.id.answerText))
                .check(matches(withText(answerText)));
    }
}
