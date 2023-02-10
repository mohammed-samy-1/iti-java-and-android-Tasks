package com.iti_task.filestask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.iti_task.filestask.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == binding.rbInternal.getId()) {
                binding.linearInternalFolder.setVisibility(View.VISIBLE);
                binding.toggleButton.setVisibility(View.GONE);
            } else if (checkedId == binding.rbExternal.getId()) {
                binding.linearInternalFolder.setVisibility(View.GONE);
                binding.toggleButton.setVisibility(View.VISIBLE);
            }
        });

        binding.button2.setOnClickListener(v -> {
            if (binding.etEmail.getText().toString().isBlank() || binding.etPass.getText().toString().isBlank()) {
                if (binding.etEmail.getText().toString().isBlank()) {
                    binding.etEmail.setError("Please enter email");
                }
                if (binding.etPass.getText().toString().isBlank()) {
                    binding.etPass.setError("Please enter Password");
                }
            } else {
                saveData();
            }
        });

        binding.checkBoxFolder.setOnCheckedChangeListener((buttonView, isChecked) -> {
                binding.etFolderName.setEnabled(isChecked);
        });

        binding.btnNav.setOnClickListener(v -> {
            startActivity(new Intent(this, ViewDataActivity.class));
            finish();
        });
    }

    private void saveData() {
        if (binding.radioGroup.getCheckedRadioButtonId() == binding.rbInternal.getId()) {
            if (binding.checkBoxFolder.isChecked()) {
                if (binding.etFolderName.getText().toString().isBlank())
                    binding.etFolderName.setError("Please enter a valid name!");
                else
                    saveInFolderInternal(binding.etFolderName.getText().toString());
            } else saveToInternal();
        } else if (binding.radioGroup.getCheckedRadioButtonId() == binding.rbExternal.getId()) {
            if (binding.toggleButton.isChecked())
                saveToPrivateExternal();
            else
                saveToPublicExternal();
        }else
            Toast.makeText(this, "select where to save!", Toast.LENGTH_SHORT).show();
    }

    private void saveToPublicExternal() {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        if (!folder.exists()) {
            if (folder.mkdir()) {
                Log.d(TAG, "saveToPublicExternal: " + folder.getAbsolutePath());
            }
        }
        File file = new File(folder, "my_file.txt");
        writeToFile(file);
    }


    private void saveToPrivateExternal() {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "myPrivateFile.txt");
        writeToFile(file);
    }

    private void saveToInternal() {
        writeToFile(null);
    }


    private void saveInFolderInternal(String folderName) {
        String Folder_Path = getFilesDir().getAbsolutePath() + File.separator + folderName;
        File folderDir = new File(Folder_Path);
        if (!folderDir.exists()) {
            if (folderDir.mkdirs()) {
                Log.d(TAG, "saveInFolderInternal: Directory is created for the first time");
            }
        }
        File file = new File(folderDir, "my_internal_file.txt");
        writeToFile(file);
    }

    private void writeToFile(File file) {
        FileOutputStream outputStream = null;
        try {
            if (file == null) {
                outputStream = openFileOutput("my_default_file.txt", MODE_APPEND);
                Log.d(TAG, "writeToFile: saved to internal");
            }else{
                outputStream = new FileOutputStream(file, true /* to enable append */);
                Log.d(TAG, "writeToFile: path - " + file.getAbsolutePath());
            }
            outputStream.write(binding.etEmail.getText().toString().concat("-").getBytes());
            outputStream.write(binding.etPass.getText().toString().concat("-").getBytes());


            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}