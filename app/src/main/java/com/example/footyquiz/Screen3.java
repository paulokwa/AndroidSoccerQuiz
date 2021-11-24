package com.example.footyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen3 extends AppCompatActivity {

    private TextView textView;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        textView = findViewById(R.id.textView);
        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Screen1.class);
                startActivity(intent);
            }
        });

// getting the bundle back from the android
        Bundle bundle = getIntent().getExtras();



        textView.setText("Your score is "+ bundle.getInt("score"));
    }
}