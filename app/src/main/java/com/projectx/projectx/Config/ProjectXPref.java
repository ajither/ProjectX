package com.projectx.projectx.Config;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ajith on 18/9/17.
 */

public class ProjectXPref {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "ProjectX";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public ProjectXPref(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
