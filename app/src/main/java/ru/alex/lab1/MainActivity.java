package ru.alex.lab1;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import ru.alex.lab1.adapter.MonstersAdapter;
import ru.alex.lab1.pojo.MonsterClass;
import ru.alex.lab1.pojo.Title;
import ru.alex.lab1.recycler.RecyclerViewElement;
import ru.alex.lab1.service.MonsterService;

public class MainActivity extends AppCompatActivity {

    private final MonsterService monsterService = new MonsterService(this);

    List<RecyclerViewElement> recyclerViewElementList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        recyclerViewElementList.add(new Title());

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        MonstersAdapter monstersAdapter = new MonstersAdapter(this, recyclerViewElementList);
        recyclerView.setAdapter(monstersAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (monstersAdapter.getItemViewType(position) == RecyclerViewElement.TITLE) {
                    return 2;
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(layoutManager);

        setInitialData(monstersAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.footer);
        bottomNavigationView.setSelectedItemId(R.id.page_2);

        // получение картинки с моего сервера
        //todo спросить можно ли будет с моего сервера тянуть информацию
//        ImageView imageView = findViewById(R.id.img);
//
//        Glide.with(this).load("http://192.168.0.103:8080/api/users/2.png").into(imageView);
    }

    public void setInitialData(MonstersAdapter monstersAdapter) {
        monsterService.getMonsterClassList(monstersAdapter);
//        recyclerViewElementList.add(new Monster (7, "Проклятые", R.drawable.coursed));
    }
}