package ru.alex.lab1;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import ru.alex.lab1.pojo.Monster;

public class MainActivity extends AppCompatActivity {

    List<Monster> monsterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);

        setInitialData();

        GridLayout gridLayout = findViewById(R.id.card_list);
        LayoutInflater ltInflater = getLayoutInflater();

        fillLayoutWithList(gridLayout, ltInflater);

        gridLayout.setRowCount((int) Math.ceil(monsterList.size() / 2.0));

//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//
//        MonstersAdapter monstersAdapter = new MonstersAdapter(this, monsterList);
////        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setAdapter(monstersAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
        bottomNavigationView.setSelectedItemId(R.id.page_2);
    }

    private void fillLayoutWithList(GridLayout gridLayout, LayoutInflater ltInflater) {
        for (Monster monster : monsterList) {
            View item = ltInflater.inflate(R.layout.recycler_view_card, gridLayout, false);
            TextView title = item.findViewById(R.id.recycler_view_card_title);
            title.setText(monster.getName());
            ImageView imageView =  item.findViewById(R.id.recycler_view_card_img);
            imageView.setImageResource(monster.getImgResource());
            
            gridLayout.addView(item);
        }
    }

    private void setInitialData(){

        monsterList.add(new Monster ("Вампиры", R.drawable.vampire));
        monsterList.add(new Monster ("Духи и призраки", R.drawable.ghost));
        monsterList.add(new Monster ("Дракониды", R.drawable.draconid));
        monsterList.add(new Monster ("Реликты", R.drawable.relict));
        monsterList.add(new Monster ("Огры", R.drawable.ogr));
        monsterList.add(new Monster ("Гибриды", R.drawable.gibrid));
    }
}