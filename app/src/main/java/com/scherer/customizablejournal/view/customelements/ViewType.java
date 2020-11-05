package com.scherer.customizablejournal.view.customelements;

import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.Question;
import com.scherer.customizablejournal.view.customelements.viewholders.CustomElementsViewHolder;
import com.scherer.customizablejournal.view.customelements.viewholders.CustomElementsViewHolderQuestion;

import java.util.function.Function;

/**
 * Holds a mapping of {@link CustomElement} types or their Layout Resource to the matching {@link CustomElementsViewHolder} constructor
 * <p>
 * Can be retrieved via {@link #getViewType} and {@link #getViewTypeByRes}
 */
public enum ViewType {
    //MOOD(Mood.class, R.layout.fragment_second), //Todo
    //PICTURE(Picture.class, R.layout.fragment_second),
    QUESTION(Question.class, R.layout.question, CustomElementsViewHolderQuestion::new);
    //RATING(Rating.class, R.layout.fragment_second, CustomElementsViewHolderRating::new);
    //TEXT(Text.class, R.layout.fragment_second),
    //TODO(ToDo.class, R.layout.fragment_second);


    /**
     * The class that this enum Member is standing for
     */
    private final Class<? extends CustomElement> customElementType;

    /**
     * The layout resource that this enum member stands for.
     */
    @LayoutRes
    private final int layoutRes;

    /**
     * A reference to the constructor or a factory to create a new viewHolder for a view of this enum member's viewType.
     */
    private final Function<View, CustomElementsViewHolder> createViewHolderFunc;

    ViewType(Class<? extends CustomElement> customElementType, @LayoutRes int layoutRes, Function<View, CustomElementsViewHolder> createViewHolderFunc) {
        this.customElementType = customElementType;
        this.layoutRes = layoutRes;
        this.createViewHolderFunc = createViewHolderFunc;
    }

    /**
     * Retrieves the matching ViewType for the given {@link CustomElement}
     *
     * @param element The element whose viewType we want
     * @return The Found viewType
     * @throws IllegalArgumentException If the element has no matching viewType registered.
     *                                  This is assumed to be a fatal error.
     */
    public static ViewType getViewType(@NonNull CustomElement element) {
        Class<? extends CustomElement> typeOfElement = element.getClass();
        for (ViewType value : values()) {
            if (typeOfElement == value.customElementType) {
                return value;
            }
        }
        throw new IllegalArgumentException("Could't find ViewType of Element!");
    }

    /**
     * Retrieves the matching ViewType for the given {@code layoutRes}
     *
     * @param layoutRes The layout resource of the view whose type we want
     * @return The Found viewType
     * @throws IllegalArgumentException If no viewType exists for the given LayoutRes.
     *                                  This is assumed to be a fatal error!
     */
    public static ViewType getViewTypeByRes(@LayoutRes int layoutRes) {
        for (final ViewType value : values()) {
            if (value.layoutRes == layoutRes) {
                return value;
            }
        }
        throw new IllegalArgumentException("Could not find ViewType with LayoutRes '" + layoutRes + "'!");
    }

    @LayoutRes
    public int getLayoutRes() {
        return layoutRes;
    }

    @NonNull
    public CustomElementsViewHolder createNewViewHolder(@NonNull View view) {
        //What do we want?
        //We want a new Instance of a CustomElementsViewHolder, that represesents the Enum
        // (View) -> CustomElementsViewHolder
        return createViewHolderFunc.apply(view);
    }
}
