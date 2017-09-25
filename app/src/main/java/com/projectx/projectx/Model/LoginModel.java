package com.projectx.projectx.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dexter on 25/09/17.
 */

public class LoginModel {
    @SerializedName("user_mobile")
    private String userMobile;
    @SerializedName("success")
    private String sucessResponse;
    @SerializedName("otp")
    private String userOtp;

    public LoginModel(String userMobile){
        this.userMobile = userMobile;
    }

    public String getSucessResponse() {
        return sucessResponse;
    }

    public void setSucessResponse(String sucessResponse) {
        this.sucessResponse = sucessResponse;
    }

    public String getUserOtp() {
        return userOtp;
    }

    public void setUserOtp(String userOtp) {
        this.userOtp = userOtp;
    }
}
