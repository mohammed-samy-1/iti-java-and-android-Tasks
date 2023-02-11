package com.iti_task.finalproject.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.iti_task.finalproject.databinding.ActivityIntent2Binding;

public class IntentActivity2 extends AppCompatActivity {

    ActivityIntent2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntent2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button3.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra("data" , binding.etLog.getText().toString());
            setResult(RESULT_OK ,i);
            finish();
        });
        binding.button9.setOnClickListener(v -> finish());
    }
}