package android.tvz.hr.sammus.controller.ui.creditsAndLegal;

import android.os.Bundle;
import android.tvz.hr.sammus.databinding.FragmentSlideshowBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class CreditsAndLegalFragment extends Fragment {

    private CreditsAndLegalViewModel creditsAndLegalViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=FragmentSlideshowBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}