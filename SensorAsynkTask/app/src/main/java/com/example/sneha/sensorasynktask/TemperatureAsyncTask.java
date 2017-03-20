package com.example.sneha.sensorasynktask;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.content.Context;
import java.util.Random;

/**
 * Created by sneha on 3/19/17.
 */

class TemperatureAsyncTask extends AsyncTask<Integer,Integer,Integer> implements DialogInterface.OnCancelListener {
    UIReportBack reportBack;
    Context context;
    ProgressDialog pd = null;

    TemperatureAsyncTask(UIReportBack rb, Context ctx){
        reportBack = rb;
        context = ctx;

    }

    @Override
    protected Integer doInBackground(Integer... params) {
        Random random = new Random();

        for (int i=0; i <params[0];i++)
        {
            int temp = random.nextInt(150);
            int humid = random.nextInt(100);
            int activity = random.nextInt(150);
            publishProgress(temp,humid,activity,i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (isCancelled()) {
                break;
            }
        }
        return 1;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        pd = new ProgressDialog(context);
//        pd.setTitle("title");
//        pd.setMessage("In Progress...");
//        pd.setCancelable(true);
//        pd.setOnCancelListener(this);
//        pd.setIndeterminate(false);
//        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        pd.setMax(5);
//        pd.show();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
//        pd.cancel();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        reportBack.UpdateUI(values[0].floatValue(),values[1].floatValue(),values[2].floatValue(),values[3]);
//        pd.setProgress(values[3]);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        this.cancel(true);
    }
}
