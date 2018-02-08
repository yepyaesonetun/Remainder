package com.awitd.remainder.Model;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.awitd.remainder.R;

/**
 * Created by ACER on 03/05/2016.
 */
public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
    @Override
    public  void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
    }
}
