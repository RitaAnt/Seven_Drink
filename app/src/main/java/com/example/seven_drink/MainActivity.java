package com.example.seven_drink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.content.Intent;
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
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        try {
            // Инициализация изображений карт
            initializeCardImages();

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
                        Intent intent = new Intent(MainActivity.this, DisplayCardActivity.class);
                        intent.putExtra("cardImage", cardImages.get(currentIndex));
                        startActivity(intent);
                        currentIndex++;
                    } else {
//                        Intent endIntent = new Intent(MainActivity.this, EndActivity.class);
//                        startActivity(endIntent);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Произошла ошибка: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onStartButtonClick(View view) {
        // В этом методе вы можете добавить код, который будет выполняться при нажатии кнопки "Начать"
        try {
            if (currentIndex < cardImages.size()) {
                // Отображаем следующую карту
                Intent intent = new Intent(this, DisplayCardActivity.class);
                intent.putExtra("cardImage", cardImages.get(currentIndex));
                startActivity(intent);
                currentIndex++;
            } else {
                // Если все карты показаны, выведите сообщение
                Toast.makeText(this, "Все карты были использованы", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Произошла ошибка: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void initializeCardImages() {
        cardImages = Arrays.asList(
                R.drawable.card6,
                R.drawable.card7,
                R.drawable.card8,
                R.drawable.card9

//                R.drawable.card6_3,
//                R.drawable.card6_4,
//                R.drawable.card7_1,
//                R.drawable.card7_2,
//                R.drawable.card7_3,
//                R.drawable.card7_4,
//                R.drawable.card8_1,
//                R.drawable.card8_2,
//                R.drawable.card8_3,
//                R.drawable.card8_4,
//                R.drawable.card9_1,
//                R.drawable.card9_2,
//                R.drawable.card9_3,
//                R.drawable.card9_4,
//                R.drawable.card10_1,
//                R.drawable.card10_2,
//                R.drawable.card10_3,
//                R.drawable.card10_4,
//                R.drawable.cardj_1,
//                R.drawable.cardj_2,
//                R.drawable.cardj_3,
//                R.drawable.cardj_4,
//                R.drawable.cardq_1,
//                R.drawable.cardq_2,
//                R.drawable.cardq_3,
//                R.drawable.cardq_4,
//                R.drawable.cardk_1,
//                R.drawable.cardk_2,
//                R.drawable.cardk_3,
//                R.drawable.cardk_4,
//                R.drawable.cardt_1,
//                R.drawable.cardt_2,
//                R.drawable.cardt_3,
//                R.drawable.cardt_4
        );
    }
}