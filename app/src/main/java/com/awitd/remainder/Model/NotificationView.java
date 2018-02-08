package com.awitd.remainder.Model;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.awitd.remainder.R;


/**
 * Created by ACER on 19/04/2016.
 */
public class NotificationView extends AppCompatActivity {
    String title;
    String text;
    TextView txttitle,txttext;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(0);

        Intent i = getIntent();

        title = i.getStringExtra("title");
        text = i.getStringExtra("text");

        txttitle = (TextView)findViewById(R.id.title);
        txttext = (TextView)findViewById(R.id.text);

        //Set the data into the textViews...
        txttitle.setText(title);
        txttext.setText(text);
    }
}
