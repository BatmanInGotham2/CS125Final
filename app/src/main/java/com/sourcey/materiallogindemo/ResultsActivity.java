package com.sourcey.materiallogindemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ResultsActivity extends AppCompatActivity {

    private Button nextTurn;
    Activity currentActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //Log.i("Poker", "bitch");
        currentActivity = this;
        nextTurn = findViewById(R.id.next_button);
        nextTurn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentActivity, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
