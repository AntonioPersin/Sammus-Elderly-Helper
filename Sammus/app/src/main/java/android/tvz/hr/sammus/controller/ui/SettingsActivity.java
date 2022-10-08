package android.tvz.hr.sammus.controller.ui;

import android.os.Build;
import android.os.Bundle;
import android.tvz.hr.sammus.R;
import android.tvz.hr.sammus.databinding.SettingsActivityBinding;
import android.tvz.hr.sammus.model.DBKomunikacija;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private SettingsActivityBinding binding;
    private List<HashMap<String,EditText>> ids = new ArrayList<>();
    private List<HashMap<String, String>> lista = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= SettingsActivityBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        HashMap<String,EditText> tmp1=new HashMap<>();
        tmp1.put("imeInput",binding.editTextBrzoBiranjeIme1);
        tmp1.put("brojInput",binding.editTextBrzoBiranjeBroj1);
        ids.add(tmp1);

        HashMap<String,EditText> tmp2=new HashMap<>();
        tmp2.put("imeInput",binding.editTextBrzoBiranjeIme2);
        tmp2.put("brojInput",binding.editTextBrzoBiranjeBroj2);
        ids.add(tmp2);

        HashMap<String,EditText> tmp3=new HashMap<>();
        tmp3.put("imeInput",binding.editTextBrzoBiranjeIme3);
        tmp3.put("brojInput",binding.editTextBrzoBiranjeBroj3);
        ids.add(tmp3);

        HashMap<String,EditText> tmp4=new HashMap<>();
        tmp4.put("imeInput",binding.editTextBrzoBiranjeIme4);
        tmp4.put("brojInput",binding.editTextBrzoBiranjeBroj4);
        ids.add(tmp4);

        HashMap<String,EditText> tmp5=new HashMap<>();
        tmp5.put("imeInput",binding.editTextBrzoBiranjeIme5);
        tmp5.put("brojInput",binding.editTextBrzoBiranjeBroj5);
        ids.add(tmp5);

        HashMap<String,EditText> tmp6=new HashMap<>();
        tmp6.put("imeInput",binding.editTextBrzoBiranjeIme6);
        tmp6.put("brojInput",binding.editTextBrzoBiranjeBroj6);
        ids.add(tmp6);

        HashMap<String,EditText> tmp7=new HashMap<>();
        tmp7.put("imeInput",binding.editTextHitnoIme1);
        tmp7.put("brojInput",binding.editTextHitanBroj1);
        ids.add(tmp7);

        HashMap<String,EditText> tmp8=new HashMap<>();
        tmp8.put("imeInput",binding.editTextHitnoIme2);
        tmp8.put("brojInput",binding.editTextHitanBroj2);
        ids.add(tmp8);

        lista= DBKomunikacija.getDBData(lista);

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId){
                    case R.id.radioButtonNormal:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        return;
                    case R.id.radioButtonDark:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        return;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        popuni();
    }

    @Override
    protected void onPause() {
        super.onPause();
        spremiInput();
        DBKomunikacija.setDBData(lista);
    }

    public void onSave(View v){
        spremiInput();
        DBKomunikacija.setDBData(lista);
    }

    private void spremiInput() {
        int counter=0;
        for(HashMap<String,EditText> par:ids){
            lista.get(counter).put("ime",par.get("imeInput").getText().toString());
            lista.get(counter).put("broj",par.get("brojInput").getText().toString());
            counter++;
        }
    }

    public void popuni(){
        int counter=0;
        for(HashMap<String,EditText> par:ids){
            par.get("imeInput").setText(lista.get(counter).get("ime"));
            par.get("brojInput").setText(lista.get(counter).get("broj"));
            counter++;
        }
    }

}