package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button wys = findViewById(R.id.wys);
        Button wroc = findViewById(R.id.wroc);
        Button o_nas = findViewById(R.id.o_nas);

        /* Obsługuje zdarzenie kliknięcia przycisku "wyślij".
         * wyświetla komunikat Toast.
         *
         * @param wys reprezentujący kliknięty przycisk.
         * @author Kacper Węgrzynowicz
         *
         */
        
        wys.setOnClickListener(v->{
            Toast.makeText(this, "Zapytanie zostało wysłane. Oczekuj na kontakt!", Toast.LENGTH_SHORT).show();
        });

        /* Obsługuje zdarzenie kliknięcia przycisku "wróć".
         * Wraca do wcześniejszej intencji.
         *
         * @param wroc reprezentujący kliknięty przycisk.
         * @author Kacper Węgrzynowicz
         *
         */

        wroc.setOnClickListener(v->{
            Intent intencja = new Intent(this, MainActivity.class);
            startActivity(intencja);
        });

        /* Obsługuje zdarzenie kliknięcia przycisku "O nas".
         * Wraca do wcześniejszej intencji.
         *
         * @param o_nas reprezentujący kliknięty przycisk.
         * @author Kacper Węgrzynowicz
         *
         */

        o_nas.setOnClickListener(v->{
            Intent intencja = new Intent(this, MainActivity3.class);
            startActivity(intencja);
        });

    }
    
}