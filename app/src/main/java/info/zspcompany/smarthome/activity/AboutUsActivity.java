package info.zspcompany.smarthome.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import info.zspcompany.smarthome.R;

public class AboutUsActivity extends AppCompatActivity {

    Button tell,web,insta,telegram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();

        tell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_tell = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+982126459073"));
                startActivity(call_tell);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_web = new Intent(Intent.ACTION_VIEW, Uri.parse("http://zsp-group.com/"));
                startActivity(call_web);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_insta = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/zsp.co/"));
                startActivity(call_insta);
            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_telegram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/joinchat/BNBjCj-eNTpi2kbQu1EL1Q"));
                startActivity(call_telegram);
            }
        });

    }
    public void init()
    {
     tell       = (Button) findViewById(R.id.btn_tell);
     web        = (Button) findViewById(R.id.btn_website);
     insta      = (Button) findViewById(R.id.btn_instagram);
     telegram   = (Button) findViewById(R.id.btn_telegram);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
