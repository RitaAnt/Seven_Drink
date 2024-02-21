package com.example.seven_drink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

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
            Collections.shuffle(cardImages);


            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DisplayCardActivity.class);
                    intent.putExtra("cardImage", cardImages.get(currentIndex));
                    startActivity(intent);
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
            currentIndex++;
        }
    }
    private void initializeCardImages() {
        cardImages = Arrays.asList(
                R.drawable.card6,
                R.drawable.card7,
                R.drawable.card8,
                R.drawable.card9
        );
    }
}