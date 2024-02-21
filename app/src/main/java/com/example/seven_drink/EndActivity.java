package com.example.seven_drink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        // Находим кнопку "повторить"
        findViewById(R.id.replayButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Перезапускаем игру, возможно, вы захотите начать новую активити MainActivity
                Intent restartIntent = new Intent(EndActivity.this, MainActivity.class);
                startActivity(restartIntent);
                finish(); // Закрываем текущую активность (EndActivity)
            }
        });
    }
}
