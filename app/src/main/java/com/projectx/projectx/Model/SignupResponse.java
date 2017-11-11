package com.projectx.projectx.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by designsx on 21/10/17.
 */

public class SignupResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
