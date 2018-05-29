package com.example.vypt.demoeventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {

    EditText childActivityEditText;
    Button childActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        // init the views
        childActivityEditText = (EditText) findViewById(R.id.childactivity_edittext);
        childActivityButton = (Button) findViewById(R.id.childactivity_button);
        // set the onclick
        childActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setMessage(childActivityEditText.getText().toString());

                EventBus.getDefault().post(messageEvent);
                Toast.makeText(ChildActivity.this, "Send successfull. Please go to main screen to view this", Toast.LENGTH_LONG).show();
            }
        });
    }
}