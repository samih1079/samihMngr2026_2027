package com.example.samihmngr2026_2027.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.samihmngr2026_2027.model.myusersTable.MyUser;
import com.example.samihmngr2026_2027.repositories.UserRepository;

/**
 * نموذج عرض المستخدمين (UserViewModel) مسئول عن إدارة العمليات المتعلقة بالمستخدمين (تسجيل مستخدم جديد، تسجيل الدخول، والتحقق من الحسابات)
 * والتواصل مع {@link UserRepository} وفقاً لهيكلية MVVM.
 */
public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع {@link UserRepository}.
     *
     * @param application سياق التطبيق الممرر للـ AndroidViewModel.
     */
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
    }

    /**
     * إدراج مستخدم جديد في قاعدة البيانات (التسجيل / Sign Up).
     *
     * @param user كائن المستخدم المراد إضافته.
     */
    public void insert(MyUser user) {
        repository.insert(user);
    }

    /**
     * البحث عن مستخدم بواسطة البريد الإلكتروني للتحقق من وجوده مسبقاً.
     *
     * @param email البريد الإلكتروني المراد البحث عنه.
     * @return كائن {@link MyUser} إن وجد، أو null إذا لم يوجد.
     */
    public MyUser getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    /**
     * التحقق من بيانات تسجيل الدخول (تسجيل الدخول / Sign In).
     *
     * @param email    البريد الإلكتروني للمستخدم.
     * @param password كلمة المرور.
     * @return كائن {@link MyUser} المطابق للبيانات، أو null في حال خطأ البريد أو كلمة المرور.
     */
    public MyUser login(String email, String password) {
        return repository.login(email, password);
    }
}
