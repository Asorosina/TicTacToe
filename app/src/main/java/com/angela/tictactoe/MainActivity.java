package com.angela.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button buSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int CellID = 0;

    public void BuClick(View view) {
        buSelected = (Button) view;
        CellID = 0;

        switch (buSelected.getId()) {

            case R.id.bu1:
                CellID = 1;
                break;

            case R.id.bu2:
                CellID = 2;
                break;

            case R.id.bu3:
                CellID = 3;
                break;

            case R.id.bu4:
                CellID = 4;
                break;

            case R.id.bu5:
                CellID = 5;
                break;

            case R.id.bu6:
                CellID = 6;
                break;

            case R.id.bu7:
                CellID = 7;
                break;

            case R.id.bu8:
                CellID = 8;
                break;

            case R.id.bu9:
                CellID = 9;
                break;

           case R.id.playAgain:
                CellID = 10;
                break;


        }

        playGame(CellID, buSelected);
        // play again
       if (CellID == 10){

           // deselect

           ((Button) findViewById(R.id.bu1)).setText("");
           ((Button) findViewById(R.id.bu2)).setText("");
           ((Button) findViewById(R.id.bu3)).setText("");
           ((Button) findViewById(R.id.bu4)).setText("");
           ((Button) findViewById(R.id.bu5)).setText("");
           ((Button) findViewById(R.id.bu6)).setText("");
           ((Button) findViewById(R.id.bu7)).setText("");
           ((Button) findViewById(R.id.bu8)).setText("");
           ((Button) findViewById(R.id.bu9)).setText("");

           ((Button) findViewById(R.id.bu1)).setEnabled(true);
           ((Button) findViewById(R.id.bu2)).setEnabled(true);
           ((Button) findViewById(R.id.bu3)).setEnabled(true);
           ((Button) findViewById(R.id.bu4)).setEnabled(true);
           ((Button) findViewById(R.id.bu5)).setEnabled(true);
           ((Button) findViewById(R.id.bu6)).setEnabled(true);
           ((Button) findViewById(R.id.bu7)).setEnabled(true);
           ((Button) findViewById(R.id.bu8)).setEnabled(true);
           ((Button) findViewById(R.id.bu9)).setEnabled(true);
           ((Button) findViewById(R.id.playAgain)).setEnabled(true);

           Player1.clear();
           Player2.clear();
           playGame(CellID, buSelected);
       }

        //}

    }

    int ActivePlayer = 1;
    ArrayList<Integer> Player1 = new ArrayList<Integer>(); // for player 1
    ArrayList<Integer> Player2 = new ArrayList<Integer>(); // for player 2

    public void playGame(int CellID, Button buSelected) {
        Log.d("Player:", String.valueOf(CellID));

        if (ActivePlayer == 1) {
           if( CellID!= 10){
               buSelected.setText("X");
            } else{
               //default
           }

            //buSelected.setBackgroundColor(Color.CYAN);
            Player1.add(CellID);
            ActivePlayer = 2;

        } else if (ActivePlayer == 2) {
            if( CellID!= 10) {
                buSelected.setText("O");
                buSelected.setEnabled(false);
            }else{
                //default
            }
            //buSelected.setBackgroundColor(Color.MAGENTA);
            Player2.add(CellID);
            ActivePlayer = 1;

        }
        //buSelected.setEnabled(false);/// changes color when selected

        findWinner();
    }

    public void findWinner() {
        int winner = -1;

        // play again


        //row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2;
        }

        //row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2;
        }

        //row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2;
        }


        //col 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2;
        }

        //col 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2;
        }


        //col 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2;
        }

        // diagonal 1
        if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9)) {
            winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9)) {
            winner = 2;
        }

        // diagonal 2
        if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7)) {

            winner = 1;
        }
        if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7)) {
            winner = 2;
        }


        if (winner == 1) {
            Toast.makeText(this, "PLAYER 1 WON", Toast.LENGTH_LONG).show();
        }
        if (winner == 2) {
            Toast.makeText(this, "PLAYER 2 WON", Toast.LENGTH_LONG).show();
        }



    }

}

