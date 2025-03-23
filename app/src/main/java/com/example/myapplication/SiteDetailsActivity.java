package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SiteDetailsActivity extends AppCompatActivity {

    private String siteName;
    private String siteDescription;
    private String sitePhone;
    private String siteEmail;
    private int siteImageId;
    private String siteCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_details);

        // Get data from the intent
        Intent intent = getIntent();
        siteName = intent.getStringExtra("SITE_NAME");
        siteDescription = intent.getStringExtra("SITE_DESCRIPTION");
        sitePhone = intent.getStringExtra("SITE_PHONE");
        siteEmail = intent.getStringExtra("SITE_EMAIL");
        siteImageId = intent.getIntExtra("SITE_IMAGE_ID", R.drawable.placeholder);
        siteCategory = intent.getStringExtra("SITE_CATEGORY");

        // Set up UI elements
        TextView nameTextView = findViewById(R.id.text_site_name);
        TextView categoryTextView = findViewById(R.id.text_site_category);
        TextView descriptionTextView = findViewById(R.id.text_site_description);
        TextView phoneTextView = findViewById(R.id.text_site_phone);
        TextView emailTextView = findViewById(R.id.text_site_email);
        ImageView imageView = findViewById(R.id.image_site);

        Button callButton = findViewById(R.id.button_call);
        Button smsButton = findViewById(R.id.button_sms);
        Button emailButton = findViewById(R.id.button_email);

        // Populate the UI with site data
        nameTextView.setText(siteName);
        categoryTextView.setText(siteCategory);
        descriptionTextView.setText(siteDescription);
        phoneTextView.setText("Phone: " + sitePhone);
        emailTextView.setText("Email: " + siteEmail);
        imageView.setImageResource(siteImageId);

        // Set up button click listeners
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + sitePhone));
                startActivity(callIntent);
            }
        });

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.setData(Uri.parse("smsto:" + sitePhone));
                smsIntent.putExtra("sms_body", "Hello, I am interested in visiting " + siteName);
                startActivity(smsIntent);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + siteEmail));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry about " + siteName);
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello,\n\nI am interested in visiting " +
                        siteName + " and would like more information.\n\nThank you.");
                startActivity(emailIntent);
            }
        });
    }
}