package edu.appdev.appdevdirectory;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {
    // Declare member variables for TextViews and ImageView
    private TextView mName;
    private TextView mRole;
    private TextView mYear;
    //private TextView mCell; No data in JSON file as of 3/21/2016
    private TextView mEmail;
    private ImageView mGit;
    private ImageView mTwitter;
    private ImageView mHome;
    private ImageView mLinkedIn;

    private ImageView mPic;

    private View mLine;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.profileToolbar); // Cast as toolbar
        myToolbar.setTitle(R.string.app_name);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        //mBackButton = (Button) findViewById(R.id.backButton);



        // Dynamic data insertion
        final HashMap<String, String> member = (HashMap) getIntent().getSerializableExtra("member");
        mName = (TextView) findViewById(R.id.profNameTextView);
        mRole = (TextView) findViewById(R.id.roleTextView);
        mYear = (TextView) findViewById(R.id.yearTextView);
        //mCell = (TextView) findViewById(R.id.cellTextView);
        mEmail = (TextView) findViewById(R.id.emailTextView);
        mTwitter = (ImageView) findViewById(R.id.twitterIcon);
        mGit = (ImageView) findViewById(R.id.githubIcon);
        mHome = (ImageView) findViewById(R.id.websiteIcon);
        mLinkedIn = (ImageView) findViewById(R.id.linkedinIcon);
        mPic = (ImageView) findViewById(R.id.profImageView);

        // Set text from ArrayList from JSON parsed data
        mName.setText(member.get("name"));
        mRole.setText(member.get("role"));
        mYear.setText(member.get("year"));
        //mCell.setText(member.get("cellphone"));
        mEmail.setText(member.get("email"));
        // Populates links fields if data present otherwise makes TextViews invisible
        if (member.get("twitterurl").equals("")) {
            mTwitter.setVisibility(View.GONE);
        } else {
            mTwitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToUrl(member.get("twitterurl"));
                }
            });
            mTwitter.setVisibility(View.VISIBLE);

        }

        if (member.get("giturl").equals("")) {
            mGit.setVisibility(View.GONE);
        } else {
            mGit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToUrl(member.get("giturl"));
                }
            });
            mGit.setVisibility(View.VISIBLE);
        }

        if (member.get("homepageurl").equals("")) {
            mHome.setVisibility(View.GONE);
        } else {
            mHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToUrl(member.get("homepageurl"));
                }
            });
            mHome.setVisibility(View.VISIBLE);
        }

        if (member.get("linkedurl").equals("")) {
            mLinkedIn.setVisibility(View.GONE);
        } else {
            mLinkedIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToUrl(member.get("linkedurl"));
                }
            });
            mLinkedIn.setVisibility(View.VISIBLE);
        }

        // Sets image as image from URL otherwise sets default as AppDev Logo from drawable resources
        String url = member.get("image");
            Picasso.with(getApplicationContext()).load(url).placeholder(R.drawable.appdevlogo).into(mPic);

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

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
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