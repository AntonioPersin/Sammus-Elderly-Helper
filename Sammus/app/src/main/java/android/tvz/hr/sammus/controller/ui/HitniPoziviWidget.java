package android.tvz.hr.sammus.controller.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.tvz.hr.sammus.R;
import android.tvz.hr.sammus.model.DBKomunikacija;
import android.widget.Button;
import android.widget.RemoteViews;

import androidx.appcompat.widget.Toolbar;

import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.security.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.raizlabs.android.dbflow.config.FlowManager.getContext;

public class HitniPoziviWidget extends AppWidgetProvider {

    private List<HashMap<String, String>> lista = new ArrayList<>();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {
            DBKomunikacija.getDBData(lista);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.hitni_pozivi_widget);
            remoteViews.setTextViewText(R.id.widgetHitnoButton1,context.getResources().getString(R.string.buttonZovi)+" "+lista.get(6).get("ime"));
            remoteViews.setTextViewText(R.id.widgetHitnoButton2,context.getResources().getString(R.string.buttonZovi)+" "+lista.get(7).get("ime"));

            String[] permission = {Manifest.permission.CALL_PHONE};
            Permissions.Options options = new Permissions.Options().setCreateNewTask(true);
            Permissions.check(context, permission, null, options, new PermissionHandler() {
                @Override
                public void onGranted() {

                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:"+ lista.get(6).get("broj")));
                    callIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    PendingIntent pendingIntent1 = PendingIntent.getActivity(context, 0, callIntent1, 0);

                    remoteViews.setOnClickPendingIntent(R.id.widgetHitnoButton1, pendingIntent1);

                    Intent callIntent2 = new Intent(Intent.ACTION_CALL);
                    callIntent2.setData(Uri.parse("tel:"+lista.get(7).get("broj")));
                    callIntent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 0, callIntent2, 0);

                    remoteViews.setOnClickPendingIntent(R.id.widgetHitnoButton2, pendingIntent2);

                    appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
                }
                @Override
                public void onDenied(Context context, ArrayList<String> deniedPermissions) {
                    super.onDenied(context, deniedPermissions);
                }
            });
        }
    }

    @Override
    public void onEnabled(Context context) {
    }

    @Override
    public void onDisabled(Context context) {
    }

}