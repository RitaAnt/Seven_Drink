package com.example.seven_drink;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> cardImages;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Загружаем изображения карт в список
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

        // Перемешиваем карты
        Collections.shuffle(cardImages);

        // Находим ImageView в макете
        final ImageView imageView = findViewById(R.id.imageView);

        // Кнопка для отображения следующей карты
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < cardImages.size()) {
                    // Отображаем следующую карту
                    imageView.setImageResource(cardImages.get(currentIndex));
                    currentIndex++;
                } else {
                    // Если все карты показаны, выведите сообщение
                    Toast.makeText(MainActivity.this, "Все карты были использованы", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
