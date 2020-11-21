package com.scherer.customizablejournal.view.customelements.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.CustomElement;
import com.scherer.customizablejournal.model.customelements.Question;

/**
 * Holds the given answers for a {@link Question} element
 */
public class CustomElementsViewHolderQuestion extends CustomElementsViewHolder {

    private final TextView questionView;
    private final TextView answerView;

    public CustomElementsViewHolderQuestion(@NonNull View itemView) {
        super(itemView);
       questionView = itemView.findViewById(R.id.questionText);
       answerView = itemView.findViewById(R.id.answerText);
    }

    @Override
    public void setElement(CustomElement element) {
        if (!(element instanceof Question)) {
            return;
        }
        Question question = (Question) element;
        questionView.setText(question.getQuestion());
        answerView.setText(question.getAnswers()[0]); //todo
    }


}
