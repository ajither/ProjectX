package com.projectx.projectx.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajith E R on 21/10/17.
 * @brief Application OTP API Request Response Parameter Handler
 */

public class OtpResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("otp")
    public String otp;

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
}
