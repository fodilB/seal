package com.tdm5.esi.nsa_esi_spy;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Douaa on 12/05/2017.
 */
public class MyPhoneStateListener extends PhoneStateListener {

    private Context context;

    public MyPhoneStateListener(Context context) {
        super();
        this.context=context;
    }

    public void onCallStateChanged(int state, String incomingNumber){

        Date dNow = new Date( );

        SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a ");

        MissActionSaver saver = new MissActionSaver();


        switch(state){
            case TelephonyManager.CALL_STATE_IDLE:
                Log.i("INFO", "IDLE : "+incomingNumber+" "+ ft.format(dNow));
                saver.save(context,"miss call from "+incomingNumber+" "+ ft.format(dNow));

                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.i("INFO", "OFFHOOK : "+incomingNumber+" "+ ft.format(dNow));

                break;
            case TelephonyManager.CALL_STATE_RINGING:
                Log.i("INFO", "RINGING : "+incomingNumber+" "+ ft.format(dNow));


                break;
        }
    }


}
