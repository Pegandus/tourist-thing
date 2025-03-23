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
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up title
        TextView titleTextView = findViewById(R.id.text_app_title);
        titleTextView.setText(getString(R.string.app_title));

        // Set up buttons for navigation
        Button boumerdesButton = findViewById(R.id.button_boumerdes);
        Button algiersButton = findViewById(R.id.button_algiers);

        boumerdesButton.setText(getString(R.string.boumerdes));
        algiersButton.setText(getString(R.string.algiers));

        // Display student information
        TextView studentsInfoTextView = findViewById(R.id.text_students_info);
        studentsInfoTextView.setText("Developed by: [Your Name]");

        // Display app description
        TextView appDescriptionTextView = findViewById(R.id.text_app_description);
        appDescriptionTextView.setText(getString(R.string.app_description));

        // Display selection text
        TextView selectCityTextView = findViewById(R.id.text_select_city);
        selectCityTextView.setText(getString(R.string.select_city));

        // Set up click listeners
        boumerdesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BoumerdesActivity.class);
                startActivity(intent);
            }
        });

        algiersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlgiersActivity.class);
                startActivity(intent);
            }
        });
    }
}