package com.zachrawi.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonTrue;
    private Button buttonFalse;

    private TextView textViewScore;
    private TextView textViewQuestion;

    private Quiz[] quizzes;

    private  int index = 0;
    private  int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      buttonTrue = findViewById(R.id.buttonTrue);
      buttonFalse = findViewById(R.id.buttonFalse);

      textViewScore = findViewById(R.id.textViewScore);
      textViewQuestion = findViewById(R.id.textViewQuestion) ;

      quizzes = new Quiz [] {
              new Quiz(R.string.question_1,false),
              new Quiz(R.string.question_2,false),
              new Quiz(R.string.question_3,true),
              new Quiz(R.string.question_4,false),
              new Quiz(R.string.question_5,false),
              new Quiz(R.string.question_6,true),
              new Quiz(R.string.question_7,true),
              new Quiz(R.string.question_8,true),
              new Quiz(R.string.question_9,true),
              new Quiz(R.string.question_10,true),
      };
      updateView();

      buttonTrue.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Quiz quiz = quizzes[index];

              if (quiz.isAnswerTrue()) {
                  score = score + 1;

                  Toast.makeText(MainActivity.this, "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
              } else {
                  Toast.makeText(MainActivity.this, "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
              }

              index = index + 1;
              updateView();
          }
      });
      buttonFalse.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Quiz quiz = quizzes[index];

              if (!quiz.isAnswerTrue()) {
                  score = score + 1;

                  Toast.makeText(MainActivity.this, "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
              } else  {
                  Toast.makeText(MainActivity.this, "Jawaban Anda Salah", Toast.LENGTH_SHORT).show();
              }

              index = index + 1;
              updateView();
          }
      });
      
    }
    private  void  updateView() {
        if (index < quizzes.length) {
            Quiz quiz = quizzes[index];
            textViewQuestion.setText(quiz.getQuestion());

            textViewScore.setText("Score: " + score + "/" + quizzes.length);
        } else {
            textViewQuestion.setText("Nilai anda:" + score);
            textViewScore.setVisibility(View.INVISIBLE);

            buttonTrue.setEnabled(false);
            buttonFalse.setEnabled(false);
        }
    }
}
