package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thumbfight.finalproject.R;

import java.util.ArrayList;
import java.util.List;

import Oject.ListMonAn;

public class ListMonAnAdapter extends ArrayAdapter<ListMonAn> {
    private Context CB;
    private ArrayList<ListMonAn> arr;
    public ListMonAnAdapter(@NonNull Context context, int resource, @NonNull List<ListMonAn> objects) {
        super(context, resource, objects);
        this.CB = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       if (convertView ==null){
           LayoutInflater inflater = (LayoutInflater) CB.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView=inflater.inflate(R.layout.item_list_food, null);
       }
       if (arr.size()>0){
           TextView txvFood,txvNgayUp;
           txvFood = convertView.findViewById(R.id.txvFood);
           txvNgayUp = convertView.findViewById(R.id.txvNgayUp);

           ListMonAn listMonAn = arr.get(position);
           txvFood.setText(listMonAn.getTenFood());
           txvNgayUp.setText(listMonAn.getNgayDang());
       }
       return convertView;
    }
}
