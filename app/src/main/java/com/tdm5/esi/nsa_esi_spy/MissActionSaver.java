package com.tdm5.esi.nsa_esi_spy;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Douaa on 14/05/2017.
 */

public class MissActionSaver {

    private static String PREFS_NAME="Mawakite_salate";

    private static String PREFS_KEY="mawakit";

    public MissActionSaver() {
    }

    public static void save(Context context, String object) {

        SharedPreferences settings;

        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1

        editor = settings.edit(); //2

        String text= getValue(context);

        text=text+","+object;

        editor.putString(PREFS_KEY, text); //3

        editor.commit(); //4
    }

    public void clearSharedPreference(Context context) {

        SharedPreferences settings;

        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        editor = settings.edit();

        editor.clear();

        editor.commit();
    }

    public static String getValue(Context context) {

        SharedPreferences settings;

        String text = "";

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1

        text = settings.getString(PREFS_KEY, null); //2

        return text;
    }
}
