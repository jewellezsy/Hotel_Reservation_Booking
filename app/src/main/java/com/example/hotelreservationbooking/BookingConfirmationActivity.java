package com.example.hotelreservationbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BookingConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        TextView tvConfirmationDetails = findViewById(R.id.tvConfirmationDetails);
        Button btnConfirmBooking = findViewById(R.id.btnConfirmBooking);

        String confirmationMessage = getIntent().getStringExtra("confirmationMessage");
        tvConfirmationDetails.setText(confirmationMessage);

        btnConfirmBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to CongratulationsActivity
                Intent intent = new Intent(BookingConfirmationActivity.this, CongratulationsActivity.class);
                startActivity(intent);
            }
        });
    }
}
