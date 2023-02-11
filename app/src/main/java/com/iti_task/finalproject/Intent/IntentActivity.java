package com.iti_task.finalproject.Intent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.iti_task.finalproject.BuildConfig;
import com.iti_task.finalproject.databinding.ActivityIntentBinding;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class IntentActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher;
    ActivityResultLauncher<Void> takePhoto;
    ActivityIntentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        initLaunchers();
        initOnCLick();
    }

    @SuppressLint("SetTextI18n")
    private void initLaunchers() {
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent i = result.getData();
                        if (null != i) {
                            String data = i.getStringExtra("data");
                            binding.txt.setText(data);
                        }
                    } else {
                        binding.txt.setText("no data");
                    }
                    binding.txt.setVisibility(View.VISIBLE);
                    binding.img.setVisibility(View.GONE);
                }
        );
        takePhoto = registerForActivityResult(
                new ActivityResultContracts.TakePicturePreview(),
                result -> {
                    if (result == null) {
                        return;
                    }
                    binding.img.setVisibility(View.VISIBLE);
                    binding.img.setImageBitmap(result);
                    binding.txt.setVisibility(View.GONE);
                }
        );
    }

    private void initOnCLick() {
        binding.fire.setOnClickListener(v -> {
            switch (binding.sp.getSelectedItemPosition()) {
                case 0:
                    Toast.makeText(this, "please select what you want!", Toast.LENGTH_SHORT).show();
                    return;
                case 1:
                    launcher.launch(new Intent(this, IntentActivity2.class));
                    break;
                case 2:
                    takePhoto.launch(null);
                    break;
                case 3:
                    String url = "http://www.google.com";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    break;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}