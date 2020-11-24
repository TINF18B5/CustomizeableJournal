package com.scherer.customizablejournal.view.customelements;

import android.os.Parcel;

import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.view.customelements.ViewTypeTest;

/**
 * Only for {@link ViewTypeTest#getViewTypeWithInvalidCustomElement()}!
 * Do not use for any other test!
 */
class InvalidCustomElement implements CustomElement {
    @Override
    public CustomElement copy() {
        return new InvalidCustomElement();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
