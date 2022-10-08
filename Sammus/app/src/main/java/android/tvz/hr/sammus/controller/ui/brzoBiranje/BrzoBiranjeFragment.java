package android.tvz.hr.sammus.controller.ui.brzoBiranje;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.tvz.hr.sammus.R;
import android.tvz.hr.sammus.model.DBKomunikacija;
import android.tvz.hr.sammus.databinding.FragmentGalleryBinding;
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

public class BrzoBiranjeFragment extends Fragment implements View.OnClickListener {

    private BrzoBiranjeViewModel brzoBiranjeViewModel;
    private FragmentGalleryBinding binding;
    private List<HashMap<String, String>> lista = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);

        binding.brzoBiranje1.setOnClickListener(this);
        binding.brzoBiranje2.setOnClickListener(this);
        binding.brzoBiranje3.setOnClickListener(this);
        binding.brzoBiranje4.setOnClickListener(this);
        binding.brzoBiranje5.setOnClickListener(this);
        binding.brzoBiranje6.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        DBKomunikacija.getDBData(lista);
        String text1 = getResources().getString(R.string.buttonZovi) + " ";
        String text2 = getResources().getString(R.string.buttonZovi) + " ";
        String text3 = getResources().getString(R.string.buttonZovi) + " ";
        String text4 = getResources().getString(R.string.buttonZovi) + " ";
        String text5 = getResources().getString(R.string.buttonZovi) + " ";
        String text6 = getResources().getString(R.string.buttonZovi) + " ";
        if(lista.get(0).get("ime")!=getResources().getString(R.string.placeholderIme)) text1=text1 + lista.get(0).get("ime");
        if(lista.get(1).get("ime")!=getResources().getString(R.string.placeholderIme)) text2=text2 + lista.get(1).get("ime");
        if(lista.get(2).get("ime")!=getResources().getString(R.string.placeholderIme)) text3=text3 + lista.get(2).get("ime");
        if(lista.get(3).get("ime")!=getResources().getString(R.string.placeholderIme)) text4=text4 + lista.get(3).get("ime");
        if(lista.get(4).get("ime")!=getResources().getString(R.string.placeholderIme)) text5=text5 + lista.get(4).get("ime");
        if(lista.get(5).get("ime")!=getResources().getString(R.string.placeholderIme)) text6=text6 + lista.get(5).get("ime");
        binding.brzoBiranje1.setText(text1);
        binding.brzoBiranje2.setText(text2);
        binding.brzoBiranje3.setText(text3);
        binding.brzoBiranje4.setText(text4);
        binding.brzoBiranje5.setText(text5);
        binding.brzoBiranje6.setText(text6);
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