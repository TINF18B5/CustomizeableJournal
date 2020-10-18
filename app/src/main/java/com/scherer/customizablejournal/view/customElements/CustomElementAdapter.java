package com.scherer.customizablejournal.view.customElements;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scherer.customizablejournal.model.JournalPage;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.view.customElements.holders.AbstractCustomElementViewHolder;

public class CustomElementAdapter extends RecyclerView.Adapter<AbstractCustomElementViewHolder> {

    private final JournalPage page;
    private final CustomElementViewRegistry registry = CustomElementViewRegistry.instance;

    public CustomElementAdapter(JournalPage page) {
        this.page = page;
    }

    @Override
    public int getItemViewType(int position) {
        return registry.getItemViewType(getElementAt(position));
    }

    private CustomElement getElementAt(int position) {
        return page.getElements().get(position);
    }

    @NonNull
    @Override
    public AbstractCustomElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return registry.getViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractCustomElementViewHolder holder, int position) {
        final CustomElement customElement = page.getElements().get(position);
        holder.updateElement(customElement);
    }

    @Override
    public int getItemCount() {
        return page.getElements().size();
    }

}
