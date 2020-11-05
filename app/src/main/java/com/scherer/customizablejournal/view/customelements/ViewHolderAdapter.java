package com.scherer.customizablejournal.view.customelements;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.JournalPage;
import com.scherer.customizablejournal.view.customelements.viewholders.CustomElementsViewHolder;

/**
 * Adapter to show the {@link CustomElement} objects on a given {@link JournalPage} on the {@link com.scherer.customizablejournal.view.MainJournalActivity}.
 *
 * Uses {@link CustomElementsViewHolder} and its subclasses to hold and update the views.
 */
public class ViewHolderAdapter extends RecyclerView.Adapter<CustomElementsViewHolder> {

    private final JournalPage page;

    public ViewHolderAdapter(JournalPage page) {
        this.page = page;
    }

    @Override
    public int getItemCount() {
        return page.getElements().size();
    }

    @Override
    public int getItemViewType(int position) {
        CustomElement customElement = page.getElements().get(position);
        return ViewType.getViewType(customElement).getLayoutRes();
    }

    @NonNull
    @Override
    public CustomElementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        final ViewType viewTypeByRes = ViewType.getViewTypeByRes(viewType);
        return viewTypeByRes.createNewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomElementsViewHolder holder, int position) {
        CustomElement customElement = page.getElements().get(position);
        holder.setElement(customElement);
    }


}
