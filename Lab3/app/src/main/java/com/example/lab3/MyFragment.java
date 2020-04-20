package com.example.lab3;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.Telephony.Mms.Part.FILENAME;

public class MyFragment extends Fragment {
    private static final String LOG_TAG = "f";
    private String val = "";
    private EditText editText;
    private Button button;
    private RadioGroup radGrp;
    private View rootView;
    private DBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView =
                inflater.inflate(R.layout.fragment, container, false);
        radGrp = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        editText = (EditText) rootView.findViewById(R.id.editText);
        button = rootView.findViewById(R.id.button3);
        dbHelper = new DBHelper(rootView.getContext());
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
                String question = editText.getText().toString();
                radGrp.clearCheck();
                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();
                contentValues.put(DBHelper.KEY_QUESTION, question);
                contentValues.put(DBHelper.KEY_ANSWER, val);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
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


