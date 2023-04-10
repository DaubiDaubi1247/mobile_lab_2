package ru.alex.lab1;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.dao.MonsterClassDao;
import ru.alex.lab1.db.AppDataBase;
import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.pojo.Title;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.utils.converter.Impl.GsonMonsterConverterImpl;
import ru.alex.lab1.utils.converter.Impl.MonsterConverterDbImpl;
import ru.alex.lab1.utils.converter.MonsterConverter;
import ru.alex.lab1.utils.converter.MonsterConverterDb;

public class MainActivity extends AppCompatActivity implements MonsterCallBack {

    private final MonsterService monsterService;

    private final List<RecyclerViewElement> recyclerViewElementList;

    private final CardPreviewAdapter monsterAdapter;

    private final MonsterConverter monsterConverter;
    private final MonsterConverterDb monsterConverterDb;

    public MainActivity() {
        this.monsterService = new MonsterService(this);
        this.recyclerViewElementList = new ArrayList<>();
        this.monsterAdapter = new CardPreviewAdapter(recyclerViewElementList);
        this.monsterConverter = new GsonMonsterConverterImpl();
        this.monsterConverterDb = new MonsterConverterDbImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);

        prepareAndSetRecyclerView();

        BottomNavigationView bottomNavigationView = findViewById(R.id.footer);
        bottomNavigationView.setSelectedItemId(R.id.page_2);

    }

    private void prepareAndSetRecyclerView() {
        recyclerViewElementList.add(new Title());

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(monsterAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (monsterAdapter.getItemViewType(position) == RecyclerViewElement.TITLE) {
                    return 2;
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(layoutManager);

        setInitialData();
    }

    private void setInitialData() {
         monsterService.getMonsterClassList(this);
    }

    @Override
    public void onSuccess(String responseInString) {
        List<RecyclerCardPreview> recyclerCardPreviews = monsterConverter.toMonsterClassDtoList(responseInString);
        monsterAdapter.updateCardPreviewRecycler(recyclerCardPreviews);

        AsyncTask.execute(() -> {
            AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                            AppDataBase.class, "database-name")
                    .build();
            MonsterClassDao monsterClassDao = db.getMonsterClassDao();
            monsterClassDao.nukeTable();
            List<MonsterClass> monsterClassList = monsterConverterDb.toEntityList(recyclerCardPreviews);
            monsterClassDao.insertAll(monsterConverterDb.toEntityList(recyclerCardPreviews));
        });
    }

    @Override
    public void onFail(IOException error) {

        AsyncTask.execute(() -> {
            AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                            AppDataBase.class, "database-name")
                    .build();
            MonsterClassDao monsterClassDao = db.getMonsterClassDao();
            monsterAdapter.updateCardPreviewRecycler(monsterConverterDb.toDtoList(monsterClassDao.getAll())
                    .stream().map(MonsterClassDto::toPojo).collect(Collectors.toList()));
        });
    }
}