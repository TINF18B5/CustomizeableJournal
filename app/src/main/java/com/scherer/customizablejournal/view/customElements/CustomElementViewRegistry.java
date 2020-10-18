package com.scherer.customizablejournal.view.customElements;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.Question;
import com.scherer.customizablejournal.view.customElements.holders.AbstractCustomElementViewHolder;
import com.scherer.customizablejournal.view.customElements.holders.QuestionViewHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CustomElementViewRegistry {
    public static final CustomElementViewRegistry instance = new CustomElementViewRegistry();

    private final Map<Class<? extends CustomElement>, RegistryEntry> viewTypes = new HashMap<>();

    private CustomElementViewRegistry() {
        viewTypes.put(Question.class, new RegistryEntry(R.layout.fragment_question, QuestionViewHolder::new));
    }

    public int getItemViewType(CustomElement element) {
        return getEntry(element).viewType;
    }


    public AbstractCustomElementViewHolder getViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        for (final RegistryEntry value : viewTypes.values()) {
            if (value.viewType == viewType) {
                return value.supplier.apply(view);
            }
        }
        throw new IllegalArgumentException("Unknown viewType: " + viewType);
    }

    private RegistryEntry getEntry(CustomElement element) {
        final Class<? extends CustomElement> elementClass = element.getClass();
        if (viewTypes.containsKey(elementClass)) {
            return viewTypes.get(elementClass);
        }

        for (final Class<? extends CustomElement> knownType : viewTypes.keySet()) {
            if (knownType.isInstance(element)) {
                return viewTypes.get(knownType);
            }
        }
        throw new IllegalArgumentException("Unknown element class: " + elementClass);
    }


    private static final class RegistryEntry {
        @LayoutRes
        private final int viewType;
        private final Function<View, ? extends AbstractCustomElementViewHolder> supplier;

        private RegistryEntry(int viewType, Function<View, ? extends AbstractCustomElementViewHolder> supplier) {
            this.viewType = viewType;
            this.supplier = supplier;
        }
    }
}
