//package com.example.root.braingames;
//
//import android.os.CountDownTimer;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class balloonActivity extends AppCompatActivity {
//    Button button0;
//    Button button1;
//    Button button2;
//    Button button3;  m
//    RelativeLayout success;
//    RelativeLayout fail;
//    int locationOfCorrectAnswer;
//    int score=0;
//    int numberOfQuestions;
//
//    ArrayList<Integer> answers=new ArrayList<Integer>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_balloon);
//
//
//
//        public void countDown(){
//            results=(TextView) findViewById(R.id.textView5);
//            myScore=(TextView) findViewById(R.id.textScore);
//            new CountDownTimer(30100,1000){
//
//                @Override
//                public void onTick(long l) {
//                    timeText=(TextView) findViewById(R.id.textTime);
//                    timeText.setText(String.valueOf(l/1000));
//                }
//
//                @Override
//                public void onFinish() {
//                    timeText=(TextView) findViewById(R.id.textTime);
//                    timeText.setText("0s");
//                    button0=(Button) findViewById(R.id.button0);
//                    button1=(Button) findViewById(R.id.button1);
//                    button2=(Button) findViewById(R.id.button2);
//                    button3=(Button) findViewById(R.id.button3);
//                    //deactivate buttons
//                    button0.setEnabled(false);
//                    button1.setEnabled(false);
//                    button2.setEnabled(false);
//                    button3.setEnabled(false);
//                    startGame1.setEnabled(true);
//                    startGame2.setEnabled(true);
//
//                    if(score>10){
//                        success=(RelativeLayout) findViewById(R.id.successLayout);
//                        success.setAlpha(1);}
//                    else{
//                        fail=(RelativeLayout) findViewById(R.id.failRelativeLayout);
//                        fail.setAlpha(1);
//                    }
//
//                }
//            }.start();
//        }
//
//
//
//
//    }

