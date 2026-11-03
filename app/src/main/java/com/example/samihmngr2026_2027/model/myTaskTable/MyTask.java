package com.example.samihmngr2026_2027.model.myTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyTask {
    @PrimaryKey(autoGenerate = true)
    private long taskId;
    private String title;
    private String description;
    private int priority;
    private long userId; // foreign key or reference to MyUser uid

    // Default constructor
    public MyTask() {}

    // Getters and Setters
    public long getTaskId() { return taskId; }
  public void setTaskId(long taskId) { this.taskId = taskId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }

    public long getUserId() { return userId; }
    public void setUserId(long userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "MyTask{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", userId=" + userId +
                '}';
    }
}
