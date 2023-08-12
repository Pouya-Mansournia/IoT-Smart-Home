package info.zspcompany.smarthome.Addme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.zspcompany.smarthome.R;

/**
 * Created by Pouya_Mn on 13-Oct-16.
 */

public class login_screen extends Activity {

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        register = (Button) findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_activitybar = new Intent("android.intent.action.MAINACTIVITY");
                startActivity(open_activitybar);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
