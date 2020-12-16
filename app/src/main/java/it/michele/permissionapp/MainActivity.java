package it.michele.permissionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getActiveNetworkInfo() == null || !getActiveNetworkInfo().isConnected()){
            new ErrorDialog().show(getSupportFragmentManager(), "error dialog");
        } else {
            /*
            Riproduce un file audio prendendolo dalla cartella raw dell'applicazione
             */
            mediaPlayer = MediaPlayer.create(this, R.raw.music);
            mediaPlayer.start();

            /*
            Riproduce un file audio prendendolo direttamente dal web
             */
            /*MediaPlayer mediaPlayer1 = new MediaPlayer();
            try {
                mediaPlayer1.setDataSource("https://sitomio.it/music.mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }*/
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