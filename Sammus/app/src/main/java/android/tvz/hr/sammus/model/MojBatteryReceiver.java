package android.tvz.hr.sammus.model;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.tvz.hr.sammus.R;
import android.tvz.hr.sammus.controller.ui.MainActivity;

import androidx.annotation.RequiresApi;

public class MojBatteryReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Notification.Builder builder= new Notification.Builder(context, MainActivity.NOTIF_KANAL)
                .setSmallIcon(R.drawable.ic_menu_manage)
                .setContentTitle("Baterija je prazna")
                .setContentText("Stavite mobitel na punjenje, za detaljne upute pritisnite ovdje.");

        Intent intent1=new Intent(context, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        Notification notif=builder.build();
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(69,notif);
    }
}