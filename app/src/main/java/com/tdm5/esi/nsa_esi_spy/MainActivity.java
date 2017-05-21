package com.tdm5.esi.nsa_esi_spy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;


    private String[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        MissActionSaver saver = new MissActionSaver();


       /* pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        String arrayV=pref.getString("misses","");*/


        ServiceReceiver S = new ServiceReceiver();


        ListView listView = (ListView) findViewById(R.id.list);

        values=new String[]{""};

        if(saver.getValue(getApplicationContext())!=null) {

            values = saver.getValue(getApplicationContext()).split(",");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

    }


}
