package com.example.samihmngr2026_2027.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.samihmngr2026_2027.R;
import com.example.samihmngr2026_2027.model.myusersTable.MyUser;
import com.example.samihmngr2026_2027.viewmodel.UserViewModel;

/**
 * نشاط تسجيل الدخول (SignInActivity).
 * مسؤول عن استقبال بيانات اعتماد المستخدم (البريد الإلكتروني وكلمة المرور)،
 * والتحقق منها عبر {@link UserViewModel}، وتوجيه المستخدم إلى الشاشة الرئيسية عند نجاح العملية.
 */
public class SignInActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private UserViewModel userViewModel;

    /**
     * يُستدعى عند إنشاء النشاط.
     * يقوم بربط العناصر الرسومية، تهيئة {@link UserViewModel}، وتفعيل زر تسجيل الدخول.
     *
     * @param savedInstanceState الحالة المحفوظة للنشاط إن وجدت.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        Button btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(v -> signInUser());
    }

    /**
     * يقوم بالتحقق من صحة الحقول المدخلة، استدعاء عملية تسجيل الدخول،
     * وإدارة النتيجة (نجاح أو فشل) عبر Toast والانتقال لـ MainActivity عند النجاح.
     */
    private void signInUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        MyUser user = userViewModel.login(email, password);
        if (user != null) {
            Toast.makeText(this, "Welcome, " + user.getFullName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            intent.putExtra("USER_ID", user.getUid());
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
