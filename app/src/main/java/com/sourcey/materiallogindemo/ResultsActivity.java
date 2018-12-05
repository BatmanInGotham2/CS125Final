package com.sourcey.materiallogindemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ResultsActivity extends AppCompatActivity {

    private Button nextTurn;
    Activity currentActivity;

    public ResultsActivity() throws UnirestException {
    }

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
        HttpResponse<JsonNode> response = null;
        try {
            Log.i("Poker", "Before API Call");
            response = Unirest.get("https://poker-odds.p.rapidapi.com/hold-em/odds?community=5d%2C7c%2CAh&hand=As%2CKd&players=3").header("X-RapidAPI-Key", "oSYwc74dq2mshgFSy4inZS2qLgGip1IF3yUjsnx8omDDoyQIxI").asJson();
            Log.i("Poker", "After API Call");
        } catch (UnirestException e) {
            Log.i("Poker", "Inside Stack Trace API Call");
            e.printStackTrace();
        }

        //Log.i("Poker", response.toString());
    }

}
