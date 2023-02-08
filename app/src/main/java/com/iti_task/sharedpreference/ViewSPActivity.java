package com.iti_task.sharedpreference;

import static com.iti_task.sharedpreference.MainActivity.NUM1;
import static com.iti_task.sharedpreference.MainActivity.NUM2;
import static com.iti_task.sharedpreference.MainActivity.PREF_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.iti_task.sharedpreference.databinding.ActivityViewSpactivityBinding;


public class ViewSPActivity extends AppCompatActivity {
    private int num1;
    private int num2;
    ActivityViewSpactivityBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewSpactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        num1 = preferences.getInt(NUM1, Integer.MIN_VALUE);
        num2 = preferences.getInt(NUM2, Integer.MIN_VALUE);
        if (num1 != Integer.MIN_VALUE) {
            String s = binding.tx1.getText().toString();
            s+= "(" +num1 +")";
            binding.tx1.setText(s);
            if (num1 % 2 == 0) {
                binding.txtR1.setText(R.string.even);
            } else {
                binding.txtR1.setText(R.string.odd);
            }
        } else {
            Toast.makeText(this, "no data in first number", Toast.LENGTH_SHORT).show();
        }
        if (num2 != Integer.MIN_VALUE) {

            String s = binding.tx2.getText().toString();
            s+= "(" +num2 +")";
            binding.tx2.setText(s);
            if (num2 % 2 == 0) {
                binding.txtR2.setText(R.string.even);
            } else {
                binding.txtR2.setText(R.string.odd);
            }
        } else {
            Toast.makeText(this, "no data in second number", Toast.LENGTH_SHORT).show();
        }

        binding.btnB.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

    }


}