package com.example.android.computerquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //variables to store answers
    //true if answer is correct else false.
    boolean[] qa = {false, false, false, false, false};


    //defines what to perform when submit result button is clicked.
    public void checkResult(View view) {
        calculateResultQuestion1();
        calculateResultQuestion2();
        calculateResultQuestion3();
        calculateResultQuestion4();
        calculateResultQuestion5();
        displayResult();
    }


    //Calculates the result for question 1
    public void calculateResultQuestion1() {

        CheckBox qiCheck1 = (CheckBox) findViewById(R.id.q1box1);
        CheckBox qiCheck2 = (CheckBox) findViewById(R.id.q1box2);
        CheckBox qiCheck3 = (CheckBox) findViewById(R.id.q1box3);
        CheckBox qiCheck4 = (CheckBox) findViewById(R.id.q1box4);
        boolean check1 = qiCheck1.isChecked();
        boolean check2 = qiCheck2.isChecked();
        boolean check3 = qiCheck3.isChecked();
        boolean check4 = qiCheck4.isChecked();

        if (check1 == true && check2 == false && check3 == true && check4 == false) {
            qa[0] = true;
        } else {
            qa[0] = false;
        }

    }

    //calculate result for question 2
    public void calculateResultQuestion2() {
        RadioButton q1Radio3Check = (RadioButton) findViewById(R.id.q2radio3);
        boolean check3 = q1Radio3Check.isChecked();
        if (check3) {
            qa[1] = true;
        } else {
            qa[1] = false;
        }
    }

    //calculates the result for question 3
    public void calculateResultQuestion3() {
        EditText textResult = (EditText) findViewById(R.id.q3editText);
        String textResultString = textResult.getText().toString();
        if (textResultString.equalsIgnoreCase("Charles Babbage")) {
            qa[2] = true;
        } else {
            qa[2] = false;
        }
    }

    //calculates the result for question 4
    public void calculateResultQuestion4() {
        RadioButton q4Radio2Check = (RadioButton) findViewById(R.id.q4radio2);
        boolean check2 = q4Radio2Check.isChecked();
        if (check2) {
            qa[3] = true;
        } else {
            qa[3] = false;
        }
    }

    //calculates the result for question 5
    public void calculateResultQuestion5() {
        RadioButton q5RadioCheck1 = (RadioButton) findViewById(R.id.q5radio1);
        boolean check1 = q5RadioCheck1.isChecked();

        if (check1) {
            qa[4] = true;
        } else {
            qa[4] = false;
        }

    }


    //displays the result as a toast message
    private void displayResult() {

        int countForRightAnswer = 0;

        for (int i = 0; i < 5; i++) {
            if (qa[i]) {
                countForRightAnswer++;
            }
        }

        setImage();

        String displayText = "Total score : " + countForRightAnswer + "/5";

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, displayText, duration);
        toast.show();

    }

    //  method to set visual representation of correctly answered
    //  and not correctly answered questions
    private void setImage() {

        if (qa[0]) {
            ImageView imageView = (ImageView) findViewById(R.id.image1);
            imageView.setImageResource(R.drawable.right);
        } else {
            ImageView imageView = (ImageView) findViewById(R.id.image1);
            imageView.setImageResource(R.drawable.wrong);
        }

        if (qa[1]) {
            ImageView imageView = (ImageView) findViewById(R.id.image2);
            imageView.setImageResource(R.drawable.right);
        } else {
            ImageView imageView = (ImageView) findViewById(R.id.image2);
            imageView.setImageResource(R.drawable.wrong);
        }

        if (qa[2]) {
            ImageView imageView = (ImageView) findViewById(R.id.image3);
            imageView.setImageResource(R.drawable.right);
        } else {
            ImageView imageView = (ImageView) findViewById(R.id.image3);
            imageView.setImageResource(R.drawable.wrong);
        }

        if (qa[3]) {
            ImageView imageView = (ImageView) findViewById(R.id.image4);
            imageView.setImageResource(R.drawable.right);
        } else {
            ImageView imageView = (ImageView) findViewById(R.id.image4);
            imageView.setImageResource(R.drawable.wrong);
        }

        if (qa[4]) {
            ImageView imageView = (ImageView) findViewById(R.id.image5);
            imageView.setImageResource(R.drawable.right);
        } else {
            ImageView imageView = (ImageView) findViewById(R.id.image5);
            imageView.setImageResource(R.drawable.wrong);
        }


    }
}



