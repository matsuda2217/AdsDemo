package com.example.tt.adsdemo;

import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends ActionBarActivity {
    AdView adView;
    String unitId ="a14f840b733d0dc";
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root);
        //Display display = getWindowManager().getDefaultDisplay();
       // Point size = new Point();
       // display.getSize(size);
        //size.y = display.getHeight();
        adView =(AdView) this.findViewById(R.id.adView);
        //adView.setAdUnitId(unitId);
        //adView.setAdSize(AdSize.BANNER);
        AdView adView1 = (AdView) findViewById(R.id.adView1);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(unitId);
        //adView.setY(size.y -AdSize.BANNER.getHeight()-30);



       // linearLayout.addView(adView, 0) ;
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("5554")
                .build();
        interstitialAd.loadAd(adRequest);
        adView1.loadAd(adRequest);
        adView.loadAd(adRequest);
    }

    public void displayInetersitial() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode== event.KEYCODE_BACK) {
            displayInetersitial();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
