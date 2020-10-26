package com.scherer.customizablejournal.view.customselements.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.Question;

public abstract class CustomElementsViewHolder extends RecyclerView.ViewHolder {



    public CustomElementsViewHolder(@NonNull View itemView) {
        super(itemView);
    }


    public abstract void setElement(CustomElement element);
}
