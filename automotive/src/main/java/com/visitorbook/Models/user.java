package com.visitorbook.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class user {

    public NewUser getNewUser() {
        return newUser;
    }

    public void setNewUser(NewUser newUser) {
        this.newUser = newUser;
    }

    @SerializedName("newUser")
    @Expose
    private NewUser newUser;

}
