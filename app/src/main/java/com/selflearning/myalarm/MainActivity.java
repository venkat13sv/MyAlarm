package com.selflearning.myalarm;


import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.min;

public class MainActivity extends AppCompatActivity {
    int hr = 0;
    int min = 0;
    int sec = 0;
    int result = 1;

    Alarm al;
    EditText ethr,ihr;
    EditText etmin,imin;
    EditText etsec,isec;
    Calendar cal1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ethr = (EditText) findViewById(R.id.ethr);
        etmin = (EditText) findViewById(R.id.etmin);
        etsec = (EditText) findViewById(R.id.etsec);
        ihr = (EditText) findViewById(R.id.ithr);
        imin = (EditText) findViewById(R.id.itmin);
        isec = (EditText) findViewById(R.id.itsec);
        cal1 = Calendar.getInstance();
        al=new Alarm();


    }
    public void onClickSetAlarm(View v) {
        String shr = ethr.getText().toString();
        String smin = etmin.getText().toString();
        String ssec = etsec.getText().toString();
        String intervalHr= ihr.getText().toString();
        String intervalMin= imin.getText().toString();
        String intervalsec= isec.getText().toString();
        cal1=Calendar.getInstance();
        if(!shr.equals(""))
        cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(shr));
        if(!smin.equals(""))
        cal1.set(Calendar.MINUTE,  Integer.parseInt(smin));
        if(!ssec.equals(""))
        cal1.set(Calendar.SECOND,  Integer.parseInt(ssec));
        Log.v("Value of Cal1","Ok " + cal1.getTimeInMillis());
        if(intervalHr.equals(""))
            hr = 0;
        else {
            hr = Integer.parseInt(intervalHr);
            hr=hr*60*60*1000;
        }

        if(intervalMin.equals(""))
            min = 0;
        else {
            min = Integer.parseInt(intervalMin);
            min = min*60*1000;
        }

        if(intervalsec.equals(""))
            sec = 0;
        else {
            sec = Integer.parseInt(intervalsec);
            sec = sec * 1000;
        }
        result = hr+min+sec;
        if(result< 1000 * 60 * 1) {
            al.setAlarm(this, 1000 * 60 * 1,cal1);
            Toast.makeText(this, "Alarm is set for 1 minute", Toast.LENGTH_LONG).show();
        }
        else {
            al.setAlarm(this, result,cal1);
            Toast.makeText(this, "Alarm is set for "+ethr.getText().toString()+" Hrs "+etmin.getText().toString()+" Min "+etsec.getText().toString()+" sec", Toast.LENGTH_LONG).show();
        }
    }
    public void onClickCancelAlarm(View v) {
        al.cancelAlarm(this);
    }
}
