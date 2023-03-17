package ru.alex.lab1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import ru.alex.lab1.R;
import ru.alex.lab1.db.DataBase;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.pojo.Monster;

public class CardDescriptionActivity extends AppCompatActivity {

    private MonsterDto monsterDto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_description);

        int cardId = getIntent().getIntExtra("id", 1);
        monsterDto = getMonsterDtoFromServer(cardId);

        setMonsterToLayout();

    }

    private void setMonsterToLayout() {
        ImageView imageView = findViewById(R.id.card_description_img);
        imageView.setImageResource(monsterDto.getImgRes());

        TextView textView = findViewById(R.id.card_description_name);
        textView.setText(monsterDto.getName());
        textView.setTypeface(null, Typeface.BOLD);

        textView = findViewById(R.id.card_description_quote);
        textView.setText(monsterDto.getQuote());
        textView.setTypeface(null, Typeface.ITALIC);

        textView = findViewById(R.id.card_description_quote_author);
        textView.setText(monsterDto.getQuoteAuthor());

        textView = findViewById(R.id.card_description_description);
        textView.setText(monsterDto.getDescription());
    }

    private MonsterDto getMonsterDtoFromServer(int id) {
        return DataBase.getInstance().getMonsterById(id);
    }
}
