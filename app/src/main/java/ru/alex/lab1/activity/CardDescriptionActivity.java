package ru.alex.lab1.activity;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.R;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.dao.MonsterDao;
import ru.alex.lab1.dao.MonsterDescriptionDao;
import ru.alex.lab1.db.AppDataBase;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterDescription;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.urls.BaseUrl;
import ru.alex.lab1.utils.converter.Impl.GsonMonsterConverterImpl;
import ru.alex.lab1.utils.converter.Impl.MonsterClassConverterDbImpl;
import ru.alex.lab1.utils.converter.Impl.MonsterConverterDbImpl;
import ru.alex.lab1.utils.converter.Impl.MonsterDescriptionConverterDbImpl;
import ru.alex.lab1.utils.converter.MonsterConverter;
import ru.alex.lab1.utils.converter.MonsterConverterDb;

public class CardDescriptionActivity extends AppCompatActivity implements MonsterCallBack<MonsterWithDescriptionDto> {

    private final MonsterService monsterService = new MonsterService(this);
    private final MonsterConverter monsterConverter = new GsonMonsterConverterImpl();

    private Long monsterId;
    private final MonsterConverterDb<MonsterWithDescriptionDto, MonsterDescription, MonsterWithDescriptionDto> monsterConverterDb;

    public CardDescriptionActivity() {
        this.monsterConverterDb = new MonsterDescriptionConverterDbImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_description);

        findViewById(R.id.card_description_scroll).setVerticalScrollBarEnabled(false);

        monsterId = getIntent().getLongExtra("id", 1);
        monsterService.getMonsterById(monsterId, this);
    }

    @Override
    public void onSuccess(MonsterWithDescriptionDto response) {

        setMonsterDescriptionOnUi(response);
        AsyncTask.execute(() -> {
            AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                            AppDataBase.class, "database-name")
                    .build();
            MonsterDescriptionDao monsterDescriptionDao = db.getMonsterDescDao();
            monsterDescriptionDao.nukeTable();

            MonsterDescription monsterDescription = monsterConverterDb.toEntity(response);
            monsterDescription.setMonsterId(monsterId);
            monsterDescriptionDao.insert(monsterDescription);
        });
    }

    @Override
    public void onFail(IOException error) {
        AsyncTask.execute(() -> {
            AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                            AppDataBase.class, "database-name")
                    .build();
            MonsterDescriptionDao monsterDescriptionDao = db.getMonsterDescDao();
            MonsterDao monsterDao = db.getMonsterDao();
            
            MonsterWithDescriptionDto monsterWithDescriptionDto = monsterConverterDb.toDto(monsterDescriptionDao.getMonsterById(monsterId)
                    .orElseThrow(() -> new RuntimeException("not found")));
            monsterWithDescriptionDto.setSource(monsterDao.getMonsterById(monsterId));

            runOnUiThread(() -> setMonsterDescriptionOnUi(monsterWithDescriptionDto));

        });
    }

    private void setMonsterDescriptionOnUi(MonsterWithDescriptionDto monsterDto) {
        ImageView imageView = findViewById(R.id.card_description_img);
        Glide.with(this)
                .load(BaseUrl.BASE_FOR_IMG + monsterDto.getSource() + monsterDto.getImgName())
                .thumbnail(Glide.with(this).load(R.drawable.preloader))
                .fitCenter()
                .into(imageView);

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

}
