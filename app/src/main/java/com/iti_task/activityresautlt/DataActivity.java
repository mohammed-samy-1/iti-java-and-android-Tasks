package com.iti_task.activityresautlt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.iti_task.activityresautlt.databinding.ActivityDataBinding;

public class DataActivity extends AppCompatActivity {

    ActivityDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.dend.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra("data" , binding.editTextTextPersonName.getText().toString());
            setResult(RESULT_OK ,i);
            finish();
        });
        binding.cancel.setOnClickListener(v -> finish());
    }
}