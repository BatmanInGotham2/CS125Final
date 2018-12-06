package com.sourcey.materiallogindemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

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

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://poker-odds.p.rapidapi.com/hold-em/odds?community=5d%2C7c%2CAh&hand=As%2CKd&players=3";
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("ERROR","error");
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-RapidAPI-Key", "kRCZKdqb2cmsh7tMWKywgoF65D0Ep1gzKRmjsnobQude2GCQKu");
                return params;
            }
        };
        queue.add(getRequest);

        //Log.i("Poker", response.toString());
    }

}
