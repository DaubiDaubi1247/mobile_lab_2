package ru.alex.lab1;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.alex.lab1.adapter.CardPreviewAdapter;
import ru.alex.lab1.callBack.monster.MonsterCallBack;
import ru.alex.lab1.pojo.Title;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;
import ru.alex.lab1.utils.converter.Impl.GsonMonsterConverterImpl;
import ru.alex.lab1.utils.converter.MonsterConverter;

public class MainActivity extends AppCompatActivity implements MonsterCallBack {

    private final MonsterService monsterService;

    private final List<RecyclerViewElement> recyclerViewElementList;

    private final CardPreviewAdapter monsterAdapter;

    private final MonsterConverter monsterConverter;

    public MainActivity() {
        this.monsterService = new MonsterService(this);
        this.recyclerViewElementList = new ArrayList<>();
        this.monsterAdapter = new CardPreviewAdapter(recyclerViewElementList);
        this.monsterConverter = new GsonMonsterConverterImpl();
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
        monsterAdapter.updateCardPreviewRecycler(monsterConverter.toMonsterClassDtoList(responseInString));
    }

    @Override
    public void onFail(IOException error) {

    }
}