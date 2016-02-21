package edu.appdev.appdevdirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // listView and ProfileAdapter adapters
        List profiles = new ArrayList();
        profiles.add("Larry");
        profiles.add("Sam");
        profiles.add("Bob");
        ProfileAdapter profileAdapter = new ProfileAdapter(this, android.R.layout.simple_list_item_1, profiles);
        ListView profilesView = (ListView) findViewById(R.id.profilesListView);
        profilesView.setAdapter(profileAdapter);

        // View list item
        final Intent intent = new Intent(this, ProfileActivity.class);
        profilesView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        startActivity(intent);
                    }
                }
        );


    }}
