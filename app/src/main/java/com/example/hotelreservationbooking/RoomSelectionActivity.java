package com.example.hotelreservationbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class RoomSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_selection);

        // UI Elements
        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etLastName);
        EditText etAdults = findViewById(R.id.etAdults);
        EditText etKids = findViewById(R.id.etKids);
        Spinner spinnerCheckInDay = findViewById(R.id.spinnerCheckInDay);
        Spinner spinnerCheckInMonth = findViewById(R.id.spinnerCheckInMonth);
        Spinner spinnerCheckOutDay = findViewById(R.id.spinnerCheckOutDay);
        Spinner spinnerCheckOutMonth = findViewById(R.id.spinnerCheckOutMonth);
        Spinner spinnerRoomType = findViewById(R.id.spinnerRoomType);
        Button btnConfirmDetails = findViewById(R.id.btnConfirmDetails);

        // Setup Spinners
        setupDateSpinners(spinnerCheckInDay, spinnerCheckInMonth);
        setupDateSpinners(spinnerCheckOutDay, spinnerCheckOutMonth);

        // Room Types
        String[] roomTypes = {"Deluxe Room", "Deluxe Superior", "Junior Suite", "Family Suite", "Executive Suite"};
        ArrayAdapter<String> roomAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roomTypes);
        roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoomType.setAdapter(roomAdapter);

        // Confirm Details Button
        btnConfirmDetails.setOnClickListener(v -> confirmDetails(etFirstName, etLastName, etAdults, etKids, spinnerCheckInDay, spinnerCheckInMonth, spinnerCheckOutDay, spinnerCheckOutMonth, spinnerRoomType));
    }

    private void setupDateSpinners(Spinner spinnerDay, Spinner spinnerMonth) {
        String[] days = new String[31];
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }

        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, days);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDay.setAdapter(dayAdapter);
        spinnerMonth.setAdapter(monthAdapter);
    }

    private void confirmDetails(EditText firstName, EditText lastName, EditText adults, EditText kids, Spinner checkInDay, Spinner checkInMonth, Spinner checkOutDay, Spinner checkOutMonth, Spinner roomType) {
        String firstNameText = firstName.getText().toString().trim();
        String lastNameText = lastName.getText().toString().trim();
        String adultsText = adults.getText().toString().trim();
        String kidsText = kids.getText().toString().trim();

        String checkInDayText = checkInDay.getSelectedItem().toString();
        String checkInMonthText = checkInMonth.getSelectedItem().toString();
        String checkOutDayText = checkOutDay.getSelectedItem().toString();
        String checkOutMonthText = checkOutMonth.getSelectedItem().toString();

        String selectedRoomType = roomType.getSelectedItem().toString();
        double roomPrice = getRoomPrice(selectedRoomType);

        int checkInDayInt = Integer.parseInt(checkInDayText);
        int checkOutDayInt = Integer.parseInt(checkOutDayText);
        int duration = checkOutDayInt - checkInDayInt;

        // Create confirmation message
        String confirmationMessage = String.format("Details Confirmed!\nName: %s %s\nAdults/Kids: %s/%s\nRoom Type: %s\nCheck-In: %s %s\nCheck-Out: %s %s\nDuration: %d nights\nPrice: ₱%.2f per night",
                firstNameText, lastNameText, adultsText, kidsText, selectedRoomType, checkInDayText, checkInMonthText, checkOutDayText, checkOutMonthText, duration, roomPrice);

        // Navigate to BookingConfirmationActivity
        Intent intent = new Intent(this, BookingConfirmationActivity.class);
        intent.putExtra("confirmationMessage", confirmationMessage);
        startActivity(intent);
    }

    private double getRoomPrice(String roomType) {
        switch (roomType) {
            case "Deluxe Room":
                return 2685.00;
            case "Deluxe Superior":
                return 3355.00;
            case "Junior Suite":
                return 4030.00;
            case "Family Suite":
                return 8055.00;
            case "Executive Suite":
                return 5370.00;
            default:
                return 0;
        }
    }
}
