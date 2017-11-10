package com.projectx.projectx.Model;

/**
 * Created by designsx on 21/10/17.
 */

public class OtpRequest {
    private String type;
    private String mobile_number;

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
