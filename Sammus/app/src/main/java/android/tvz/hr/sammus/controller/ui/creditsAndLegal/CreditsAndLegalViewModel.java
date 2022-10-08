package android.tvz.hr.sammus.controller.ui.creditsAndLegal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CreditsAndLegalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CreditsAndLegalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}