package api;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import interfaces.LayCongThucNauAn;

public class ApiLayCongThucNauAn extends AsyncTask<Void,Void,Void> {
    String data;
    LayCongThucNauAn layCongThucNauAn;

    public ApiLayCongThucNauAn(LayCongThucNauAn layCongThucNauAn) {
        this.layCongThucNauAn = layCongThucNauAn;
        this.layCongThucNauAn.batDau();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                //.url("https://api.myjson.online/v1/records/dd2c973c-d60a-4a09-bfc5-c9e36cbc4c02")
                //.url("https://www.myjsons.com/v/16e61159")
                .url("https://hoa19521519.000webhostapp.com/")
                .build();
        data =null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();
        }catch (IOException e){
            data=null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (data == null){
            this.layCongThucNauAn.biLoi();
        }else {
            this.layCongThucNauAn.ketThuc(data);
        }
    }
}
