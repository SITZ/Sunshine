package com.siteshshrivastava.sunshine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private String LOG_TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        Log.i(LOG_TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i(LOG_TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(LOG_TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.i(LOG_TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(LOG_TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i(LOG_TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onDestroy();
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
        // as you specify a parent activity in AndroidManifest.xml

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            return true;
        } else if (id == R.id.map_view) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri geolocation = Uri.parse("geo:0,0?")
                    .buildUpon()
                    .appendQueryParameter("q", PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString(getString(R.string.pref_location_key), getString(R.string.pref_location_default)))
                    .build();
            intent.setData(geolocation);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
