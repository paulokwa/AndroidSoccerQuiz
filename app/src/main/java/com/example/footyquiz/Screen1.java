package com.example.footyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Screen1 extends AppCompatActivity {

    private EditText editTextTextPersonName;
    private Button button;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextTextPersonName.getText().toString();

                if(!name.isEmpty())
                    startQuiz();
                else
                    editTextTextPersonName.setError("Enter name");
            }
        });


    }

    private void startQuiz(){
        // creating a intent
        Intent intent = new Intent(this, Screen2.class);
// creating a bundle object
        Bundle bundle = new Bundle();

// storing the string value in the bundle
// which is mapped to key

        bundle.putString("name", name);

// passing the bundle into the intent
        intent.putExtras(bundle);

// starting the intent
        startActivity(intent);
    }
}