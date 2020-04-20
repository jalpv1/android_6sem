package com.example.lab3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class StorageActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.storageactivity);
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ArrayList<String> strings = new ArrayList<>();
        ListView listView = findViewById(R.id.list);

        Button button = findViewById(R.id.cancelButton);
        // database.delete(DBHelper.TABLE_CONTACTS,null,null);
        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
        String res = " ";
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int questionIndex = cursor.getColumnIndex(DBHelper.KEY_QUESTION);
            int answerIndex = cursor.getColumnIndex(DBHelper.KEY_ANSWER);
            do {
                strings.add(cursor.getString(questionIndex) + "    " + cursor.getString(answerIndex));


            } while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");

        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);
            /*Button button = findViewById(R.id.button2);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Intent intent = new Intent(StorageActivity.this, MainActivity.class);
               //     startActivity(intent);

                }
            });





        // setContentView(R.layout.activity_about);
    }

    public void onCancelButtonClick() {

        Intent intent = new Intent(StorageActivity.this, MainActivity.class);
        startActivity(intent);


    }
}

             */
    }
}

