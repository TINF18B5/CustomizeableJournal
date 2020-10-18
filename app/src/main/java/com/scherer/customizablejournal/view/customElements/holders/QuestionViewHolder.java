package com.scherer.customizablejournal.view.customElements.holders;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.Question;
import com.scherer.customizablejournal.view.customElements.AfterTextUpdateListener;

public class QuestionViewHolder extends AbstractCustomElementViewHolder {

    private final TextView questionText;
    private final EditText questionAnswer;
    private Question question;

    public QuestionViewHolder(@NonNull View itemView) {
        super(itemView);
        this.questionText = itemView.findViewById(R.id.question_text);
        this.questionAnswer = itemView.findViewById(R.id.question_answer);
        this.questionAnswer.addTextChangedListener(new AfterTextUpdateListener() {
            @Override
            public void afterTextChanged(Editable s) {
                question.getAnswers()[0] = s.toString();
            }
        });
    }

    @Override
    public void updateElement(CustomElement element) {
        if (!(element instanceof Question)) {
            return;
        }

        this.question = (Question) element;
        questionText.setText(question.getQuestion());
        questionAnswer.setText(question.getAnswers()[0]);
    }
}
