package com.example.myweathernew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText userName;
    EditText password;
    CheckBox rememberMe;

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";
    private static final String PREF_REMEMBER_ME = "rememberMe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.button);
        userName = findViewById(R.id.editTextNumberDecimal);
        password = findViewById(R.id.editTextNumberDecimal2);
        rememberMe = findViewById(R.id.rememberMeCheckbox);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isRememberMeChecked = prefs.getBoolean(PREF_REMEMBER_ME, false);

        if (isRememberMeChecked) {
            userName.setText(prefs.getString(PREF_USERNAME, ""));
            password.setText(prefs.getString(PREF_PASSWORD, ""));
            rememberMe.setChecked(true);
        }

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString().trim();
                String pw = password.getText().toString().trim();

                if (!username.isEmpty() && !pw.isEmpty()) {

                    if (username.contains(" ") || pw.contains(" ")) {
                        Toast.makeText(MainActivity.this, "Username or Password cannot contain spaces", Toast.LENGTH_SHORT).show();
                    } else {
                        if (rememberMe.isChecked()) {
                            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putString(PREF_USERNAME, username);
                            editor.putString(PREF_PASSWORD, pw);
                            editor.putBoolean(PREF_REMEMBER_ME, true);
                            editor.apply();
                        } else {
                            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                            editor.remove(PREF_USERNAME);
                            editor.remove(PREF_PASSWORD);
                            editor.remove(PREF_REMEMBER_ME);
                            editor.apply();
                        }

                        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(i);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
