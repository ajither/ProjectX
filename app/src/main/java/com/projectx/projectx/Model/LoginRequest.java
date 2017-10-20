package com.projectx.projectx.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dexter on 25/09/17.
 */

public class LoginRequest {

    private String user_mobile;

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }
}
