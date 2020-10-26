package com.scherer.customizablejournal.view.customselements;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.JournalPage;
import com.scherer.customizablejournal.view.customselements.viewholders.CustomElementsViewHolder;

public class ViewHolderAdapter extends RecyclerView.Adapter<CustomElementsViewHolder> {

    ViewTypGetter getter = new ViewTypGetter();

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
         return getter.getViewType(customElement);
    }

    @NonNull
    @Override
    public CustomElementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        return new CustomElementsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomElementsViewHolder holder, int position) {
        CustomElement customElement = page.getElements().get(position);
        holder.setElement(customElement);
    }


}
