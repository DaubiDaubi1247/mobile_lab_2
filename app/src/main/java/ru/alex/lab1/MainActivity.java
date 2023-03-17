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
import ru.alex.lab1.pojo.Monster;
import ru.alex.lab1.pojo.Title;
import ru.alex.lab1.recycler.RecyclerViewElement;

public class MainActivity extends AppCompatActivity {

    List<RecyclerViewElement> recyclerViewElementList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);

        setInitialData();
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

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_2);

        // получение картинки с моего сервера
        //todo спросить можно ли будет с моего сервера тянуть информацию
//        ImageView imageView = findViewById(R.id.img);
//
//        Glide.with(this).load("http://192.168.0.103:8080/api/users/2.png").into(imageView);
    }

    private void setInitialData(){
        recyclerViewElementList.add(new Title());
        recyclerViewElementList.add(new Monster (1, "Вампиры", R.drawable.vampire));
        recyclerViewElementList.add(new Monster (2, "Духи и призраки", R.drawable.ghost));
        recyclerViewElementList.add(new Monster (3, "Дракониды", R.drawable.draconid));
        recyclerViewElementList.add(new Monster (4, "Реликты", R.drawable.relict));
        recyclerViewElementList.add(new Monster (5, "Огры", R.drawable.ogr));
        recyclerViewElementList.add(new Monster (6, "Гибриды", R.drawable.gibrid));
        recyclerViewElementList.add(new Monster (7, "Проклятые", R.drawable.coursed));
    }
}