package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thumbfight.finalproject.R;

import java.util.ArrayList;
import java.util.List;

import Oject.CookBook;

public class CookAdapter extends ArrayAdapter<CookBook> {
    private Context CB;
    private ArrayList<CookBook> arr;


    public CookAdapter(Context context, int resource, List<CookBook> objects){
        super(context, resource, objects);
        this.CB = context;
        this.arr = new ArrayList<>(objects);

    }

    public void sortCook(String s){
        s=s.toUpperCase();
        int k=0;
        for (int i=0;i<arr.size();i++) {
            CookBook c =arr.get(i);
            String ten= c.getTenMonAn().toUpperCase();
            if(ten.indexOf(s)>=0){
                arr.set(i,arr.get(k));
                arr.set(k,c);
                k++;
            }
        }
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) CB.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewGroup viewGroup = null;
            convertView = inflater.inflate(R.layout.item_cook, null);

        }
        if (arr.size() > 0) {
            CookBook cookBook = this.arr.get(position);
            TextView tenMonAn = convertView.findViewById(R.id.txvTenMonAn);
            TextView CongThuc = convertView.findViewById(R.id.txvCapDo);
            ImageView imgAnhMonAn = convertView.findViewById(R.id.imgAnhMonAn);

            tenMonAn.setText(cookBook.getTenMonAn());
            CongThuc.setText(cookBook.getCapDo());

            Glide.with(this.CB).load(cookBook.getLinkAnh()).into(imgAnhMonAn);
        }
        return convertView;
    }
}

