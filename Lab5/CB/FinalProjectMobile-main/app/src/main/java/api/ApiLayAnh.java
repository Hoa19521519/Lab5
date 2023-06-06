package api;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import interfaces.LayAnhVe;
import interfaces.LayCongThucNauAn;

public class ApiLayAnh extends AsyncTask<Void,Void,Void> {
    String data;
    String idListFood;
    LayAnhVe layAnhVe;

    public ApiLayAnh(LayAnhVe layAnhVe,String idListFood) {
        this.layAnhVe = layAnhVe;
        this.idListFood = idListFood;
        this.layAnhVe.batDau();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://hoa19521519.000webhostapp.com/layAnh.php?idListFood="+idListFood)
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
            this.layAnhVe.biLoi();
        }else {
            this.layAnhVe.ketThuc(data);
        }
    }
}
