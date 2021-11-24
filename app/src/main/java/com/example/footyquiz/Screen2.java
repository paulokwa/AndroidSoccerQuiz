package com.example.footyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Random;

public class Screen2 extends AppCompatActivity {

    private TextView textView2,textView3, textView4;
    private int score, qsNo;
    private RadioButton radioButton9, radioButton10, radioButton11, radioButton12;
    private Button button2;
    private RadioGroup radiogroup;
    private String selectedAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        radiogroup = findViewById(R.id.radiogroup);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedAnswer = ((RadioButton) findViewById(checkedId)).getText().toString();
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
        radioButton9 = findViewById(R.id.radioButton9);
        radioButton10 = findViewById(R.id.radioButton10);
        radioButton11 = findViewById(R.id.radioButton11);
        radioButton12 = findViewById(R.id.radioButton12);


        textView3.setText(getIntent().getExtras().getString("name"));

        Business.readFile(getApplicationContext());
        textView4.setText(Business.getTerms().get(qsNo++));

        radioButton9.setText(Business.getDefinitions().remove(0));
        radioButton10.setText(Business.getDefinitions().remove(0));
        radioButton11.setText(Business.getDefinitions().remove(0));
        radioButton12.setText(Business.getDefinitions().remove(0));
    }

    private void updateQuestion() {





        //Collections.shuffle(Business.getDefinitions());

        selectedAnswer = ((RadioButton) findViewById(radiogroup.getCheckedRadioButtonId())).getText().toString();


        if (Business.isCorrect(selectedAnswer,qsNo)) {
            ++score;
            textView2.setText("Score : " + score);
            Toast.makeText(getApplicationContext(), "Correct answer", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Wrong answer", Toast.LENGTH_SHORT).show();
        }

        if(Business.getTerms().size() == qsNo){
            showFinalScore();
        }else {
            if(new Random().nextInt(4)==1){
                radioButton9.setText(Business.getDefinitions().remove(0));
                radioButton10.setText(Business.getDefinitions().remove(0));
                radioButton11.setText(Business.getDefinitions().remove(0));
                radioButton12.setText(Business.getDefinitions().remove(0));
            }else if(new Random().nextInt(4)==2){
                radioButton10.setText(Business.getDefinitions().remove(0));
                radioButton9.setText(Business.getDefinitions().remove(0));
                radioButton11.setText(Business.getDefinitions().remove(0));
                radioButton12.setText(Business.getDefinitions().remove(0));
            }else if(new Random().nextInt(4)==3){
                radioButton11.setText(Business.getDefinitions().remove(0));
                radioButton10.setText(Business.getDefinitions().remove(0));
                radioButton9.setText(Business.getDefinitions().remove(0));
                radioButton12.setText(Business.getDefinitions().remove(0));
            }else{
                radioButton12.setText(Business.getDefinitions().remove(0));
                radioButton11.setText(Business.getDefinitions().remove(0));
                radioButton10.setText(Business.getDefinitions().remove(0));
                radioButton9.setText(Business.getDefinitions().remove(0));
            }


            textView4.setText(Business.getTerms().get(qsNo++));
        }





    }

    private void showFinalScore(){
        Intent intent = new Intent(this, Screen3.class);
// creating a bundle object
        Bundle bundle = new Bundle();

// storing the string value in the bundle
// which is mapped to key
        bundle.putInt("score", score);

// passing the bundle into the intent
        intent.putExtras(bundle);

// starting the intent
        startActivity(intent);
    }
}