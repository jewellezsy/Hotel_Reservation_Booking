package com.example.hotelreservationbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotelreservationbooking.MainActivity;
import com.example.hotelreservationbooking.R;

public class CongratulationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        ImageView ivCongratsGif = findViewById(R.id.ivCongratsGif);
        TextView tvCongratsMessage = findViewById(R.id.tvCongratsMessage);
        Button btnBackToHome = findViewById(R.id.btnBackToHome);

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to MainActivity
                Intent intent = new Intent(CongratulationsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvCongratsMessage.setText("Congratulations! You are now booked at Jiwel Hotel.");
    }
}
