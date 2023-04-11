package ru.alex.lab1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.alex.lab1.R;
import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.pojo.MonsterListTitle;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.utils.converter.Impl.GsonMonsterConverterImpl;
import ru.alex.lab1.utils.converter.MonsterConverter;

public class MonsterListActivity extends AppCompatActivity implements MonsterCallBack<List<RecyclerCardPreview>> {

    private final MonsterService monsterService;

    List<RecyclerViewElement> recyclerViewElementList;

    private CardPreviewAdapter cardPreviewAdapter;

    public MonsterListActivity() {
        recyclerViewElementList = new ArrayList<>();
        monsterService = new MonsterService(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list_acitvity);

        long id = getIntent().getLongExtra("id", 1);

        String title = getIntent().getStringExtra("title");
        recyclerViewElementList.add(new MonsterListTitle(title));
        cardPreviewAdapter = new CardPreviewAdapter(recyclerViewElementList);

        RecyclerView recyclerView = findViewById(R.id.monster_list_recycler);

        setInitialData(id);

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
    }

    @Override
    public void onFail(IOException error){

    }
}