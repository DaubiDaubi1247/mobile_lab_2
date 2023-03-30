package ru.alex.lab1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

import ru.alex.lab1.R;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.utils.converter.Impl.MonsterConverterImpl;
import ru.alex.lab1.utils.converter.MonsterConverter;

public class MonsterListActivity extends AppCompatActivity implements MonsterCallBack {

    private final MonsterService monsterService;

    private final CardPreviewAdapter  cardPreviewAdapter;

    private final MonsterConverter monsterConverter = new MonsterConverterImpl();

    public MonsterListActivity() {
        this.monsterService = new MonsterService(this);
        this.cardPreviewAdapter = new CardPreviewAdapter(new ArrayList<>());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list_acitvity);

        long id = getIntent().getLongExtra("id", 1);

        RecyclerView recyclerView = findViewById(R.id.monster_list_recycler);

        setInitialData(id);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setAdapter(cardPreviewAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setInitialData(long id) {
        monsterService.getMonsterListByClassId(id, this);
    }

    @Override
    public void onSuccess(String responseInString) {
        cardPreviewAdapter.updateCardPreviewRecycler(monsterConverter.toMonsterDtoList(responseInString));
    }

    @Override
    public void onFail(IOException error) {

    }
}