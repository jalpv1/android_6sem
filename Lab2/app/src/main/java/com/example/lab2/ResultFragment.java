package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.resultfragment, container, false);
        return rootView;
    }

    void setQuestion(String item) {
        TextView view = (TextView) getView().findViewById(R.id.textView);
        view.setText(item);
    }

    void setAnswer(String item) {
        TextView view = (TextView) getView().findViewById(R.id.textView2);
        view.setText(item);
    }

    void setMessage(String item) {
        TextView view = (TextView) getView().findViewById(R.id.textView3);
        view.setText(item);
    }

}