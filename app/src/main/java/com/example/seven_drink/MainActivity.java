package com.example.seven_drink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private List<Integer> cardImages;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_start);

        try {
            initializeCardImages();
            List<Integer> doubledCardImages = new ArrayList<>(cardImages);
            doubledCardImages.addAll(cardImages); // Удваиваем карты
            Collections.shuffle(doubledCardImages);
            Collections.shuffle(doubledCardImages);

            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setOnClickListener(v -> {
                if (currentIndex < doubledCardImages.size()) {
                    Intent intent = new Intent(MainActivity.this, DisplayCardActivity.class);
                    intent.putExtra("cardImage", doubledCardImages.get(currentIndex));
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    currentIndex++;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onStartButtonClick(View view) {
        if (currentIndex < cardImages.size()) {
            Intent intent = new Intent(this, DisplayCardActivity.class);
            intent.putExtra("cardImage", cardImages.get(currentIndex));
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            currentIndex++;
        }
    }
    private void initializeCardImages() {
        cardImages = Arrays.asList(
                R.drawable.card6,
                R.drawable.card7,
                R.drawable.card8,
                R.drawable.card9,
                R.drawable.cardj,
                R.drawable.cardq,
                R.drawable.cardk,
                R.drawable.cardt
        );
    }
}