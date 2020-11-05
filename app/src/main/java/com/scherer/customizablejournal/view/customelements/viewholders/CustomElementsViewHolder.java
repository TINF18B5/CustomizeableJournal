package com.scherer.customizablejournal.view.customelements.viewholders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scherer.customizablejournal.model.customelements.CustomElement;

/**
 * Superclass of all ViewHolders used to display a {@link CustomElement} on the {@link com.scherer.customizablejournal.view.MainJournalActivity}
 * <p>
 * The views held by this viewHolder therefore only display already given answers and have no Input fields.
 */
public abstract class CustomElementsViewHolder extends RecyclerView.ViewHolder {

    protected CustomElementsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    /**
     * Update the view with the given Element's contents.
     * It can be assumed that {@code element} is always of the correct subtype, but it should be checked nonetheless.
     *
     * @param element The element whose values should be put into the held View
     */
    public abstract void setElement(CustomElement element);
}
