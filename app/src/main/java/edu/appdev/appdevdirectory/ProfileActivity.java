package edu.appdev.appdevdirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private Button mBackButton;
    private TextView mName;
    private TextView mRole;
    private TextView mYear;
    private TextView mCell;
    private TextView mEmail;
    private TextView mGit;
    private TextView mTwitter;
    private TextView mHome;
    private TextView mLinkedIn;

    private ImageView mPic;

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
        mCell = (TextView) findViewById(R.id.cellTextView);
        mEmail = (TextView) findViewById(R.id.emailTextView);
        mTwitter = (TextView) findViewById(R.id.twitterTextView);
        mGit = (TextView) findViewById(R.id.gitTextView);
        mHome = (TextView) findViewById(R.id.homeTextView);
        mLinkedIn = (TextView) findViewById(R.id.linkedInTextView);
        mPic = (ImageView) findViewById(R.id.profImageView);

        mName.setText(member.get("name"));
        mRole.setText(member.get("role"));
        mYear.setText(member.get("year"));
        mCell.setText(member.get("cellphone"));
        mEmail.setText(member.get("email"));
        mTwitter.setText(member.get("twitterurl"));
        mGit.setText(member.get("giturl"));
        mHome.setText(member.get("homepageurl"));
        mLinkedIn.setText(member.get("linkedurl"));
        String url = member.get("image");
        Picasso.with(getApplicationContext()).load(url).into(mPic);


        // Initialize intent
        final Intent intent = new Intent(this, ProfileActivity.class);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

}