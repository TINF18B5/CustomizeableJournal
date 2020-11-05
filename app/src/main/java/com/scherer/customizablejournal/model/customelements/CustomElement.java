package com.scherer.customizablejournal.model.customelements;

import android.os.Parcelable;

/**
 * Defines a custom Element, that can be added to a {@link JournalPage}
 * Examples of CustomElements are {@link Question}, {@link Text}
 *
 * CustomElements should store the "static/question" data as well as the user's answer.
 */
public interface CustomElement extends Parcelable {

    /**
     * Creates a deep Copy of this element
     */
    CustomElement copy();
}
