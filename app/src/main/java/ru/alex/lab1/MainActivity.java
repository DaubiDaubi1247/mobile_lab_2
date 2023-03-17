package ru.alex.lab1;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import ru.alex.lab1.adapter.MonstersAdapter;
import ru.alex.lab1.pojo.Monster;
import ru.alex.lab1.pojo.Title;
import ru.alex.lab1.recycler.ElementType;

public class MainActivity extends AppCompatActivity {

    List<ElementType> recyclerViewElementList = new ArrayList<>();

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
                if (monstersAdapter.getItemViewType(position) == ElementType.TITLE) {
                    return 2;
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(layoutManager);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_2);

//        ImageView imageView = findViewById(R.id.img);
//
//        Glide.with(this).load("http://localhost:8080/api/users/2.png").into(imageView);
    }

    private void setInitialData(){
        recyclerViewElementList.add(new Title());
        recyclerViewElementList.add(new Monster ("Вампиры", R.drawable.vampire));
        recyclerViewElementList.add(new Monster ("Духи и призраки", R.drawable.ghost));
        recyclerViewElementList.add(new Monster ("Дракониды", R.drawable.draconid));
        recyclerViewElementList.add(new Monster ("Реликты", R.drawable.relict));
        recyclerViewElementList.add(new Monster ("Огры", R.drawable.ogr));
        recyclerViewElementList.add(new Monster ("Гибриды", R.drawable.gibrid));
    }
}