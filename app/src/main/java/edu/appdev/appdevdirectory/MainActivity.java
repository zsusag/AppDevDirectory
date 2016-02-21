package edu.appdev.appdevdirectory;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String getStringFromURL(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // JSON
        new DownloadFilesTask().execute();

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
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        startActivity(intent);
                    }
                }
        );

    }

    // Download URL
    class DownloadFilesTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String s = "";
            try {
                s = getStringFromURL("http://www.cs.grinnell.edu/~pradhanp/android.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject mainObject = new JSONObject(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
