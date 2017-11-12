package com.projectx.projectx.Config;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Ajith E R on 18/9/17.
 * @brief All Application Preference Saved Here
 */

public class ProjectXPref {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "ProjectX";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_USER_LOGIN = "IsLogin";
    private static final String IS_LIKE_DISLIKE_SET = "IsLikeDisLikeSet";

    private static final String USER_MOBILE = "userMobile";
    private static final String USER_MOBILE_CONFIRM_OTP = "userOtp";
    private static final String USER_SEX = "userSex";
    private static final String USER_NAME = "userName";
    private static final String USER_DOB = "userDob";
    private static final String USER_LOCATION = "userLocation";
    private static final String USER_ADDRESS = "userAddress";

    private static final String USER_INTERESTED_SEX = "sexInterested";
    private static final String USER_INTERESTED_SEX_MAX = "sexMax";
    private static final String USER_INTERESTED_SEX_MIN = "sexMin";

    public static final String KEY_USER_SEX = "keyUserSex";
    public static final String KEY_USER_NAME = "keyUserName";
    public static final String KEY_USER_DOB = "keyUserDOB";
    public static final String KEY_USER_LOCATION = "keyUserLocation";
    public static final String KEY_USER_MOBILE = "keyUserMobile";
    public static final String KEY_USER_ADDRESS = "keyUserAddress";

    public static final String KEY_USER_INTERESTED_SEX = "keySexInterested";
    public static final String KEY_USER_INTERESTED_SEX_MAX = "keySexInterestedMax";
    public static final String KEY_USER_INTERESTED_SEX_MIN = "keySexInterestedMin";

    private static final String USER_LOGIN_OTP = "userLoginOtp";

    // Constructor
    public ProjectXPref(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * To Check First Time Launch or Not
     * */
    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    /**
     * Get stored user signup data
     * */
    public void setUserMobileConfirmOtp(String mobileConfirmOtp) {
        editor.putString(USER_MOBILE_CONFIRM_OTP, mobileConfirmOtp);
        editor.commit();
    }

    public String getUserMobileConfirmOtp (){return pref.getString(USER_MOBILE_CONFIRM_OTP,"");}

    /**
     * To Save User Signup Info
     * */
    public void setUserSignupInfo(String sex, String dob, String location, String address, String name){
        editor.putString(USER_NAME,name);
        editor.putString(USER_SEX, sex);
        editor.putString(USER_DOB, dob);
        editor.putString(USER_LOCATION, location);
        editor.putString(USER_ADDRESS, address);
        editor.commit();
    }
    public void setUserSignupSexInfo(String interested_sex, String interested_sex_max, String interested_sex_min){
        editor.putString(USER_INTERESTED_SEX, interested_sex);
        editor.putString(USER_INTERESTED_SEX_MAX, interested_sex_max);
        editor.putString(USER_INTERESTED_SEX_MIN, interested_sex_min);
        editor.commit();
    }

    /**
     * Get stored user signup data
     * */
    public HashMap<String, String> getSignupUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_USER_NAME,pref.getString(USER_NAME,null));
        user.put(KEY_USER_SEX, pref.getString(USER_SEX, null));
        user.put(KEY_USER_DOB, pref.getString(USER_DOB, null));
        user.put(KEY_USER_LOCATION, pref.getString(USER_LOCATION, null));
        user.put(KEY_USER_MOBILE, pref.getString(USER_MOBILE, null));
        user.put(KEY_USER_ADDRESS, pref.getString(USER_ADDRESS, null));

        user.put(KEY_USER_INTERESTED_SEX, pref.getString(USER_INTERESTED_SEX, null));
        user.put(KEY_USER_INTERESTED_SEX_MAX, pref.getString(USER_INTERESTED_SEX_MAX, null));
        user.put(KEY_USER_INTERESTED_SEX_MIN, pref.getString(USER_INTERESTED_SEX_MIN, null));
        return user;
    }

    /**
     * To store User Mobile Number
     * */
    public void setUserMobileVerified(String mobileNumber) {
        editor.putString(USER_MOBILE, mobileNumber);
        editor.commit();
    }

    /**
     * To store User login Otp
     * */
    public void setUserLoginOtp(String loginOtp) {
        editor.putString(USER_LOGIN_OTP, loginOtp);
        editor.commit();
    }

    public String getUserLoginOtp (){return pref.getString(USER_LOGIN_OTP,"");}

    /**
     * To User login check
     * */
    public void setLogin(boolean isLogin) {
        editor.putBoolean(IS_USER_LOGIN, isLogin);
        editor.commit();
    }

    public boolean isLogin() {
        return pref.getBoolean(IS_USER_LOGIN, true);
    }

    public void setLogout(boolean isLogin) {
        editor.putBoolean(IS_USER_LOGIN, isLogin);
        editor.commit();
    }

    /**
     * To User Like Dislike Set
     * */
    public void setLikeDislike(boolean isLogin) {
        editor.putBoolean(IS_LIKE_DISLIKE_SET, isLogin);
        editor.commit();
    }

    public boolean isLikeDislike() {
        return pref.getBoolean(IS_LIKE_DISLIKE_SET, true);
    }

}
