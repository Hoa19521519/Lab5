package com.example.thumbfight.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Oject.CookBook;
import adapter.CookAdapter;
import api.ApiLayCongThucNauAn;
import interfaces.LayCongThucNauAn;

public class MainActivity extends AppCompatActivity implements LayCongThucNauAn {
    GridView gdvDSMonAn;
    CookAdapter adapter;
    ArrayList<CookBook> cookBookArrayList;
    EditText edtTimKiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiLayCongThucNauAn(this).execute();
    }
    private void init(){
        cookBookArrayList = new ArrayList<>();


        adapter= new CookAdapter(this,0,cookBookArrayList);
    }
    private void anhXa(){
        gdvDSMonAn = findViewById(R.id.gdvDSMonAn);
        edtTimKiem = findViewById(R.id.edtTimKiem);
    }
    private void setUp(){
        gdvDSMonAn.setAdapter(adapter);
    }
    private void setClick(){
        edtTimKiem. addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s =edtTimKiem.getText().toString();
                adapter.sortCook(s);
            }
        });
        gdvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CookBook cookBook = cookBookArrayList.get(i);
                Bundle b = new Bundle();
                b.putSerializable("cook",cookBook);
                Intent intent = new Intent(MainActivity.this,DSachMainActivity2.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
    }

    @Override
    public void batDau() {

        Toast.makeText(this,"Dang Lay Ve",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            cookBookArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for (int i=0;i<arr.length();i++){
                JSONObject o = arr.getJSONObject(i);
                cookBookArrayList.add(new CookBook(o));

            }
            adapter= new CookAdapter(this,0,cookBookArrayList);
            gdvDSMonAn.setAdapter(adapter);
        }catch (JSONException e){

        }
    }

    @Override
    public void biLoi() {

        Toast.makeText(this,"Loi ket noi",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public void update(View view) {
        new ApiLayCongThucNauAn(this).execute();
    }
}