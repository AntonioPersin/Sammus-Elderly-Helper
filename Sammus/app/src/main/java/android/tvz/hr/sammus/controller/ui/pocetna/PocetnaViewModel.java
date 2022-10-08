package android.tvz.hr.sammus.controller.ui.pocetna;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PocetnaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PocetnaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}