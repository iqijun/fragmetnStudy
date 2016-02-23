package com.xinggs.ascyTaskStudy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.xinggs.fragmentstudy.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/2/23.
 */
public class DownloadTask extends AsyncTask<URL,Integer,String> {

    ProgressDialog progressDialog ;
    int hasRead = 0;
    Context context;
    public DownloadTask(Context context){
        this.context = context;
    }
    @Override
    protected String doInBackground(URL... params) {
        StringBuilder sb = new StringBuilder();

        try {
            URLConnection connection = params[0].openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                sb.append(line);
                hasRead++;
                publishProgress(hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("正在下载");
        progressDialog.setMessage("正在执行下载任务");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Activity activity = (Activity) this.context;
        final TextView textView = (TextView) activity.findViewById(R.id.downLoadText);
        textView.setText(s);
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }

}
