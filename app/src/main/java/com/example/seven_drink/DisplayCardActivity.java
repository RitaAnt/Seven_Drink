package com.example.seven_drink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DisplayCardActivity extends AppCompatActivity {

    private List<Integer> cardImages;
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
        initializeAndShuffleCardImages();
        imageView = findViewById(R.id.imageView);
        showNextCard();
    }

    private void initializeAndShuffleCardImages() {
        cardImages = Arrays.asList(
                R.drawable.card6,
                R.drawable.card7,
                R.drawable.card8,
                R.drawable.card9
        );
        Collections.shuffle(cardImages);
    }

    private void showNextCard() {
        if (currentIndex < cardImages.size()) {
            imageView.setImageResource(cardImages.get(currentIndex));
            currentIndex++;
        }
    }

    public void onNextButtonClick(View view) {
        if (currentIndex < cardImages.size() - 1) {
            Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            imageView.startAnimation(fadeOut);

            // Устанавливаем новую карту
            imageView.setImageResource(cardImages.get(currentIndex));
            currentIndex++;

            // Запускаем анимацию появления
            Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            imageView.startAnimation(fadeIn);
        } else {
            Intent endIntent = new Intent(this, EndActivity.class);
            startActivity(endIntent);
            overridePendingTransition(0, 0);
        }
    }

}