package com.example.thumbfight.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import Oject.CookBook;
import Oject.ListMonAn;
import adapter.ListMonAnAdapter;
import api.ApiListMonAn;
import interfaces.LayListMonAn;

public class DSachMainActivity2 extends AppCompatActivity implements LayListMonAn {
    TextView txvTenMonAn;
    ImageView imgAnhMonAn;
    CookBook cookBook;
    ListView lsvDsMonAn;
    ArrayList<ListMonAn> arrLiss;
    ListMonAnAdapter listMonAnAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsach_main2);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiListMonAn(this,cookBook.getId()).execute();
    }
    private void init(){
        Bundle b = getIntent().getBundleExtra("data");
        cookBook=(CookBook) b.getSerializable("cook");
        //taọ dư liệu ảo
        arrLiss= new ArrayList<>();
        /*for(int i=0;i<20;i++){
            arrLiss.add(new ListMonAncookBook
        listMonAnAdapter= new ListMonAnAdapter(this,0,arrLiss);
    */
    }

    private void anhXa(){
        imgAnhMonAn = findViewById(R.id.imgAnhMonAn);
        txvTenMonAn = findViewById(R.id.txvTenMonAn);
        lsvDsMonAn = findViewById(R.id.lsvDsMonAn);
    }
    private void setUp(){
        txvTenMonAn.setText(cookBook.getTenMonAn());
        Glide.with(this).load(cookBook.getLinkAnh()).into(imgAnhMonAn);

       // lsvDsMonAn.setAdapter(listMonAnAdapter);
    }
    private void setClick(){
        lsvDsMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();
                b.putString("idListFood",arrLiss.get(i).getId());
                Intent intent = new Intent(DSachMainActivity2.this,DocCongThuc.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
    }

    @Override
    public void batDau() {
        Toast.makeText(this,"download",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            JSONArray array = new JSONArray(data);
            for(int i =0;i<array.length();i++){
                ListMonAn listMonAn = new ListMonAn(array.getJSONObject(i));
                arrLiss.add(listMonAn);
            }
            listMonAnAdapter= new ListMonAnAdapter(this,0,arrLiss);
            lsvDsMonAn.setAdapter(listMonAnAdapter);
        } catch (JSONException e) {
            throw new RuntimeException(e);
            }
    }

    @Override
    public void biLoi() {

    }
}