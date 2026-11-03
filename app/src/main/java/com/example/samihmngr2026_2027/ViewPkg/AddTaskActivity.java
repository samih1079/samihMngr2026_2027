package com.example.samihmngr2026_2027.ViewPkg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.samihmngr2026_2027.R;
import com.example.samihmngr2026_2027.model.myTaskTable.MyTask;
import com.example.samihmngr2026_2027.viewmodel.TaskViewModel;

public class AddTaskActivity extends AppCompatActivity {

    private EditText etTitle, etDescription, etPriority;
    private TaskViewModel taskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etPriority = findViewById(R.id.etPriority);
        Button btnSaveTask = findViewById(R.id.btnSaveTask);

        btnSaveTask.setOnClickListener(v -> saveTask());
    }

    private void saveTask() {
        String title = etTitle.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        String priorityStr = etPriority.getText().toString().trim();

        if (title.isEmpty()) {
            etTitle.setError("Title is required");
            etTitle.requestFocus();
            return;
        }

        int priority = 0;
        if (!priorityStr.isEmpty()) {
            try {
                priority = Integer.parseInt(priorityStr);
            } catch (NumberFormatException e) {
                priority = 0;
            }
        }

        // Determine userId automatically (e.g., from intent extra or default user 1)
        long userId = getIntent().getLongExtra("USER_ID", 1L);

        MyTask task = new MyTask();
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setUserId(userId);

        try {
            taskViewModel.insert(task);
            Toast.makeText(this, "Task added successfully", Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Error adding task: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
