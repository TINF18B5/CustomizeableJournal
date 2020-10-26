package com.scherer.customizablejournal.view.customselements;

import androidx.annotation.LayoutRes;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.Mood;
import com.scherer.customizablejournal.model.customelements.Picture;
import com.scherer.customizablejournal.model.customelements.Question;
import com.scherer.customizablejournal.model.customelements.Rating;
import com.scherer.customizablejournal.model.customelements.Text;
import com.scherer.customizablejournal.model.customelements.ToDo;

public enum ViewType {
    //MOOD(Mood.class, R.layout.fragment_second), //Todo
    //PICTURE(Picture.class, R.layout.fragment_second),
    QUESTION(Question.class, R.layout.question),
    RATING(Rating.class, R.layout.fragment_second);
    //TEXT(Text.class, R.layout.fragment_second),
    //TODO(ToDo.class, R.layout.fragment_second);


    private final Class<? extends CustomElement> customElementType;
    @LayoutRes
    private final int layoutRes;

    ViewType(Class<? extends CustomElement> customElementType, @LayoutRes int layoutRes) {

        this.customElementType = customElementType;
        this.layoutRes = layoutRes;
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

    public static ViewType getViewTypeByRes(int layoutRes){

    }

    public int getLayoutRes() {
        return layoutRes;
    }
}
