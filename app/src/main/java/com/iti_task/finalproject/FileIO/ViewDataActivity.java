package com.iti_task.finalproject.FileIO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.iti_task.finalproject.databinding.ActivityViewDataBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class ViewDataActivity extends AppCompatActivity {
    private static final String TAG = "ViewDataActivityTag";
    ActivityViewDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding.radioGroup2.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == binding.rbInternal2.getId()) {
                binding.linearInternalFolder.setVisibility(View.VISIBLE);
                binding.toggleButton.setVisibility(View.GONE);
            } else if (checkedId == binding.rbExternal2.getId()) {
                binding.linearInternalFolder.setVisibility(View.GONE);
                binding.toggleButton.setVisibility(View.VISIBLE);
            }
        });
        binding.etFolderName.setEnabled(false);
        binding.checkBoxFolder.setOnCheckedChangeListener((buttonView, isChecked) -> {
            binding.etFolderName.setEnabled(isChecked);
        });
        binding.button2.setOnClickListener(v -> {
            loadData();
        });

        binding.btnNav.setOnClickListener(v -> {
            finish();
        });
    }

    private void loadData() {
        if (binding.radioGroup2.getCheckedRadioButtonId() == binding.rbInternal2.getId()) {
            if (binding.checkBoxFolder.isChecked()) {
                if (binding.etFolderName.getText().toString().isBlank())
                    binding.etFolderName.setError("Please enter a valid name!");
                else
                    readFromFolderInternal(binding.etFolderName.getText().toString());
            } else readFromInternal();
        } else if (binding.radioGroup2.getCheckedRadioButtonId() == binding.rbExternal2.getId()) {
            if (binding.toggleButton.isChecked())
                readFromPrivateExternal();
            else
                readFromPublicExternal();
        } else
            Toast.makeText(this, "select where to read from!", Toast.LENGTH_SHORT).show();
    }

    private void readFromPublicExternal() {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        if (!folder.exists()) {
            if (folder.mkdir()) {
                Log.d(TAG, "readFromPublicExternal: " + folder.getAbsolutePath());
            }
        }
        File file = new File(folder, "my_file.txt");
        readFromFile(file);
    }


    private void readFromPrivateExternal() {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "myPrivateFile.txt");
        readFromFile(file);
    }

    private void readFromInternal() {
        readFromFile(null);
    }

    private void readFromFolderInternal(String folderName) {
        String Folder_Path = getFilesDir().getAbsolutePath() + File.separator + folderName;
        File folderDir = new File(Folder_Path);
        if (!folderDir.exists()) {
            if (folderDir.mkdirs()) {
                Log.d(TAG, "readFromFolderInternal: Directory is created for the first time");
            }
        }
        File file = new File(folderDir, "my_internal_file.txt");
        readFromFile(file);
    }

    private void readFromFile(File file) {
        try {
            FileInputStream inputStream;
            if (file == null) {
                inputStream = openFileInput("my_default_file.txt");
            } else {
                inputStream = new FileInputStream(file);
            }
            StringBuilder buffer = new StringBuilder();
            int read = inputStream.read();
            if (read == -1)
                Toast.makeText(this, "empty file", Toast.LENGTH_SHORT).show();
            while (read != -1){
                buffer.append((char) read);
                read = inputStream.read();
            }
            inputStream.close();

            String[] strings = buffer.toString().split("-");
            binding.txtEmail.setText(strings[strings.length-2]);
            binding.txtPass.setText(strings[strings.length-1]);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

}