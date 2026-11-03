package com.example.samihmngr2026_2027.model.myusersTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyUser {
    @PrimaryKey(autoGenerate = true)
    private long uid;
    private String fullName;
    private String email;
    private String password;
    private String phone;

    // Default constructor
    public MyUser() {}

    // Getters and Setters
    public long getUid() { return uid; }
    public void setUid(long uid) { this.uid = uid; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "MyUser{" +
                "uid=" + uid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
