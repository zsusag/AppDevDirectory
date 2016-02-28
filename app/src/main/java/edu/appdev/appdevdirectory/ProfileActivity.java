package edu.appdev.appdevdirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    private ImageView mPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mBackButton = (Button) findViewById(R.id.backButton);

        // Dynamic data
        HashMap<String, String> member = (HashMap) getIntent().getSerializableExtra("member");
        mName = (TextView) findViewById(R.id.profNameTextView);
        mRole = (TextView) findViewById(R.id.profRoleTextView);
        mYear = (TextView) findViewById(R.id.profYearTextView);
        mPic = (ImageView) findViewById(R.id.profImageView);

        mName.setText(member.get("name"));
        mRole.setText(member.get("role"));
        mYear.setText(member.get("year"));
        String url = member.get("image");
        Picasso.with(getApplicationContext()).load(url).into(mPic);


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