package com.example.root.braingames;

import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class secondActivity extends AppCompatActivity {
    Button startGame1;
    Button startGame2;
    TextView totalSum;
    TextView results;
    TextView myScore;
    TextView timeText;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    RelativeLayout success;
    RelativeLayout fail;
    //location of correct answer in the layout
    int locationOfCorrectAnswer;
    int score=0;
    int numberOfQuestions;

    /**
     private static final long ROLE_ANY = 0x0; // can play in any match.
     private static final long ROLE_FARMER = 0x1; // 001 in binary
     private static final long ROLE_ARCHER = 0x2; // 010 in binary
     private static final long ROLE_WIZARD = 0x4; // 100 in binary

     private void startQuickGame(long role) {
     // auto-match criteria to invite one random automatch opponent.
     // You can also specify more opponents (up to 3).
     Bundle autoMatchCriteria = RoomConfig.createAutoMatchCriteria(1, 1, role);

     // build the room config:
     RoomConfig roomConfig =
     RoomConfig.builder(mRoomUpdateCallback)
     .setOnMessageReceivedListener(mMessageReceivedHandler)
     .setRoomStatusUpdateCallback(mRoomStatusCallbackHandler)
     .setAutoMatchCriteria(autoMatchCriteria)
     .build();

     // prevent screen from sleeping during handshake
     getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

     // Save the roomConfig so we can use it if we call leave().
     mJoinedRoomConfig = roomConfig;

     // create room:
     Games.getRealTimeMultiplayerClient(this, GoogleSignIn.getLastSignedInAccount(this))
     .create(roomConfig);
     }

     **/
    //will contain answers
    ArrayList<Integer> answers=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        generateNewQuestion();

         totalSum =(TextView) findViewById(R.id.totalSum);
        //styling the activity
        TextView score=(TextView) findViewById(R.id.textScore);
        TextView time=(TextView) findViewById(R.id.textTime);
        TextView total=(TextView) findViewById(R.id.totalSum);
        TextView answer=(TextView) findViewById(R.id.textView5);

        Typeface amatic=Typeface.createFromAsset(getAssets(),"fonts/Amatic-Bold.ttf");
        score.setTypeface(amatic);
        time.setTypeface(amatic);
        total.setTypeface(amatic);
        answer.setTypeface(amatic);

        //buttons to display the answers
         button0=(Button) findViewById(R.id.button0);
         button1=(Button) findViewById(R.id.button1);
         button2=(Button) findViewById(R.id.button2);
         button3=(Button) findViewById(R.id.button3);
         startGame1=(Button) findViewById(R.id.startGameAgain);
         startGame2=(Button) findViewById(R.id.button);
        //get view for score and results
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        //invisible layouts
        success=(RelativeLayout) findViewById(R.id.successLayout);
        startGame1.setEnabled(false);
        startGame2.setEnabled(false);

        //countdown timer

        countDown();
    }
    public void countDown(){
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timeText=(TextView) findViewById(R.id.textTime);
                timeText.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                timeText=(TextView) findViewById(R.id.textTime);
                timeText.setText("0s");
                button0=(Button) findViewById(R.id.button0);
                button1=(Button) findViewById(R.id.button1);
                button2=(Button) findViewById(R.id.button2);
                button3=(Button) findViewById(R.id.button3);
                //deactivate buttons
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                startGame1.setEnabled(true);
                startGame2.setEnabled(true);

                if(score>10){
                    success=(RelativeLayout) findViewById(R.id.successLayout);
                    success.setAlpha(1);}
                else{
                    fail=(RelativeLayout) findViewById(R.id.failRelativeLayout);
                    fail.setAlpha(1);
                }

            }
        }.start();
    }

    /**
     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     if (requestCode == RC_SELECT_PLAYERS) {
     if (resultCode != Activity.RESULT_OK) {
     // Canceled or some other error.
     return;
     }

     // Get the invitee list.
     final ArrayList<String> invitees = data.getStringArrayListExtra(Games.EXTRA_PLAYER_IDS);

     // Get Automatch criteria.
     int minAutoPlayers = data.getIntExtra(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, 0);
     int maxAutoPlayers = data.getIntExtra(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, 0);

     // Create the room configuration.
     RoomConfig.Builder roomBuilder = RoomConfig.builder(mRoomUpdateCallback)
     .setOnMessageReceivedListener(mMessageReceivedHandler)
     .setRoomStatusUpdateCallback(mRoomStatusCallbackHandler)
     .addPlayersToInvite(invitees);
     if (minAutoPlayers > 0) {
     roomBuilder.setAutoMatchCriteria(
     RoomConfig.createAutoMatchCriteria(minAutoPlayers, maxAutoPlayers, 0));
     }

     // Save the roomConfig so we can use it if we call leave().
     mJoinedRoomConfig = roomBuilder.build();
     Games.getRealTimeMultiplayerClient(this, GoogleSignIn.getLastSignedInAccount(this))
     .create(mJoinedRoomConfig);
     }
     }
     **/




    public void startAgain(View view){
        //get view from the invisible layouts
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        //when the game starts,disable the play again button
        startGame1.setEnabled(false);
        startGame2.setEnabled(false);
        //enable the answer buttons when the user plays again
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        //make the layouts that pop up invisible
        success=(RelativeLayout) findViewById(R.id.successLayout);
        success.setAlpha(0);
        fail=(RelativeLayout) findViewById(R.id.failRelativeLayout);
        fail.setAlpha(0);
        //reset the score and number of questions back to 0
        score=0;
        numberOfQuestions=0;
        results=(TextView) findViewById(R.id.textView5);
        myScore=(TextView) findViewById(R.id.textScore);
        timeText=(TextView) findViewById(R.id.textTime);
        //set the score to 0
        results.setText(Integer.toString(score));
        myScore.setText(Integer.toString(score)+"/"+ Integer.toString(numberOfQuestions));

        timeText.setText("0");
        generateNewQuestion();
        countDown();
    }
    public void generateNewQuestion(){
        button0=(Button) findViewById(R.id.button0);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        //generate random numbers for the trivia
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        //set the textview
        totalSum =(TextView) findViewById(R.id.totalSum);
        totalSum.setText(Integer.toString(a) + " + " +Integer.toString(b));
        //location is based on the tag of buttons which is from 0-3
        locationOfCorrectAnswer=rand.nextInt(4);
        //setting correct answer
        for(int i=0;i<4;i++){
            //if the button is the loacation of the correct answer,
            //add the correct to the arrayList
            int incorrectAnswer;
            if(i == locationOfCorrectAnswer){
                answers.add(a+b);
            }
            //if it is not the location of the correct answer
            else{
                incorrectAnswer=rand.nextInt(41);
                while(incorrectAnswer == a+b){
                    //stop generation of correct answer in wrong answer layout
                   incorrectAnswer=rand.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }
        //set text according to the number in the arraylist at the positions
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
        answers.clear();
    }


    /**
     private RoomUpdateCallback mRoomUpdateCallback = new RoomUpdateCallback() {
    @Override
    public void onRoomCreated(int code, @Nullable Room room) {
    // Update UI and internal state based on room updates.
    if (code == GamesCallbackStatusCodes.OK && room != null) {
    Log.d(TAG, "Room " + room.getRoomId() + " created.");
    } else {
    Log.w(TAG, "Error creating room: " + code);
    // let screen go to sleep
    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }
    }

    @Override
    public void onJoinedRoom(int code, @Nullable Room room) {
    // Update UI and internal state based on room updates.
    if (code == GamesCallbackStatusCodes.OK && room != null) {
    Log.d(TAG, "Room " + room.getRoomId() + " joined.");
    } else {
    Log.w(TAG, "Error joining room: " + code);
    // let screen go to sleep
    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }
    }

    @Override
    public void onLeftRoom(int code, @NonNull String roomId) {
    Log.d(TAG, "Left room" + roomId);
    }

    @Override
    public void onRoomConnected(int code, @Nullable Room room) {
    if (code == GamesCallbackStatusCodes.OK && room != null) {
    Log.d(TAG, "Room " + room.getRoomId() + " connected.");
    } else {
    Log.w(TAG, "Error connecting to room: " + code);
    // let screen go to sleep
    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }
    }
    };
     **/
    //method to find answer
    public void getAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
           score ++;
            numberOfQuestions++;
            results.setText("correct");
            myScore.setText(Integer.toString(score)+"/"+ Integer.toString(numberOfQuestions));
        }
        else{
            score+=0;
            numberOfQuestions++;
            results.setText("Incorrect");
            myScore.setText(Integer.toString(score)+"/"+ Integer.toString(numberOfQuestions));

        }
        generateNewQuestion();

/**

 private void playTurn(TurnBasedMatch match) {
 String nextParticipantId = getNextParticipantId(mMyPlayerId, match);

 // This calls a game specific method to get the bytes that represent the game state
 // including the current player's turn.
 byte[] gameData = serializeGameData();

 Games.getTurnBasedMultiplayerClient(this, GoogleSignIn.getLastSignedInAccount(this))
 .takeTurn(match.getMatchId(), gameData, nextParticipantId)
 .addOnCompleteListener(new OnCompleteListener<TurnBasedMatch>() {
@Override
public void onComplete(@NonNull Task<TurnBasedMatch> task) {
if (task.isSuccessful()) {
TurnBasedMatch match = task.getResult();
} else {
// Handle exceptions.
}
}
});
 } 
 **/

    }

}
