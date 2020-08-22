package com.example.finalchallengeday3_project6_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_ID = "message_id";
    private EditText nameET;
    private Button saveBtn;
    private TextView savedTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = findViewById(R.id.name_eT);
        saveBtn = findViewById(R.id.save_btn);
        savedTV = findViewById(R.id.savedText_tV);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saving value using sp
                String name = nameET.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit().putString("KEY_NAME",name);
                editor.apply();

                // set to text view.
                savedTV.setText(name);
            }
        });

        // retrieving saved value using sp

        SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
        String retrieveValue  = sharedPreferences.getString("KEY_NAME","Default Text");
        savedTV.setText(retrieveValue);



    }

}