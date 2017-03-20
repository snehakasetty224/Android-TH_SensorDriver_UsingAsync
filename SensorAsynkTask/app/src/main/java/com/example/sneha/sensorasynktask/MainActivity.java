package com.example.sneha.sensorasynktask;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements UIReportBack {
    TextView sensornumberfield;
    TextView temperaturefield;
    TextView humidityfield;
    TextView activityfield;
    TextView scrollField;
    TemperatureAsyncTask asynctask;
   // Button generate;
   // Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensornumberfield = (TextView)findViewById(R.id.editText12);
        temperaturefield = (TextView)findViewById(R.id.editText5);
        humidityfield = (TextView)findViewById(R.id.editText8);
        activityfield = (TextView)findViewById(R.id.editText9);
        scrollField = (TextView)findViewById(R.id.textView10);
    }

    public void onclickgeneratbutton(View view){
        asynctask = new TemperatureAsyncTask(this,this);
        asynctask.execute(Integer.parseInt(sensornumberfield.getText().toString()));
    }

    public void onclickCancelbutton(View view){
        asynctask.cancel(true);
    }

    @Override
    public void UpdateUI(Float temp, Float humidity, Float activity, int count) {
        temperaturefield.setText(String.valueOf(temp));
        humidityfield.setText(String.valueOf(humidity));
        activityfield.setText(String.valueOf(activity));
        scrollField.append("----------\n"+"Output :"+(count+1)+"\n"+"Temp: "+temp+"\n" + "Humidity: "+humidity+"\n"+"Activity: "+activity+"\n");
    }


}


