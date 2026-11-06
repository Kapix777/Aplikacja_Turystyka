package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int like=0;
    String polubienia = "POLUBIENIA";
    String key = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button polub = findViewById(R.id.polub);
        Button usun = findViewById(R.id.usun);
        Button zapisz = findViewById(R.id.zapisz);
        Button umow = findViewById(R.id.umow);

        TextView tekstView = findViewById(R.id.like);

        SharedPreferences settings = getSharedPreferences(polubienia, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        like = settings.getInt(key,like);

        tekstView.setText(like + " polubień");

        /*
         * Obsługuje zdarzenie kliknięcia przycisku "POLUB".
         * Inkrementuje licznik polubień i aktualizuje widok.
         *
         * @param polub reprezentujący kliknięty przycisk.
         * like reprezentuję liczbę polubień
         * @author Kacper Węgrzynowicz
        */

        polub.setOnClickListener(v -> {
            like++;
            tekstView.setText(like + " polubień");
        });

        /*
         * Obsługuje zdarzenie kliknięcia przycisku "USUN".
         * Dekrementuje licznik polubień i aktualizuje widok.
         *
         * @param usun reprezentujący kliknięty przycisk.
         * like reprezentuję liczbę polubień
         * @author Kacper Węgrzynowicz
         */

        usun.setOnClickListener(v->{
            if(like > 0 ){
                like--;
            }
            tekstView.setText(like + " polubień");
        });

        /*
         * Obsługuje zdarzenie kliknięcia przycisku "ZAPISZ".
         * Dekrementuje licznik polubień i aktualizuje widok.
         *
         * @param zapisz reprezentujący kliknięty przycisk.
         * @author Kacper Węgrzynowicz
         */

        zapisz.setOnClickListener(v->{
            editor.putInt(key, like);
            editor.apply();
            Toast.makeText(this,"Zapisano",Toast.LENGTH_LONG).show();
        });
        /* Obsługuje zdarzenie kliknięcia przycisku "Umów".
         * Przechodzi do nowej intencji.
         *
         * @param umow reprezentujący kliknięty przycisk.
         * @author Kacper Węgrzynowicz
         */
        umow.setOnClickListener(v->{
            Intent intencja = new Intent(this, MainActivity2.class);
            startActivity(intencja);
        });
    }
    /* Obsługuje zapisanie preferencji.
     * Zapisuję ilość polubień.
     *
     * @author Kacper Węgrzynowicz
     */
    public void saveLikes(){
        SharedPreferences settings = getSharedPreferences(polubienia, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, like);
        editor.apply();
        Toast.makeText(this,"Zapisano",Toast.LENGTH_LONG).show();
    }

    protected void onStop(){
        super.onStop();
        saveLikes();
    }
    protected void onPause(){
        super.onPause();
        saveLikes();
    }
}