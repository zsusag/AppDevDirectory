package edu.appdev.appdevdirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mSwitchActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // listView and ProfileAdapter adapters
        List profiles = new ArrayList();
        profiles.add("");
        profiles.add("");
        profiles.add("");
        ProfileAdapter profileAdapter = new ProfileAdapter(this, android.R.layout.simple_list_item_1, profiles);
        ListView profilesView = (ListView) findViewById(R.id.profilesListView);
        profilesView.setAdapter(profileAdapter);

        // View profile button
        mSwitchActivityButton = (Button) findViewById(R.id.switchActivityButton);
        final Intent intent = new Intent(this, ProfileActivity.class);
        mSwitchActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }

        });

    }}
