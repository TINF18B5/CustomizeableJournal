package com.scherer.customizablejournal.model.customelements;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Question implements CustomElement, Parcelable {

    private String question;
    private String[] answers;

    public Question(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }


    protected Question(Parcel in) {
        question = in.readString();
        answers = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeStringArray(answers);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public CustomElement copy() {
        return new Question(question, Arrays.copyOf(answers, answers.length));
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
