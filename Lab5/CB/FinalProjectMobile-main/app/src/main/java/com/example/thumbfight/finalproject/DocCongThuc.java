package com.example.thumbfight.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import Oject.CookBook;
import adapter.CookAdapter;
import api.ApiLayAnh;
import interfaces.LayAnhVe;

public class DocCongThuc extends AppCompatActivity implements LayAnhVe {
    ImageView imgAnh;
    ArrayList<String> arrUrlAnh= new ArrayList<String>();
    int soTrang,soTrangDangDoc;
    TextView txvSoTrang;
    String idListFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_cong_thuc);

    init();
    anhXa();
    setUp();
    setClick();
    new ApiLayAnh(this,idListFood).execute();
    }
    private void init(){
        Bundle b = getIntent().getBundleExtra("data");
        idListFood= b.getString("idListFood");
        /*
        arrUrlAnh = new ArrayList<>();
        arrUrlAnh.add("https://i.pinimg.com/550x/4f/43/01/4f43016f1bc1b7e26ea85e772348ac44.jpg");
        arrUrlAnh.add("https://i.pinimg.com/236x/98/e3/1e/98e31e1fc8b3cf6fed4b7cfb5aafa65a.jpg");
        arrUrlAnh.add("https://i.pinimg.com/236x/a0/90/d4/a090d4f745f9849a1379638270ec34be.jpg");
        arrUrlAnh.add("https://i.pinimg.com/236x/ca/5b/60/ca5b603aeee3c70b0cc91ca675138760.jpg");
        soTrangDangDoc =1;
        soTrang=arrUrlAnh.size();
        */
    }
    private void anhXa(){
        txvSoTrang = findViewById(R.id.txvSotrang);
        imgAnh = findViewById(R.id.imgAnh);
    }
    private void setUp(){

        //docTheoTrang(0);
    }
    private void setClick(){

    }

    public void right(View view) {
        docTheoTrang(1);
    }

    public void left(View view) {
        docTheoTrang(-1);
    }

    private void docTheoTrang(int i) {
        soTrangDangDoc = soTrangDangDoc+i;
        if(soTrangDangDoc == 0){
            soTrangDangDoc=1;
        }
        if(soTrangDangDoc>soTrang){
            soTrangDangDoc  = soTrang;
        }
        txvSoTrang.setText(soTrangDangDoc+"/"+soTrang);
        Glide.with(this).load(arrUrlAnh.get(soTrangDangDoc-1)).into(imgAnh);
    }

    @Override
    public void batDau() {

    }

    @Override
    public void ketThuc(String data) {
        try {
            JSONArray arr = new JSONArray(data);
            for (int i=0;i<arr.length(); i++){
                arrUrlAnh.add(arr.getString(i));
            }
            soTrangDangDoc = 1;
            soTrang=arrUrlAnh.size();
            docTheoTrang(0);
        }catch (JSONException e){

        }
        arrUrlAnh = new ArrayList<>();
        soTrangDangDoc =1;
        soTrang=arrUrlAnh.size();
    }

    @Override
    public void biLoi() {

    }
}