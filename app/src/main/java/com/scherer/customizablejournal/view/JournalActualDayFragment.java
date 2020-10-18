package com.scherer.customizablejournal.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.scherer.customizablejournal.R;
import com.scherer.customizablejournal.model.customelements.JournalPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JournalActualDayFragment extends Fragment {

    public static final String PARCEABLEPARAM = "com.scherer.customizablejournal.view.parceableparam";

    private JournalPage page;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        if(savedInstanceState != null){
        page = savedInstanceState.getParcelable(JournalActualDayFragment.PARCEABLEPARAM);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(page!=null) {
            TextView textView = view.findViewById(R.id.date);
            textView.setText(page.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }
}