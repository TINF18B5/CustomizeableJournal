package com.scherer.customizablejournal.model.customelements;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;
import java.util.List;

/**
 * A JournalPage is what can be shown on the Application's {@link com.scherer.customizablejournal.view.MainJournalActivity}.
 * It depicts an entry into the Journal and consists of a date and a list of shown {@link CustomElement} objects.
 * <p>
 * The Custom Elements are to be displayed in the order of {@link #getElements()}
 */
public class JournalPage implements Parcelable {

    /**
     * The elements that should be shown for this JournalPage.
     * The list is mutable!
     */
    final List<CustomElement> elements;
    /**
     * The Date whose entry is represented by this JournalPage
     */
    final LocalDate date;

    /**
     * Creates a new JournalPage with the given Elements.
     * Will be pointing to today's date.
     *
     * @param elements The elements to be shown
     */
    public JournalPage(List<CustomElement> elements) {
        this(elements, LocalDate.now());
    }

    /**
     * Creates a new JournalPage with the given Elements.
     *
     * @param elements The elements to be shown
     * @param date     The Date for which this JournalPage Stands
     */
    public JournalPage(List<CustomElement> elements, LocalDate date) {
        this.elements = elements;
        this.date = date;
    }

    protected JournalPage(Parcel in) {
        //noinspection unchecked
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
