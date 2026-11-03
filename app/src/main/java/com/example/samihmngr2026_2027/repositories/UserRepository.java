package com.example.samihmngr2026_2027.repositories;

import android.app.Application;

import com.example.samihmngr2026_2027.model.AppDataBase;
import com.example.samihmngr2026_2027.model.myusersTable.MyUser;
import com.example.samihmngr2026_2027.model.myusersTable.MyUserQuery;

import java.util.List;

/**
 * مستودع المستخدمين (UserRepository) مسئول عن توفير طبقة تجريد للتعامل مع بيانات المستخدمين
 * عبر {@link MyUserQuery} وقاعدة بيانات Room.
 */
public class UserRepository {
    private final MyUserQuery userQuery;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع DAO الخاص بالمستخدمين.
     *
     * @param application سياق التطبيق.
     */
    public UserRepository(Application application) {
        AppDataBase db = AppDataBase.getDb(application);
        userQuery = db.myUserQuery();
    }

    /**
     * جلب قائمة بجميع المستخدمين المسجلين.
     *
     * @return قائمة المستخدمين.
     */
    public List<MyUser> getAllUsers() {
        return userQuery.getAllUsers();
    }

    /**
     * إدراج مستخدم جديد في قاعدة البيانات.
     *
     * @param user المستخدم المراد إضافته.
     */
    public void insert(MyUser user) {
        userQuery.insert(user);
    }

    /**
     * البحث عن مستخدم بواسطة البريد الإلكتروني.
     *
     * @param email البريد الإلكتروني للبحث.
     * @return المستخدم المطابق أو null.
     */
    public MyUser getUserByEmail(String email) {
        return userQuery.getUserByEmail(email);
    }

    /**
     * التحقق من بيانات تسجيل الدخول للمستخدم.
     *
     * @param email    البريد الإلكتروني.
     * @param password كلمة المرور.
     * @return المستخدم إن وجد وصحت البيانات، أو null.
     */
    public MyUser login(String email, String password) {
        return userQuery.login(email, password);
    }
}
