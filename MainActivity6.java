package com.example.myweathernew;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextMessage, editTextPhoneNumber;
    private Spinner spinnerCategory;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        // Initialize Views
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMessage = findViewById(R.id.editTextMessage);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        ratingBar = findViewById(R.id.ratingBar);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String category = spinnerCategory.getSelectedItem().toString();
        float rating = ratingBar.getRating();

        if (name.isEmpty()) {
            editTextName.setError("Name is required");
            return;
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email address");
            return;
        }

        if (message.isEmpty()) {
            editTextMessage.setError("Message cannot be empty");
            return;
        }

        if (phoneNumber.isEmpty()) {
            editTextPhoneNumber.setError("Phone number is required");
            return;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            editTextPhoneNumber.setError("Enter a valid phone number");
            return;
        }

        String toastMessage = "Name: " + name + "\nEmail: " + email + "\nMessage: " + message +
                "\nSubject: " + "\nPhone Number: " + phoneNumber +
                "\nCategory: " + category + "\nRating: " + rating;
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return android.util.Patterns.PHONE.matcher(phoneNumber).matches();
    }
}

