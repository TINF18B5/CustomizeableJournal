package com.scherer.customizablejournal.view.customelements;

import androidx.annotation.LayoutRes;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.Question;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertThrows;

public class ViewTypeTest {

    @Test
    public void getViewTypeWithInvalidCustomElement() {
        //Arrange/Setup
        final CustomElement invalidElement = new InvalidCustomElement();

        //Act/Do
        final IllegalArgumentException exception = assertThrows("Invalid CustomElement must throw exception", IllegalArgumentException.class, () -> ViewType.getViewType(invalidElement));

        //Assert/Verify
        Assert.assertEquals("Couldn't find ViewType of Element!", exception.getMessage());
    }

    @Test
    public void getViewTypeWithValidCustomElement() {
        //Arrange/Setup
        final CustomElement question = new Question("Some question", new String[]{"Some", "Answers"});

        //Act/Do
        final ViewType viewType = ViewType.getViewType(question);

        //Assert/Verify
        Assert.assertEquals(ViewType.QUESTION, viewType);
    }

    @Test
    public void getViewTypeByResWithInvalidCustomElement() {
        //Arrange/Setup
        final int invalidLayoutResource = 0;

        //Act/Do
        final IllegalArgumentException exception = assertThrows("Invalid CustomElement must throw exception", IllegalArgumentException.class, () -> ViewType.getViewTypeByRes(invalidLayoutResource));

        //Assert/Verify
        Assert.assertEquals("Could not find ViewType with LayoutRes '0'!", exception.getMessage());
    }

    @Test
    public void getViewTypeByResWithValidCustomElement() {
        //Arrange/Setup
        @LayoutRes
        final int questionId = R.layout.question;

        //Act/Do
        final ViewType viewType = ViewType.getViewTypeByRes(questionId);

        //Assert/Verify
        Assert.assertEquals(ViewType.QUESTION, viewType);
    }
}