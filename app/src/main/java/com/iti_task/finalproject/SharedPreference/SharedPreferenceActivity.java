package com.iti_task.finalproject.SharedPreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.iti_task.finalproject.databinding.ActivitySharedPreferenceBinding;

public class SharedPreferenceActivity extends AppCompatActivity {
    public static final String NUM1 = "num1";
    public static final String NUM2 = "num2";
    public static final String PREF_NAME = "pref";
    ActivitySharedPreferenceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharedPreferenceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        binding.btnNum1.setOnClickListener(v -> {
            SharedPreferences.Editor edit = preferences.edit();
            if (!binding.etNum1.getText().toString().isBlank()){
                edit.putInt(NUM1, Integer.parseInt(binding.etNum1.getText().toString()));
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                binding.etNum1.setText("");
            } else
                binding.etNum1.setError("please enter a number");
            edit.apply();
        });
        binding.btnNum2.setOnClickListener(v -> {
            SharedPreferences.Editor edit = preferences.edit();
            if (!binding.etNum2.getText().toString().isBlank()) {
                edit.putInt(NUM2, Integer.parseInt(binding.etNum2.getText().toString()));
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                binding.etNum2.setText("");
            } else
                binding.etNum2.setError("enter a number");
            edit.apply();
        });
        binding.btnResult.setOnClickListener(v -> {
            startActivity(new Intent(this, ViewSpActivity.class));
        });
    }
}