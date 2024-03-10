package com.example.networktest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ClientTCP clientTCP;

    TextView textViewUserPrompt;
    TextView textViewResultOutput;
    EditText editTextUserInput;
    Button buttonSend;
    Button buttonCompute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        clientTCP = new ClientTCP();

        textViewUserPrompt = findViewById(R.id.textViewUserPrompt);
        textViewResultOutput = findViewById(R.id.textViewResultOutput);
        editTextUserInput = findViewById(R.id.editTextUserInput);
        buttonSend = findViewById(R.id.buttonSend);
        buttonCompute = findViewById(R.id.buttonCompute);

        buttonSend.setOnClickListener(
                view -> {
                    String input = editTextUserInput.getText().toString();

                    try {
                        String serverAnswer = clientTCP.getServerAnswer(
                                String.valueOf(Integer.parseInt(input)));

                        textViewResultOutput.setText(serverAnswer);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );


    }
}