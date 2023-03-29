package ru.alex.lab1.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;

import ru.alex.lab1.R;
import ru.alex.lab1.callBack.monster.MonsterByIdCallBack;
import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.urls.BaseUrl;

public class CardDescriptionActivity extends AppCompatActivity implements MonsterByIdCallBack {

    private final MonsterService monsterService = new MonsterService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_description);

        long cardId = getIntent().getLongExtra("id", 1);
        monsterService.getMonsterById(cardId, this);
    }

    @Override
    public void onSuccess(MonsterWithDescriptionDto monsterDto) {
        ImageView imageView = findViewById(R.id.card_description_img);
        Glide.with(this)
                .load(BaseUrl.BASE_FOR_IMG + monsterDto.getSource() + monsterDto.getImgName()).into(imageView);

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

    @Override
    public void onFail(IOException error) {

    }
}
