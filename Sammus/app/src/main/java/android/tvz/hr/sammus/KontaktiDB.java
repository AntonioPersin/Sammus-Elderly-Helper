package android.tvz.hr.sammus;

import android.tvz.hr.sammus.model.BazaPodataka;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

@Table(database = BazaPodataka.class)
public class KontaktiDB {
    @Column
    @PrimaryKey(autoincrement=true)
    int id;

    @Column
    String ime;

    @Column
    String broj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}
