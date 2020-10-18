package com.scherer.customizablejournal.model.customelements;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JournalPage implements Parcelable {

    final List<CustomElement> elements;
    final LocalDate date;

    public JournalPage(List<CustomElement> elements) {
        this.elements = elements;
        date = LocalDate.now();
    }

    protected JournalPage(Parcel in) {
        elements = in.readArrayList(JournalPage.class.getClassLoader());
        date = LocalDate.ofEpochDay(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(elements);
        dest.writeLong(date.toEpochDay());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<JournalPage> CREATOR = new Creator<JournalPage>() {
        @Override
        public JournalPage createFromParcel(Parcel in) {
            return new JournalPage(in);
        }

        @Override
        public JournalPage[] newArray(int size) {
            return new JournalPage[size];
        }
    };

    public List<CustomElement> getElements() {
        return elements;
    }

    public LocalDate getDate() {
        return date;
    }
}
