package android.tvz.hr.sammus.model;

import android.content.Context;
import android.tvz.hr.sammus.KontaktiDB;
import android.tvz.hr.sammus.R;
import android.util.Log;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.HashMap;
import java.util.List;

public class DBKomunikacija {
    public static List<HashMap<String, String>> getDBData(List<HashMap<String, String>> rez) {
        List<KontaktiDB> kontaktiDBList= SQLite.select().from(KontaktiDB.class).queryList();

        HashMap<String,String>item;
        for(KontaktiDB kon:kontaktiDBList){
            item= new HashMap<>();
            item.put("ime",kon.getIme());
            item.put("broj",kon.getBroj());
            rez.add(item);
            Log.d("itemi liste",item.get("ime")+"   "+item.get("broj"));
        }
        return rez;
    }

    public static void setDBData(List<HashMap<String, String>> input) {
        for(HashMap<String, String> data:input){
            int primKey=input.indexOf(data)+1;
            KontaktiDB kon=new KontaktiDB();
            kon.setId(primKey);
            kon.setIme(data.get("ime"));
            kon.setBroj(data.get("broj"));
            FlowManager.getModelAdapter(KontaktiDB.class).save(kon);
        }
    }

    public static void initDB(Context context){
        for(int i=0;i<8;i++){
            KontaktiDB ph1=new KontaktiDB();
            ph1.setIme(context.getResources().getString(R.string.placeholderIme));
            ph1.setBroj(context.getResources().getString(R.string.placeholderBroj));
            FlowManager.getModelAdapter(KontaktiDB.class).insert(ph1);
        }
    }
}
