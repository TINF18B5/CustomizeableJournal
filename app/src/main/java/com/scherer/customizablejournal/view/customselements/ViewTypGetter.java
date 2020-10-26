package com.scherer.customizablejournal.view.customselements;

import androidx.annotation.LayoutRes;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;

public class ViewTypGetter {

    @LayoutRes
    public int getViewType(CustomElement customElement) {
        ViewType viewType = ViewType.getViewType(customElement);

        return viewType.getLayoutRes();
    }
}
