package com.example.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private String val = "";
    private EditText editText;
    private Button button;
    private RadioGroup radGrp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment, container, false);
        radGrp = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        editText = (EditText) rootView.findViewById(R.id.editText);
        button = rootView.findViewById(R.id.button3);
        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch (id) {
                    case R.id.radioButton:
                        val = "Yes";
                        break;
                    case R.id.radioButton2:
                        val = "No";
                        break;
                    default:
                        break;
                }

            }

        });
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                radGrp.clearCheck();
                QuestionAnswerListener listener = (QuestionAnswerListener) getActivity();
                listener.getUserInput(editText.getText().toString(), val);
                editText.setText(" ");

            }
        });


        return rootView;
    }

    public interface QuestionAnswerListener {
        public void getUserInput(String question, String answer);
    }


}


