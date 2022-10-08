package android.tvz.hr.sammus.model;

import android.content.Intent;
import android.os.Build;
import android.tvz.hr.sammus.controller.ui.AnnoyingActivity;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MojFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG="Impasta";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);

        Intent intent=new Intent(this, AnnoyingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        Log.d(TAG,"od koga sam to dobil: "+remoteMessage.getFrom());
        Log.d(TAG,"kome to ide: "+remoteMessage.getTo());
        Log.d(TAG,"kaj pise: "+remoteMessage.getNotification().getBody());
    }

    @Override
    public void onNewToken(@NonNull String s) {
        Log.d(TAG,"Refresh token: "+s);
        sendRegistrationToServer(s);
    }

    private void sendRegistrationToServer(String s) {
    }
}