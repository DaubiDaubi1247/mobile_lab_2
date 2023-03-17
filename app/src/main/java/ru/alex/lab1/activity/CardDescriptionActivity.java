package ru.alex.lab1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ru.alex.lab1.R;

public class CardDescriptionActivity extends AppCompatActivity {

    private int cardId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_description);
        cardId = getIntent().getIntExtra("id", 1);

        TextView textView = findViewById(R.id.card_description_description);
        textView.setText("" + cardId);

    }
}