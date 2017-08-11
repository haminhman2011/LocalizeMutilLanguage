package dev.localizemutillanguage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.Locale;

public class MainActivity extends Activity implements View.OnClickListener{
    public Button btnChangeLang;

//    @Override
//    protected void onResume() {
//        // TODO Auto-generated method stub
//        super.onResume();
//
//
//
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPrefControl.updateLangua(getApplicationContext());

    }





    @Override
    public void onClick(View v) {

        // nap lai layout
        recreate();
    }
}
