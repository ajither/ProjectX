package com.projectx.projectx.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajith E R on 21/10/17.
 * @brief Application Login API Request Response Parameter Handler
 */

public class LoginResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("otp")
    private String otp;
    @SerializedName("message")
    private String message;


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
