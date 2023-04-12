package ru.alex.lab1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.R;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.dao.MonsterClassDao;
import ru.alex.lab1.dao.MonsterDao;
import ru.alex.lab1.db.AppDataBase;
import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.pojo.MonsterListTitle;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.utils.converter.Impl.MonsterConverterDbImpl;
import ru.alex.lab1.utils.converter.MonsterConverterDb;
import ru.alex.lab1.utils.converter.MonsterConverterDbWithList;

public class MonsterListActivity extends AppCompatActivity implements MonsterCallBack<List<RecyclerCardPreview>> {

    private Long classId;

    private final MonsterService monsterService;
    private final MonsterConverterDbWithList<RecyclerCardPreview, Monster, MonsterDto> monsterConverterDb;

    List<RecyclerViewElement> recyclerViewElementList;

    private CardPreviewAdapter cardPreviewAdapter;

    public MonsterListActivity() {
        this.monsterConverterDb = new MonsterConverterDbImpl();
        recyclerViewElementList = new ArrayList<>();
        monsterService = new MonsterService(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list_acitvity);

        classId = getIntent().getLongExtra("id", 1);

        String title = getIntent().getStringExtra("title");
        recyclerViewElementList.add(new MonsterListTitle(title));
        cardPreviewAdapter = new CardPreviewAdapter(recyclerViewElementList);

        RecyclerView recyclerView = findViewById(R.id.monster_list_recycler);

        setInitialData(classId);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (cardPreviewAdapter.getItemViewType(position) == RecyclerViewElement.MONSTER_LIST_TITLE) {
                    return 2;
                }
                return 1;
            }
        });
        recyclerView.setAdapter(cardPreviewAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setInitialData(long id) {
        monsterService.getMonsterListByClassId(id, this);
    }

    @Override
    public void onSuccess(List<RecyclerCardPreview> response) {
        cardPreviewAdapter.updateCardPreviewRecycler(response);

        AsyncTask.execute(() -> {
            AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                            AppDataBase.class, "database-name")
                    .build();
            MonsterDao monsterDao = db.getMonsterDao();
            monsterDao.nukeTable();
            List<Monster> monsterList = monsterConverterDb.toEntityList(response);
            monsterList.forEach(el -> el.setClassId(classId));
            monsterDao.insertAll(monsterList);
        });
    }

    @Override
    public void onFail(IOException error){
        AsyncTask.execute(() -> {
            AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                            AppDataBase.class, "database-name")
                    .build();
            MonsterDao monsterDao = db.getMonsterDao();
            List<MonsterDto> monsterClassDtoList = monsterConverterDb.toDtoList(monsterDao.getAllByClassId(classId));

            runOnUiThread(() -> cardPreviewAdapter.updateCardPreviewRecycler(monsterClassDtoList.stream()
                    .map(MonsterDto::toPojo).collect(Collectors.toList())));

        });
    }
}