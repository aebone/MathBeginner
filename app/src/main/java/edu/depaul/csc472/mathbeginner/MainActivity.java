package edu.depaul.csc472.mathbeginner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;

import helper.SQLiteHandler;
import helper.SessionManager;


public class MainActivity extends Activity {
    RadioButton RdComplex1, RdComplex2, RdComplex3;
    RadioButton RdPlus;
    RadioButton RdMinus;
    RadioButton RdTimes;
    CheckBox EnableTime;
    Button BtnStart, BtnPrizes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);

        RdComplex1 = (RadioButton)findViewById (R.id.RdComplex1);
        RdComplex2 = (RadioButton)findViewById (R.id.RdComplex2);
        RdComplex3 = (RadioButton)findViewById (R.id.RdComplex3);

        RdPlus = (RadioButton)findViewById (R.id.RdPlus);
        RdMinus = (RadioButton)findViewById (R.id.RdMinus);
        RdTimes = (RadioButton)findViewById (R.id.RdTimes);

        EnableTime = (CheckBox)findViewById (R.id.EnableTime);

        BtnStart = (Button)findViewById (R.id.BtnStart);
        BtnPrizes = (Button)findViewById (R.id.BtnPrizes);

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionOptions.OperationType operation;
                if (RdPlus.isChecked()) {
                    operation = QuestionOptions.OperationType.ADDITION;
                } else if (RdMinus.isChecked()) {
                    operation = QuestionOptions.OperationType.SUBTRACTION;
                } else if (RdTimes.isChecked()) {
                    operation = QuestionOptions.OperationType.MULTIPLICATION;
                } else {
                    operation = QuestionOptions.OperationType.ADDITION;
                }

                int digitCount;
                if (RdComplex1.isChecked()) {
                    digitCount = 1;
                } else if (RdComplex2.isChecked()) {
                    digitCount = 2;
                } else if (RdComplex3.isChecked()) {
                    digitCount = 3;
                } else {
                    digitCount = 1;
                }

                QuestionOptions options = new QuestionOptions(
                        operation, digitCount,
                        EnableTime.isChecked());
                Intent i = new Intent(MainActivity.this, QuestionsActivity.class);
                i.putExtra("edu.depaul.csc472.mathbeginner.option", options);
                startActivity(i);
            }
        });

        RdTimes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MainActivity.this.RdComplex3.setEnabled(false);
                    if (MainActivity.this.RdComplex3.isChecked())
                        MainActivity.this.RdComplex2.setChecked(true);
                } else {
                    MainActivity.this.RdComplex3.setEnabled(true);
                }
            }
        });

        BtnPrizes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PrizeActivity.class);
                startActivity(i);
            }
        });
    }
}
