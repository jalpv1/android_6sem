package com.example.lab3;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class MainActivity extends AppCompatActivity implements MyFragment.QuestionAnswerListener {
    private ResultFragment result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        final MyFragment messageFragment = (MyFragment) fragmentManager
                .findFragmentById(R.id.fragment);
        result = (ResultFragment) fragmentManager
                .findFragmentById(R.id.resultfragment);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StorageActivity.class);
                startActivity(intent);

            }
        });
    }
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, StorageActivity.class);
        intent.putExtra("q","q");
        startActivity(intent);
    }



    @Override
    public void getUserInput(String question, String answer) {
        String message = "Success";
        if (question.trim().isEmpty() || answer.trim().isEmpty()) {
            message = "Enter , please,question and answer";
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        result = (ResultFragment) fragmentManager
                .findFragmentById(R.id.resultfragment);
        if (result != null)
            if (!question.trim().isEmpty() && !answer.trim().isEmpty()) {
                result.setQuestion(question);
                result.setAnswer(answer);
            }
        result.setMessage(message);
    }

}

