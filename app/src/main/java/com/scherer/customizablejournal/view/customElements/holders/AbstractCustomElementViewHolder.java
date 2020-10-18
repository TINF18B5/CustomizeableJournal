package com.scherer.customizablejournal.view.customElements.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scherer.customizablejournal.model.customelements.CustomElement;

public abstract class AbstractCustomElementViewHolder extends RecyclerView.ViewHolder {

    public AbstractCustomElementViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void updateElement(CustomElement element);
}
