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

public class AlgiersActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_algiers);

        // Set up the city description
        TextView cityDescTextView = findViewById(R.id.text_city_description);
        cityDescTextView.setText("Algiers is the capital of Algeria, known for its " +
                "whitewashed buildings, Ottoman palaces, and Mediterranean coastline. " +
                "The city offers a rich blend of history, culture, and modern attractions.");

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
                Intent intent = new Intent(AlgiersActivity.this, SiteDetailsActivity.class);

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
        // Example data - you'll need to replace with actual Algiers sites
        // Historical Sites
        siteNames.add("Casbah of Algiers");
        siteDescriptions.add("A UNESCO World Heritage site, the Casbah is a historic " +
                "citadel with narrow winding streets and traditional houses dating back to the Ottoman period.");
        sitePhones.add("+213 456789012");
        siteEmails.add("info@casbahalgiers.dz");
        siteImageIds.add(R.drawable.placeholder); // Replace with actual image resource
        siteCategories.add("Historic Site");

        // Museums
        siteNames.add("National Museum of Fine Arts");
        siteDescriptions.add("One of the largest art museums in Africa with collections " +
                "spanning from ancient artifacts to contemporary Algerian artwork.");
        sitePhones.add("+213 567890123");
        siteEmails.add("contact@museumfinearts.dz");
        siteImageIds.add(R.drawable.placeholder); // Replace with actual image resource
        siteCategories.add("Museum");

        // Gardens
        siteNames.add("Jardin d'Essai du Hamma");
        siteDescriptions.add("A 58-hectare botanical garden with diverse plant species, " +
                "walkways, and recreational areas. One of the most beautiful gardens in Africa.");
        sitePhones.add("+213 678901234");
        siteEmails.add("info@jardinhamma.dz");
        siteImageIds.add(R.drawable.placeholder); // Replace with actual image resource
        siteCategories.add("Garden");

        // Add more sites as needed
    }
}