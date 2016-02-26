package edu.appdev.appdevdirectory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> memberList;

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
        //List profiles = new ArrayList();
        //profiles.add("Larry");
        //profiles.add("Sam");
        //profiles.add("Bob");
        //ProfileAdapter profileAdapter = new ProfileAdapter(this, android.R.layout.simple_list_item_1, profiles);
        //ListView profilesView = (ListView) findViewById(R.id.profilesListView);
        //profilesView.setAdapter(profileAdapter);

        // View list item
        /*final Intent intent = new Intent(this, ProfileActivity.class);
        profilesView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        startActivity(intent);
                    }
                }
        ); */

    }

    // Download URL
    class DownloadFilesTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            String s = "";
            try {
                s = getStringFromURL("http://www.cs.grinnell.edu/~pradhanp/android.json");
                JSONObject mainObject = new JSONObject(s);
                JSONArray members = mainObject.getJSONArray("members");
                for(int i=0;i<members.length();i++) {
                    HashMap<String, String> member = new HashMap<String, String>();
                    JSONObject c = members.getJSONObject(i);
                    member.put("category", c.getString("category"));
                    member.put("name", c.getString("name"));
                    member.put("year", c.getString("year"));
                    member.put("role", c.getString("role"));
                    member.put("cellphone", c.getString("cellphone"));
                    member.put("email", c.getString("email"));
                    member.put("image", c.getString("image"));
                    member.put("giturl", c.getString("giturl"));
                    member.put("twitterurl", c.getString("twitterurl"));
                    member.put("homepageurl", c.getString("homepageurl"));
                    member.put("linkedurl", c.getString("linkedurl"));

                    memberList.add(member);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            ProfileAdapter profileAdapter = new ProfileAdapter(MainActivity.this, android.R.layout.simple_list_item_1, memberList);

            }
        }
    }

