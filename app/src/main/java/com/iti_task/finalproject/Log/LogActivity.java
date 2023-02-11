package com.iti_task.finalproject.Log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;

import com.iti_task.finalproject.databinding.ActivityLogBinding;

public class LogActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLogTag";
    ActivityLogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button3.setOnClickListener(v -> {
            if (binding.etLog.getText().toString().isBlank()) {
                binding.etLog.setError("Enter a log message");
                return;
            }


            String msg = binding.etLog.getText().toString();
            switch (binding.sp.getSelectedItemPosition()) {

                case 0:
                    Log.d(TAG, "onCreate: " + msg);
                    break;
                case 1:
                    Log.i(TAG, "onCreate: " + msg);
                    break;
                case 2:
                    Log.e(TAG, "onCreate: " + msg);
                    break;
                case 3:
                    Log.w(TAG, "onCreate: " + msg);
                    break;
            }
        });
    }
}