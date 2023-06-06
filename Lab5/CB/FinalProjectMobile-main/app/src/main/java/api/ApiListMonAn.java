package api;

import android.os.AsyncTask;

import com.example.thumbfight.finalproject.DSachMainActivity2;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import interfaces.LayListMonAn;

public class ApiListMonAn extends AsyncTask<Void,Void,Void> {
    String data;
    LayListMonAn layListMonAn;
    String idList;

    public ApiListMonAn(LayListMonAn layListMonAn,String idList) {
        this.layListMonAn = layListMonAn;
        this.layListMonAn.batDau();
        this.idList =idList;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://hoa19521519.000webhostapp.com/layListMonAn.php?id="+idList)
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
            this.layListMonAn.biLoi();
        }else {
            this.layListMonAn.ketThuc(data);
        }
    }
}
