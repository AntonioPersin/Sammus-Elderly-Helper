package android.tvz.hr.sammus.controller.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.tvz.hr.sammus.R;
import android.tvz.hr.sammus.controller.ui.MainActivity;
import android.view.View;

public class AnnoyingActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annoying);
        mp=mp.create(this,R.raw.enemy_missing_ping);
        mp.setLooping(true);
        mp.start();
    }

    public void onAnnoyanceDismissed(View view){
        mp.stop();
        mp.release();
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}