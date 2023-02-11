package com.iti_task.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.iti_task.finalproject.Gravity.GravityActivity;
import com.iti_task.finalproject.Log.LogActivity;
import com.iti_task.finalproject.Toast.ToastActivity;
import com.iti_task.finalproject.calculator.CalculatorActivity;
import com.iti_task.finalproject.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        initOnClick();
    }

    private void initOnClick() {
        binding.button.setOnClickListener(v -> {
            startActivity(new Intent(this , ToastActivity.class));
        });
        binding.button2.setOnClickListener(v -> {
            startActivity(new Intent(this , LogActivity.class));
        });
        binding.button4.setOnClickListener(v -> {
            startActivity(new Intent(this , CalculatorActivity.class));
        });
        binding.button6.setOnClickListener(v -> {
            startActivity(new Intent(this , GravityActivity.class));
        });
    }


}