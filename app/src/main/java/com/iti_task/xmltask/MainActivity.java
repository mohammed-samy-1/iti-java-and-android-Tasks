package com.iti_task.xmltask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.iti_task.xmltask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityTag" ;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btmName.setOnClickListener(v -> {
            Toast.makeText(this, binding.editTextTextPersonName.getText().toString(), Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onCreate: "+ binding.editTextTextPersonName.getText().toString());
        });
        binding.btnPass.setOnClickListener(v -> {
            Toast.makeText(this, binding.etPass.getText().toString(), Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onCreate: "+ binding.etPass.getText().toString());
        });
        binding.btnEmail.setOnClickListener(v -> {
            Toast.makeText(this, binding.etMail.getText().toString(), Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onCreate: "+ binding.etMail.getText().toString());
        });
    }
}