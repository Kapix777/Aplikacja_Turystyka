package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button wroc = findViewById(R.id.wroc);

        /* Obsługuje zdarzenie kliknięcia przycisku "wróć".
         * Wraca do wcześniejszej intencji.
         *
         * @param wroc reprezentujący kliknięty przycisk.
         * @author Kacper Węgrzynowicz
         *
        */
        wroc.setOnClickListener(v->{
            Intent intencja = new Intent(this, MainActivity2.class);
            startActivity(intencja);
        });
    }

}