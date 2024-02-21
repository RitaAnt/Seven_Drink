package com.example.seven_drink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DisplayCardActivity extends AppCompatActivity {

    private List<Integer> doubledAndShuffledCardImages;
    private int currentIndex = 0;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setContentView(R.layout.activity_display_card);
        initializeDoubledAndShuffledCardImages();
        imageView = findViewById(R.id.imageView);
        showNextCard();
    }

    private void initializeDoubledAndShuffledCardImages() {
        List<Integer> cardImages = Arrays.asList(
                R.drawable.card6,
                R.drawable.card7,
                R.drawable.card8,
                R.drawable.card9
        );

        // Удваиваем карты
        doubledAndShuffledCardImages = new ArrayList<>(cardImages);
        doubledAndShuffledCardImages.addAll(cardImages);

        // Перемешиваем
        Collections.shuffle(doubledAndShuffledCardImages);
    }

    private void showNextCard() {
        if (currentIndex < doubledAndShuffledCardImages.size()) {
            imageView.setImageResource(doubledAndShuffledCardImages.get(currentIndex));
            currentIndex++;
        }
    }

    public void onNextButtonClick(View view) {
        if (currentIndex < doubledAndShuffledCardImages.size()) {
            Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            imageView.startAnimation(fadeOut);

            imageView.setImageResource(doubledAndShuffledCardImages.get(currentIndex));
            currentIndex++;

            Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            imageView.startAnimation(fadeIn);
        } else {
            Intent endIntent = new Intent(this, EndActivity.class);
            startActivity(endIntent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
