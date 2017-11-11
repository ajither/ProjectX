package com.projectx.projectx.Model;

/**
 * Created by Ajith E R on 18/9/17.
 * @brief Application Signup API Request Parameter Handler
 */

public class SignupRequest {
    private String user_name;
    private String user_mobile;
    private String user_sex;
    private String user_dob;
    private String user_location;
    private String user_address;
    private String user_sex_interested;
    private String user_sex_min;
    private String user_sex_max;

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_dob() {
        return user_dob;
    }

    public void setUser_dob(String user_dob) {
        this.user_dob = user_dob;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_sex_interested() {
        return user_sex_interested;
    }

    public void setUser_sex_interested(String user_sex_interested) {
        this.user_sex_interested = user_sex_interested;
    }

    public String getUser_sex_min() {
        return user_sex_min;
    }

    public void setUser_sex_min(String user_sex_min) {
        this.user_sex_min = user_sex_min;
    }

    public String getUser_sex_max() {
        return user_sex_max;
    }

    public void setUser_sex_max(String user_sex_max) {
        this.user_sex_max = user_sex_max;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
