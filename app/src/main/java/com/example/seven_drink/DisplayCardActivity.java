package com.example.seven_drink;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DisplayCardActivity extends AppCompatActivity {

    private List<Integer> cardImages;
    private int currentIndex = 0;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_card);

        // Инициализируем изображения карт
        initializeAndShuffleCardImages();

        // Находим ImageView в макете
        imageView = findViewById(R.id.imageView);

        // Отображаем первую карту
        showNextCard();
    }

    // Инициализация изображений карт
    private void initializeAndShuffleCardImages() {
        cardImages = Arrays.asList(
                R.drawable.card6_1,
                R.drawable.card6_2,
                R.drawable.card6_3,
                R.drawable.card6_4,
                R.drawable.card7_1,
                R.drawable.card7_2,
                R.drawable.card7_3,
                R.drawable.card7_4,
                R.drawable.card8_1,
                R.drawable.card8_2,
                R.drawable.card8_3,
                R.drawable.card8_4,
                R.drawable.card9_1,
                R.drawable.card9_2,
                R.drawable.card9_3,
                R.drawable.card9_4,
                R.drawable.card10_1,
                R.drawable.card10_2,
                R.drawable.card10_3,
                R.drawable.card10_4,
                R.drawable.cardj_1,
                R.drawable.cardj_2,
                R.drawable.cardj_3,
                R.drawable.cardj_4,
                R.drawable.cardq_1,
                R.drawable.cardq_2,
                R.drawable.cardq_3,
                R.drawable.cardq_4,
                R.drawable.cardk_1,
                R.drawable.cardk_2,
                R.drawable.cardk_3,
                R.drawable.cardk_4,
                R.drawable.cardt_1,
                R.drawable.cardt_2,
                R.drawable.cardt_3,
                R.drawable.cardt_4
        );
        Collections.shuffle(cardImages);
    }

    // Метод для отображения следующей карты
    private void showNextCard() {
        if (currentIndex < cardImages.size()) {
            // Отображаем текущую карту
            imageView.setImageResource(cardImages.get(currentIndex));

            // Увеличиваем индекс для следующей карты
            currentIndex++;
        } else {
            // Если все карты показаны, выведите сообщение
            Toast.makeText(this, "Все карты были использованы", Toast.LENGTH_SHORT).show();
        }
    }

    // Обработчик нажатия кнопки "Следующая карта"
    public void onNextButtonClick(View view) {
        showNextCard();
    }
}
