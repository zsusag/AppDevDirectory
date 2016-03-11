package edu.appdev.appdevdirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private Button mBackButton;
    private TextView mName;
    private TextView mRole;
    private TextView mYear;
    //private TextView mCell;
    private TextView mEmail;
    private TextView mGit;
    private TextView mTwitter;
    private TextView mHome;
    private TextView mLinkedIn;

    private ImageView mPic;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //mBackButton = (Button) findViewById(R.id.backButton);

        // Dynamic data
        HashMap<String, String> member = (HashMap) getIntent().getSerializableExtra("member");
        mName = (TextView) findViewById(R.id.profNameTextView);
        mRole = (TextView) findViewById(R.id.roleTextView);
        mYear = (TextView) findViewById(R.id.yearTextView);
        //mCell = (TextView) findViewById(R.id.cellTextView);
        mEmail = (TextView) findViewById(R.id.emailTextView);
        mTwitter = (TextView) findViewById(R.id.twitterTextView);
        mGit = (TextView) findViewById(R.id.gitTextView);
        mHome = (TextView) findViewById(R.id.homeTextView);
        mLinkedIn = (TextView) findViewById(R.id.linkedInTextView);
        mPic = (ImageView) findViewById(R.id.profImageView);


        mName.setText(member.get("name"));
        mRole.setText(member.get("role"));
        mYear.setText(member.get("year"));
        //mCell.setText(member.get("cellphone"));
        mEmail.setText(member.get("email"));
        mTwitter.setText(member.get("twitterurl"));
        mGit.setText(member.get("giturl"));
        mHome.setText(member.get("homepageurl"));
        mLinkedIn.setText(member.get("linkedurl"));
        System.out.println(mTwitter.getText());
        if (mTwitter.getText().equals("")) {
            mTwitter.setVisibility(View.GONE);
        } else {
            mTwitter.setText(member.get("twitterurl"));
            mTwitter.setVisibility(View.VISIBLE);
        }

        if (mGit.getText().equals("")) {
            mGit.setVisibility(View.GONE);
        } else {
            mGit.setText(member.get("giturl"));
            mGit.setVisibility(View.VISIBLE);
        }

        if (mHome.getText().equals("")) {
            mHome.setVisibility(View.GONE);
        } else {
            mHome.setText(member.get("homepageurl"));
            mHome.setVisibility(View.VISIBLE);
        }

        if (mLinkedIn.getText().equals("")) {
            mLinkedIn.setVisibility(View.GONE);
        } else {
            mLinkedIn.setText(member.get("linkedurl"));
            mLinkedIn.setVisibility(View.VISIBLE);
        }

        String url = member.get("image");
        Picasso.with(getApplicationContext()).load(url).into(mPic);
        // Initialize intent
        final Intent intent = new Intent(this, ProfileActivity.class);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Profile Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://edu.appdev.appdevdirectory/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Profile Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://edu.appdev.appdevdirectory/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}