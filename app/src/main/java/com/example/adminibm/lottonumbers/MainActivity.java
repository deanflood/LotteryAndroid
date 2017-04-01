package com.example.adminibm.lottonumbers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adminibm.lottonumbers.service.QuickPickService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateTitle(View v){
        TextView title = (TextView) findViewById(R.id.title);
        EditText max = (EditText) findViewById(R.id.max);
        EditText number = (EditText) findViewById(R.id.number);
        title.setText("Pick " + number.getText() + " balls between 1 and " + max.getText() + ".");
    }

    public void closeKeyboard(View v){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public void buttonClicked(View v) {
        try {
            EditText max = (EditText) findViewById(R.id.max);
            EditText number = (EditText) findViewById(R.id.number);
            TextView resultsView = (TextView) findViewById(R.id.results);
            resultsView.setText("");
            int maxInt = Integer.parseInt(max.getText().toString());
            int numInt = Integer.parseInt(number.getText().toString());

            resultsView.setText(QuickPickService.quickPick(numInt, maxInt));
            updateTitle(v);
            closeKeyboard(v);
        } catch (NumberFormatException e) {
            TextView title = (TextView) findViewById(R.id.title);
            title.setText("Input must not be blank!");
            e.printStackTrace();
        }
    }
}





