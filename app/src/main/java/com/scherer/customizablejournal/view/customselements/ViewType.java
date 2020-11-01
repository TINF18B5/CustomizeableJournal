package com.scherer.customizablejournal.view.customselements;

import android.view.View;

import androidx.annotation.LayoutRes;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.Question;
import com.scherer.customizablejournal.view.customselements.viewholders.CustomElementsViewHolder;
import com.scherer.customizablejournal.view.customselements.viewholders.CustomElementsViewHolderQuestion;

import java.util.function.Function;

public enum ViewType {
    //MOOD(Mood.class, R.layout.fragment_second), //Todo
    //PICTURE(Picture.class, R.layout.fragment_second),
    QUESTION(Question.class, R.layout.question, CustomElementsViewHolderQuestion::new);
    //RATING(Rating.class, R.layout.fragment_second, CustomElementsViewHolderRating::new);
    //TEXT(Text.class, R.layout.fragment_second),
    //TODO(ToDo.class, R.layout.fragment_second);


    private final Class<? extends CustomElement> customElementType;
    @LayoutRes
    private final int layoutRes;

    private final Function<View, CustomElementsViewHolder> createViewHolderFunc;

    ViewType(Class<? extends CustomElement> customElementType, @LayoutRes int layoutRes, Function<View, CustomElementsViewHolder> createViewHolderFunc) {
        this.customElementType = customElementType;
        this.layoutRes = layoutRes;
        this.createViewHolderFunc = createViewHolderFunc;
    }

    public static ViewType getViewType(CustomElement element){
        Class<? extends CustomElement> typeOfElement = element.getClass();
        for (ViewType value : values()) {
            if(typeOfElement == value.customElementType){
                return value;
            }
        }
        throw new IllegalArgumentException("Could't find ViewType of Element!");
    }

    public static ViewType getViewTypeByRes(@LayoutRes int layoutRes){
        for (final ViewType value : values()) {
            if (value.layoutRes == layoutRes) {
                return value;
            }
        }
        throw new IllegalArgumentException("Could not find ViewType with LayoutRes '" + layoutRes + "'!");
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public CustomElementsViewHolder createNewViewHolder(View view) {
        //What do we want?
        //We want a new Instance of a CustomElementsViewHolder, that represesents the Enum
        // (View) -> CustomElementsViewHolder
        return createViewHolderFunc.apply(view);
    }
}
