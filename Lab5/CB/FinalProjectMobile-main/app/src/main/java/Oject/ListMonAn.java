package Oject;

import org.json.JSONException;
import org.json.JSONObject;

public class ListMonAn {
    private String tenFood, ngayDang,id;

    public ListMonAn(){

    }
    public String getTenFood(){

        return tenFood;
    }
    public void setTenFood(String tenFood){

        this.tenFood = tenFood;
    }
    public String getNgayDang(){

        return ngayDang;
    }
    public void setNgayDang(String ngayDang){

        this.ngayDang = ngayDang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ListMonAn(String tenFood, String ngayDang) {
        this.tenFood = tenFood;
        this.ngayDang = ngayDang;
    }
    public ListMonAn(JSONObject o) throws JSONException {
        tenFood = o.getString("tenMonAnn");
        ngayDang = o.getString("ngaynhap");
        id = o.getString("id");
    }
}
