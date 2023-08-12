package info.zspcompany.smarthome.Addme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import info.zspcompany.smarthome.R;

/**
 * Created by Pouya_Mn on 13-Oct-16.
 */

public class splash_screen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread time_control = new Thread()
        {
          public void run()
          {

              try {
                  sleep(3500);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }finally {
                  Intent open_activity = new Intent("android.intent.action.LOGINACTIVITY");
                  startActivity(open_activity);

              }
          }



        };
        time_control.start();



    }

    // Toye Onpause Age Finish konam, az barname dar miyad va hafeze kam masraf mikounad.
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}


