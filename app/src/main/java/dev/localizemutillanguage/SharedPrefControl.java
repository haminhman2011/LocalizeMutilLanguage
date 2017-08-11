package dev.localizemutillanguage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

/**
 * Created by DEV on 8/11/2017.
 */

public class SharedPrefControl {

    // lưu giá trị ngôn ngữ
    public static void savingPreferences(Context context, String key,
                                         String lang) {
        SharedPreferences pre = context.getSharedPreferences("ViDuLang",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        editor.putString(key, lang);
        editor.commit();
    }

    // lấy giá trị ngôn ngữ or country
    public static String getPreferences(Context context, String key) {
        SharedPreferences pre = context.getSharedPreferences("ViDuLang", 0);
        String curLang = pre.getString(key, "");
        return curLang;
    }

    public static void updateLangua(Context context) {
        String lang = getPreferences(context, "lang");
        String country = getPreferences(context, "country");
        if(lang == null || lang.equals("")) lang = "en";
        if(country == null) country = "";
        Locale myLocale = null;
        if (country.equals(""))
            myLocale = new Locale(lang);
        else
            myLocale = new Locale(lang, country);
        if (myLocale == null)
            return;
        // Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }
}
