package com.example.hcmute.AsyncTask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcmute.R;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    Activity contextParent;
    public MyAsyncTask(Activity contextParent){
        this.contextParent = contextParent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(contextParent, "Bat dau", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 100; i++){
            SystemClock.sleep(100);
            publishProgress(i);
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        //Hàm thực hiện update giao diện khi có dữ liệu từ hàm doInBackground gửi xuống
        super.onProgressUpdate(values);
        //Thông qua contextCha để lấy được control trong MainActivity
        ProgressBar progressBar = (ProgressBar) contextParent.findViewById(R.id.prbDemo);
        //vì publishProgress chỉ truyền 1 đối số
        //nên mảng values chỉ có 1 phần tử
        int number = values[0];
        //tăng giá trị của Progressbar lên
        progressBar.setProgress(number);
        //đồng thời hiển thị giá trị là % lên TextView
        TextView textView = (TextView) contextParent.findViewById(R.id.txtStatus);
        textView.setText(number + "%");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Hàm này được thực hiện khi tiến trình kết thúc
        //Ở đây mình thông báo là đã "Finished" để người dùng biết
        Toast.makeText(contextParent, "Đã hoàn thành, Finished", Toast.LENGTH_SHORT).show();
    }


}
