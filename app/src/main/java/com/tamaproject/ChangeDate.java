package com.tamaproject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.io.IOException;
import java.util.Calendar;
import com.tamaproject.database.DatabaseHelper;


public class ChangeDate extends Activity {

    String TAG = "tama ChangeDate";
    private DatabaseHelper dbHelper;
    long newbday = 0;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker);

        //Get a new instance of Calendar
        Calendar c= Calendar.getInstance();
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH);
        int dayOfMonth = c.get(c.DAY_OF_MONTH);
        //final long formatted = c.getTimeInMillis();
        //Log.i(TAG, "formatted: "+formatted);

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);
        DatePicker dp = (DatePicker) findViewById(R.id.dp);



        //Display the DatePicker initial date
        tv.setText("[mm/dd/yyyy]:\n"+ (month + 1)+"/"+dayOfMonth+"/"+year);

        //init(int year, int monthOfYear, int dayOfMonth, DatePicker.OnDateChangedListener onDateChangedListener) Initialize the state.
        dp.init(
                year,
                month,
                dayOfMonth,
                new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(
                    DatePicker view,
                    int year,
                    int monthOfYear,
                    int dayOfMonth)
            {
                //Display the changed date to app interface
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth, 1, 3, 0);
                newbday = calendar.getTimeInMillis();
                tv.setText("[mm/dd/yyyy]:\n" + (monthOfYear + 1) + "/" + dayOfMonth + "/" + year + "\nTime in Millis: "+newbday);
            }
        });


        SaveNewBDayButton();
   }




    public void SaveNewBDayButton() {

        ///open database first///
        try
        {
            dbHelper = new DatabaseHelper(this);
            Log.i(TAG, "trying dbHelper in button");
        } catch (IOException e)
        {
            Log.i(TAG, "dbHelper failed in button");
            e.printStackTrace();
        }
        try
        {
            DatabaseHelper.createDatabaseIfNotExists(this);
            Log.i(TAG, "createDatabase()");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            dbHelper.openDatabase();
            Log.i(TAG, "openDatabase()");
        } catch (Exception e)
        {
            e.printStackTrace();
        }



        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

            Log.i(TAG, "Save Button pressed!: "+newbday);

                if (dbHelper != null)
                {
                    long savebdayResult = dbHelper.saveBDay(newbday, 1);
                    Log.i(TAG, "savebdayResult: "+savebdayResult);
                    if (savebdayResult < 0)
                    {
                        Log.i(TAG, "Save Birthday failed! " + savebdayResult);
                    }
                }

            }

        });

    }

}