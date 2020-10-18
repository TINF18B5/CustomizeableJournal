package com.scherer.customizablejournal.model.customelements;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Rating implements CustomElement, Parcelable {

    private String ratingText;
    private String ratingSymbolSelected;
    private String ratingSymbolNOTSelected;
    private int ratingScore;
    private int maxScore;

    public Rating(String ratingText, String ratingSymbolSelected, String ratingSymbolNOTSelected, int ratingScore, int maxScore) {
        this.ratingText = ratingText;
        this.ratingSymbolSelected = ratingSymbolSelected;
        this.ratingSymbolNOTSelected = ratingSymbolNOTSelected;
        this.ratingScore = ratingScore;
        this.maxScore = maxScore;
    }

    protected Rating(Parcel in) {
        ratingText = in.readString();
        ratingSymbolSelected = in.readString();
        ratingSymbolNOTSelected = in.readString();
        ratingScore = in.readInt();
        maxScore = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ratingText);
        dest.writeString(ratingSymbolSelected);
        dest.writeString(ratingSymbolNOTSelected);
        dest.writeInt(ratingScore);
        dest.writeInt(maxScore);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };

    @Override
    public CustomElement copy() {
        return new Rating(ratingText, ratingSymbolSelected, ratingSymbolNOTSelected, ratingScore, maxScore);
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public String getRatingSymbolSelected() {
        return ratingSymbolSelected;
    }

    public void setRatingSymbolSelected(String ratingSymbolSelected) {
        this.ratingSymbolSelected = ratingSymbolSelected;
    }

    public String getRatingSymbolNOTSelected() {
        return ratingSymbolNOTSelected;
    }

    public void setRatingSymbolNOTSelected(String ratingSymbolNOTSelected) {
        this.ratingSymbolNOTSelected = ratingSymbolNOTSelected;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

}
