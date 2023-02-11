package com.iti_task.finalproject.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.iti_task.finalproject.R;
import com.iti_task.finalproject.databinding.ActivityToastBinding;

import java.util.Objects;

public class ToastActivity extends AppCompatActivity {
    ActivityToastBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToastBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding.button3.setOnClickListener(v -> {
            if (binding.etLog.getText().toString().isBlank()){
                return;
            }
            Toast.makeText(this, binding.etLog.getText().toString(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

}