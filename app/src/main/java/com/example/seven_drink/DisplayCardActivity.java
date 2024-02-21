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

    private List<Integer> doubledCardImages;
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
        doubledCardImages = Arrays.asList(
                R.drawable.card6,
                R.drawable.card7,
                R.drawable.card8,
                R.drawable.card9
        );
        Collections.shuffle(doubledCardImages);
    }

    private void showNextCard() {
        if (currentIndex < doubledCardImages.size()) {
            imageView.setImageResource(doubledCardImages.get(currentIndex));
            currentIndex++;
        }
    }

    public void onNextButtonClick(View view) {
        if (currentIndex < doubledCardImages.size() * 2) {
            Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            imageView.startAnimation(fadeOut);

            imageView.setImageResource(doubledCardImages.get(currentIndex % doubledCardImages.size()));
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