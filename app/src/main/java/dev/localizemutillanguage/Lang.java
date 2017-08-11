package dev.localizemutillanguage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Lang extends Activity implements View.OnClickListener{

    String lang = "";
    public View rdoVN, rdoEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);

        rdoVN = findViewById(R.id.rdoVietnam);
        rdoEN = findViewById(R.id.rdoEnglish);

        rdoVN.setOnClickListener(this);
        rdoEN.setOnClickListener(this);

        Button btn = (Button) findViewById(R.id.btnnext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        String lang = "";
        String country = "";
        switch (v.getId()) {

            case R.id.rdoVietnam:
                Log.i("111","111");
                lang = "vi";
                break;
            case R.id.rdoEnglish:
                Log.i("22","22");
                lang = "en";
//                country = "CN";
                break;
//			case R.id.rdoJav:
//				lang = "zh";
//				country = "TW";
//				break;
        }
        SharedPrefControl.savingPreferences(getApplicationContext(), "lang", lang);
        SharedPrefControl.savingPreferences(getApplicationContext(), "country", country);
        SharedPrefControl.updateLangua(getApplicationContext());

        // nạp lại data layout
        recreate();
    }
}
