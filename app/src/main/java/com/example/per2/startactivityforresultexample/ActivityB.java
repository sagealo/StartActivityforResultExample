package com.example.per2.startactivityforresultexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity implements View.OnClickListener {
    private EditText textToSend;
    private Button sendMeHomeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        textToSend = findViewById(R.id.edittext_activityb_tosend);
        sendMeHomeButton = findViewById(R.id.button_activityb_sendback);
        sendMeHomeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_activityb_sendback:
                sendMeHome();
        }
    }

    private void sendMeHome() {
        Intent i = new Intent();
        String message = textToSend.getText().toString();
        i.putExtra("Data", message);
        setResult(RESULT_OK, i);
        finish();
    }
}
