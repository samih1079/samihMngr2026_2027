package com.example.samihmngr2026_2027.model.myTaskTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyTaskQuery {
    @Query("SELECT * FROM MyTask")
    LiveData<List<MyTask>> getAllTasks();
    // Add other query methods as needed
    @Query("SELECT * FROM MyTask WHERE userId = :userId")
    LiveData<List<MyTask>> getTasksByUserId(long userId);
    @Insert
    void insert(MyTask... tasks);
    @Query("SELECT * FROM MyTask WHERE taskId = :taskId")
    LiveData<MyTask> getTaskById(long taskId);

    @Query("SELECT * FROM MyTask WHERE title LIKE :title")
    LiveData<List<MyTask>> getTasksByTitle(String title);

    @Query("SELECT * FROM MyTask WHERE description LIKE :description")
    LiveData<List<MyTask>> getTasksByDescription(String description);

    @Query("SELECT * FROM MyTask WHERE priority = :priority")
    LiveData<List<MyTask>> getTasksByPriority(int priority);

    @Query("SELECT * FROM MyTask WHERE userId = :userId AND title LIKE :title")
    LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title);
    @Delete
    void delete(MyTask... tasks);

    @Query("DELETE FROM MyTask WHERE taskId = :taskId")
    void deleteTaskById(long taskId);

    @Query("Update MyTask SET title = :title, description = :description, priority = :priority WHERE taskId = :taskId")
    void updateTask(long taskId, String title, String description, int priority);

    @Update
    void update(MyTask... tasks);
}
