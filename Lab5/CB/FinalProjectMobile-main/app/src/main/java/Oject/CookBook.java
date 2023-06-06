package Oject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class CookBook implements Serializable {
    private String tenMonAn,CapDo,LinkAnh,id;
    /*
    {
    "tenMonAn":"",
    "CapDo":"",
    "LinkAnh":"",
    }
    */
    public CookBook () {

    }

    public CookBook(JSONObject o) throws JSONException {
        id = o.getString("id");
        tenMonAn = o.getString("tenMonAn");
        CapDo = o.getString("CapDo");
        LinkAnh = o.getString("linkAnh");
    }
        public CookBook(String tenMonAn, String CapDo, String linkAnh) {
            this.tenMonAn = tenMonAn;
            this.CapDo= CapDo;
            LinkAnh = linkAnh;
        }

        public String getTenMonAn() {
            return tenMonAn;
        }

        public void setTenMonAn(String tenMonAn) {
            this.tenMonAn = tenMonAn;
        }

        public String getCapDo() {
            return CapDo;
        }

        public void setCapDo(String CapDo) {
            this.CapDo = CapDo;
        }

        public String getLinkAnh() {
            return LinkAnh;
        }

        public void setLinkAnh(String linkAnh) {
            LinkAnh = linkAnh;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
}


