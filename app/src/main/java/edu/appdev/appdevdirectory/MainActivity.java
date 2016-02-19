package edu.appdev.appdevdirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mSwitchActivityButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwitchActivityButton = (Button) findViewById(R.id.switchActivityButton);
        final Intent intent = new Intent(this, ProfileActivity.class);
        mSwitchActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }

        });

        // Set up listView with adapters
        String[] names = {"hello", "world", "test", "hello", "world", "test", "hello", "world", "test", "hello", "world", "test", "hello", "world", "test"};
        List listA = new ArrayList();
        listA.add("element 1");
        listA.add("element 2");
        listA.add("element 3");
        //ListAdapter profileAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        ProfileAdapter profileAdapter = new ProfileAdapter(this, android.R.layout.simple_list_item_1, listA);
        ListView profilesView = (ListView) findViewById(R.id.profilesListView);
        profilesView.setAdapter(profileAdapter);

    }}
