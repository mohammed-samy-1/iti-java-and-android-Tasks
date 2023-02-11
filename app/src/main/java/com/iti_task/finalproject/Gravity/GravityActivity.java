package com.iti_task.finalproject.Gravity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.iti_task.finalproject.databinding.ActivityGravityBinding;

public class GravityActivity extends AppCompatActivity {

    ActivityGravityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGravityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListeners();
    }

    private void initListeners() {
        binding.sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(GravityActivity.this, "please select something", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        binding.textView.setGravity(Gravity.CENTER);
                        binding.textView2.setGravity(Gravity.CENTER);
                        break;
                    case 2:
                        binding.textView.setGravity(Gravity.CENTER_VERTICAL);
                        binding.textView2.setGravity(Gravity.CENTER_VERTICAL);
                        break;
                    case 3:
                        binding.textView.setGravity(Gravity.CENTER_HORIZONTAL);
                        binding.textView2.setGravity(Gravity.CENTER_HORIZONTAL);
                        break;
                    case 4:
                        binding.textView.setGravity(Gravity.TOP);
                        binding.textView2.setGravity(Gravity.TOP);
                        break;
                    case 5:
                        binding.textView.setGravity(Gravity.BOTTOM);
                        binding.textView2.setGravity(Gravity.BOTTOM);
                        break;
                    case 6:
                        binding.textView.setGravity(Gravity.END);
                        binding.textView2.setGravity(Gravity.END);
                        break;
                    case 7:
                        binding.textView.setGravity(Gravity.START);
                        binding.textView2.setGravity(Gravity.START);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(GravityActivity.this, "please select something", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        binding.lin.setGravity(Gravity.CENTER_HORIZONTAL);
                        binding.lin2.setGravity(Gravity.CENTER_VERTICAL);
                        break;
                    case 2:
                        binding.lin.setGravity(Gravity.START);
                        binding.lin2.setGravity(Gravity.CENTER_VERTICAL);
                        break;
                    case 3:
                        binding.lin.setGravity(Gravity.CENTER_HORIZONTAL);
                        binding.lin2.setGravity(Gravity.START);
                        break;
                    case 4:
                        binding.lin.setGravity(Gravity.START);
                        binding.lin2.setGravity(Gravity.TOP);
                        break;
                    case 5:
                        binding.lin.setGravity(Gravity.START);
                        binding.lin2.setGravity(Gravity.BOTTOM);
                        break;
                    case 6:
                        binding.lin.setGravity(Gravity.END);
                        binding.lin2.setGravity(Gravity.START);
                        break;
                    case 7:
                        binding.lin.setGravity(Gravity.START);
                        binding.lin2.setGravity(Gravity.START);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}