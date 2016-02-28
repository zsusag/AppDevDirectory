package edu.appdev.appdevdirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mBackButton = (Button) findViewById(R.id.backButton);

        // Dynamic data
        HashMap<String, String> member = (HashMap) getIntent().getSerializableExtra("member");

        // Initialize intent
        final Intent intent = new Intent(this, ProfileActivity.class);

        // Back button
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }

        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

}