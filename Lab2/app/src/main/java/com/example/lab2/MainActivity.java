package com.example.lab2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

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

