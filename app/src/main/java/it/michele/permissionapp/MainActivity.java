package it.michele.permissionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getActiveNetworkInfo() == null || !getActiveNetworkInfo().isConnected()){
            new ErrorDialog().show(getSupportFragmentManager(), "error dialog");
        }
    }

    /*
    Otteniamo il NetworkInfo in questo modo possiamo vedere tutte le informazioni (non sensibili)
    della scheda di rete, connessa o meno ad internet
     */
    @SuppressLint("ServiceCast")
    public NetworkInfo getActiveNetworkInfo(){
         ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
         return connectivityManager.getActiveNetworkInfo();
    }
}