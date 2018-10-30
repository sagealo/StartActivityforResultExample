package com.example.per2.startactivityforresultexample;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private Button sendMeYonder;
    private TextView receivedMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sendMeYonder = findViewById(R.id.button_home_send);
        sendMeYonder.setOnClickListener(this);
        receivedMessage = findViewById(R.id.textview_home_receivedmessage);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_home_send:
                openActivityB();
        }
    }

    private void openActivityB() {
        Intent i = new Intent(getApplicationContext(), ActivityB.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&& resultCode==RESULT_OK)
        {
            String receivedMessage1 = data.getStringExtra("Data");
            receivedMessage.setText(receivedMessage1);
        }
    }
}
