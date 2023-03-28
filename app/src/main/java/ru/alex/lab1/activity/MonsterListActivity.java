package ru.alex.lab1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ru.alex.lab1.R;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;

public class MonsterListActivity extends AppCompatActivity {

    private final List<RecyclerViewElement> recyclerViewElementList;
    private final MonsterService monsterService;

    public MonsterListActivity() {
        this.recyclerViewElementList = new ArrayList<>();
        this.monsterService = new MonsterService(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list_acitvity);

        long id = getIntent().getLongExtra("id", 1);

        RecyclerView recyclerView = findViewById(R.id.monster_list_recycler);
        CardPreviewAdapter cardPreviewAdapter = new CardPreviewAdapter(this, recyclerViewElementList);
        setInitialData(cardPreviewAdapter, id);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setAdapter(cardPreviewAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setInitialData(CardPreviewAdapter cardPreviewAdapter, long id) {
        monsterService.getMonsterListByClassId(cardPreviewAdapter, id);
    }
}