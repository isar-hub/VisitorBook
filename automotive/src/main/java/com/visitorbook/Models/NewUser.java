package com.visitorbook.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewUser {



    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("name")
    @Expose
    private String name;

    @Expose
    @SerializedName("email")
    private String email;

    public NewUser(int userId, String name, String email) {

    }

    // Constructors, getters, and setters
    // ...

    // You can create constructors, getters, and setters for the fields.
    // If you're using a tool like Android Studio, it can generate these for you.

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
