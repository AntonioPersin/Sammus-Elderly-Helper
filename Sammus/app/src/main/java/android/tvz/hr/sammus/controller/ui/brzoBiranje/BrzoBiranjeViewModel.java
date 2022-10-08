package android.tvz.hr.sammus.controller.ui.brzoBiranje;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BrzoBiranjeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BrzoBiranjeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}