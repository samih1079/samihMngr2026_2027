package com.example.samihmngr2026_2027.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.samihmngr2026_2027.model.AppDataBase;
import com.example.samihmngr2026_2027.model.myTaskTable.MyTask;
import com.example.samihmngr2026_2027.model.myTaskTable.MyTaskQuery;

import java.util.List;

/**
 * مستودع المهام (TaskRepository) يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المهام (MyTask).
 * يقوم بفصل قاعدة بيانات Room و {@link MyTaskQuery} عن بقية أجزاء التطبيق (ViewModels).
 */
public class TaskRepository {
    private final MyTaskQuery taskQuery;
    private final LiveData<List<MyTask>> allTasks;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام.
     *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public TaskRepository(Application application) {
        AppDataBase db = AppDataBase.getDb(application);
        taskQuery = db.myTaskQuery();
        allTasks = taskQuery.getAllTasks();
    }

    /**
     * جلب جميع المهام الموجودة في قاعدة البيانات كـ LiveData.
     *
     * @return قائمة بجميع المهام المحدثة تلقائياً.
     */
    public LiveData<List<MyTask>> getAllTasks() {
        return allTasks;
    }

    /**
     * جلب المهام المرتبطة بمعرف مستخدم معين (User ID).
     *
     * @param userId معرف المستخدم المراد جلب مهامه.
     * @return قائمة المهام الخاصة بالمستخدم المحدد.
     */
    public LiveData<List<MyTask>> getTasksByUserId(long userId) {
        return taskQuery.getTasksByUserId(userId);
    }

    /**
     * جلب مهمة معينة بناءً على معرفها الفريد (Task ID).
     *
     * @param taskId معرف المهمة الفريد.
     * @return كائن المهمة المطلوب.
     */
    public LiveData<MyTask> getTaskById(long taskId) {
        return taskQuery.getTaskById(taskId);
    }

    /**
     * البحث عن المهام التي تتطابق عناوينها مع النص المدخل.
     *
     * @param title النص أو الكلمة المراد البحث عنها في العنوان.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByTitle(String title) {
        return taskQuery.getTasksByTitle(title);
    }

    /**
     * البحث عن المهام التي تتطابق أوصافها مع النص المدخل.
     *
     * @param description النص أو الكلمة المراد البحث عنها في الوصف.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByDescription(String description) {
        return taskQuery.getTasksByDescription(description);
    }

    /**
     * جلب المهام المفلترة حسب مستوى الأولوية.
     *
     * @param priority مستوى الأولوية المطلوب.
     * @return قائمة المهام ذات الأولوية المحددة.
     */
    public LiveData<List<MyTask>> getTasksByPriority(int priority) {
        return taskQuery.getTasksByPriority(priority);
    }

    /**
     * جلب المهام الخاصة بمستخدم معين والتي تتطابق مع عنوان معين.
     *
     * @param userId معرف المستخدم.
     * @param title  عنوان المهمة للبحث.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title) {
        return taskQuery.getTasksByUserIdAndTitle(userId, title);
    }

    /**
     * إدراج مهمة أو عدة مهمات جديدة في قاعدة البيانات.
     *
     * @param tasks المهام المراد إضافتها.
     */
    public void insert(MyTask... tasks) {
        taskQuery.insert(tasks);
    }

    /**
     * تحديث مهمة أو عدة مهمات في قاعدة البيانات.
     *
     * @param tasks المهام المراد تحديثها.
     */
    public void update(MyTask... tasks) {
        taskQuery.update(tasks);
    }

    /**
     * تحديث بيانات مهمة محددة (العنوان، الوصف، والأولوية) باستخدام معرف المهمة.
     *
     * @param taskId      معرف المهمة المراد تعديلها.
     * @param title       العنوان الجديد.
     * @param description الوصف الجديد.
     * @param priority    الأولوية الجديدة.
     */
    public void updateTask(long taskId, String title, String description, int priority) {
        taskQuery.updateTask(taskId, title, description, priority);
    }

    /**
     * حذف مهمة أو عدة مهمات من قاعدة البيانات.
     *
     * @param tasks المهام المراد حذفها.
     */
    public void delete(MyTask... tasks) {
        taskQuery.delete(tasks);
    }

    /**
     * حذف مهمة محددة باستخدام معرفها الفريد (Task ID).
     *
     * @param taskId معرف المهمة المراد حذفها.
     */
    public void deleteTaskById(long taskId) {
        taskQuery.deleteTaskById(taskId);
    }
}
