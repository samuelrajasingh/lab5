package com.urk17cs290.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import static android.preference.PreferenceManager.*;
import static com.urk17cs290.sharedprefs.PreferencesUtility.LOGGED_IN_PREF;

public class SaveSharedPreference {

    static SharedPreferences getPreferences(Context context) {
        return getDefaultSharedPreferences(context);
    }

    public static void setLoggedIn(Context context, boolean loggedIn,String user) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.apply();
    }

    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false);
    }
}