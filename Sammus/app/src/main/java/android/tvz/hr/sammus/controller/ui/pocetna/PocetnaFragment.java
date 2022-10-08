package android.tvz.hr.sammus.controller.ui.pocetna;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.tvz.hr.sammus.R;
import android.tvz.hr.sammus.model.DBKomunikacija;
import android.tvz.hr.sammus.databinding.FragmentHomeBinding;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PocetnaFragment extends Fragment implements View.OnClickListener {

    private PocetnaViewModel pocetnaViewModel;
    private FragmentHomeBinding binding;
    private List<HashMap<String, String>> lista = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(inflater, container, false);
        DBKomunikacija.getDBData(lista);
        binding.hitanPoziv1.setOnClickListener(this);
        binding.hitanPoziv2.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        DBKomunikacija.getDBData(lista);
        String text1 = getResources().getString(R.string.buttonZovi) + " ";
        String text2 = getResources().getString(R.string.buttonZovi) + " ";
        if(lista.get(6).get("ime")!=getResources().getString(R.string.placeholderIme)) text1=text1 + lista.get(6).get("ime");
        if(lista.get(7).get("ime")!=getResources().getString(R.string.placeholderIme)) text2=text2 + lista.get(7).get("ime");
        binding.hitanPoziv1.setText(text1);
        binding.hitanPoziv2.setText(text2);
    }



    @Override
    public void onClick(View view) {
        String permission = Manifest.permission.CALL_PHONE;
        Permissions.check(getContext(), permission, null, new PermissionHandler() {
            @Override
            public void onGranted() {
                int id=Integer.parseInt(view.getTag().toString());
                String brojZaNazvati=lista.get(id-1).get("broj");
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+brojZaNazvati));
                startActivity(callIntent);
                Log.d("broj za pozivanje: ",brojZaNazvati);
            }

            @Override
            public void onDenied(Context context, ArrayList<String> deniedPermissions) {
                super.onDenied(context, deniedPermissions);
            }
        });
    }
}