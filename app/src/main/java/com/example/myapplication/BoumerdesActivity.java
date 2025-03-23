package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BoumerdesActivity extends AppCompatActivity {

    // ArrayLists to store site information
    private ArrayList<String> siteNames = new ArrayList<>();
    private ArrayList<String> siteDescriptions = new ArrayList<>();
    private ArrayList<String> sitePhones = new ArrayList<>();
    private ArrayList<String> siteEmails = new ArrayList<>();
    private ArrayList<Integer> siteImageIds = new ArrayList<>();
    private ArrayList<String> siteCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boumerdes);

        // Set up the city description
        TextView cityDescTextView = findViewById(R.id.text_city_description);
        cityDescTextView.setText("Boumerdes is a coastal city in northern Algeria, " +
                "known for its beautiful beaches and natural landscapes. It offers various " +
                "tourist attractions, hotels, and restaurants.");

        // Initialize site data
        initializeSiteData();

        // Set up the ListView with a simple ArrayAdapter
        ListView sitesListView = findViewById(R.id.list_sites);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                siteNames
        );
        sitesListView.setAdapter(adapter);

        // Set up click listener for the list items
        sitesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BoumerdesActivity.this, SiteDetailsActivity.class);

                // Pass site information to the SiteDetailsActivity
                intent.putExtra("SITE_NAME", siteNames.get(position));
                intent.putExtra("SITE_DESCRIPTION", siteDescriptions.get(position));
                intent.putExtra("SITE_PHONE", sitePhones.get(position));
                intent.putExtra("SITE_EMAIL", siteEmails.get(position));
                intent.putExtra("SITE_IMAGE_ID", siteImageIds.get(position));
                intent.putExtra("SITE_CATEGORY", siteCategories.get(position));

                startActivity(intent);
            }
        });
    }

    private void initializeSiteData() {
        // Example data - you'll need to replace with actual Boumerdes sites
        // Beaches
        siteNames.add("Boumerdes Beach");
        siteDescriptions.add("A beautiful sandy beach stretching along the Mediterranean coast. " +
                "Perfect for swimming and sunbathing during summer months.");
        sitePhones.add("+213 123456789");
        siteEmails.add("info@boumerdesbeach.dz");
        siteImageIds.add(R.drawable.placeholder); // Replace with actual image resource
        siteCategories.add("Beach");

        // Hotels
        siteNames.add("Adim Hotel");
        siteDescriptions.add("A comfortable 4-star hotel with sea view rooms, " +
                "restaurant, and swimming pool. Located near the city center.");
        sitePhones.add("+213 234567890");
        siteEmails.add("booking@adimhotel.dz");
        siteImageIds.add(R.drawable.placeholder); // Replace with actual image resource
        siteCategories.add("Hotel");

        // Restaurants
        siteNames.add("Méditerranée Restaurant");
        siteDescriptions.add("Seafood restaurant offering fresh catch of the day " +
                "and traditional Algerian dishes with a view of the Mediterranean.");
        sitePhones.add("+213 345678901");
        siteEmails.add("reservations@mediterranee.dz");
        siteImageIds.add(R.drawable.placeholder); // Replace with actual image resource
        siteCategories.add("Restaurant");

        // Add more sites as needed
    }
}